package com.codyy.slr.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.User;
import com.codyy.slr.parambean.AddLiveResourceParam;
import com.codyy.slr.parambean.AddUploadResourceParam;
import com.codyy.slr.parambean.SearchResourceParam;
import com.codyy.slr.service.HandleLiveFinishService;
import com.codyy.slr.service.HandleVideoService;
import com.codyy.slr.service.ResourceService;
import com.codyy.slr.util.MySqlKeyWordUtils;
import com.codyy.slr.util.ParamUtils;
import com.codyy.slr.util.UUIDUtils;
import com.codyy.slr.vo.ResourceVo;
import com.codyy.slr.vo.ReturnVoList;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 点播列表页面 我的课程页面 点播详情页 后台管理
 * 
 * @author huangshengda
 *
 */

@Controller
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private HandleVideoService handleVideoService;

	@Autowired
	private HandleLiveFinishService handleLiveFinishService;

	/**
	 * 后台资源管理(上传、录制资源管理共用)
	 * 
	 * @param page
	 * @return
	 * 
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public ReturnVoList<ResourceVo> getResourcePageList(Page page, SearchResourceParam param) {
		if (StringUtils.isNotBlank(param.getResourceNameKey())) {
			param.setResourceNameKey(MySqlKeyWordUtils.MySqlKeyWordReplace(param.getResourceNameKey()));
		}

		if (StringUtils.isNotBlank(param.getAuthorKey())) {
			param.setAuthorKey(MySqlKeyWordUtils.MySqlKeyWordReplace(param.getAuthorKey()));
		}

		ReturnVoList<ResourceVo> result = null;

		try {
			Map<String, Object> paramMap = ParamUtils.bean2Map(param);
			page.setMap(paramMap);

			page = resourceService.getResourcePageList(page);

			result = new ReturnVoList<ResourceVo>(page);
		} catch (Exception e) {
			result = new ReturnVoList<ResourceVo>(Constants.FAILED, "查询失败", null);
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 我的课程资源列表
	 * 
	 * @param page
	 * @return
	 * 
	 */
	@RequestMapping(value = "/myresource/list", method = RequestMethod.POST)
	@ResponseBody
	public ReturnVoList<ResourceVo> getMyResourcePageList(HttpServletRequest req, Page page) {

		ReturnVoList<ResourceVo> result = null;

		try {

			page = resourceService.getMyResourcePageList(req, page);

			result = new ReturnVoList<ResourceVo>(page);
		} catch (Exception e) {
			result = new ReturnVoList<ResourceVo>(Constants.FAILED, "查询失败", null);
			e.printStackTrace();
		}

		return result;
	}

	// 推荐资源
	@RequestMapping("recommendresource/list")
	@ResponseBody
	public ReturnVoOne<List<ResourceVo>> getRecommendResourceList(String resourceId) {
		ReturnVoOne<List<ResourceVo>> ret = new ReturnVoOne<List<ResourceVo>>();
		try {
			List<ResourceVo> list = new ArrayList<>();

			ResourceVo resource = resourceService.getResource(resourceId);
			if (resource != null) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("subjectId", resource.getSubjectId());
				map.put("classlevelIds", resource.getClasslevelId());
				map.put("resourceId", resourceId);
				list = resourceService.getRecommendResourceList(map);
			}
			ret.setData(list);
		} catch (Exception e) {
			ret.setCode(Constants.FAILED);
			ret.setMsg("操作失败");
		}

		return ret;
	}

	/**
	 * 删除资源(逻辑删除)
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value = "/delete")
	public ReturnVoOne delResource(HttpServletRequest req, String resourceId) {
		ReturnVoOne result = null;
		try {
			resourceService.delResByResId(req, resourceId);
			result = new ReturnVoOne();
		} catch (Exception e) {
			result = new ReturnVoOne(Constants.FAILED, "删除失败");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 添加资源
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("addresource")
	public ReturnVoOne addResource(AddUploadResourceParam param, HttpServletRequest req) {
		ReturnVoOne returnVoOne = new ReturnVoOne();
		User user = (User) req.getAttribute("user");
		// 校验参数
		if (!param.validate()) {
			returnVoOne.setCode(Constants.FAILED);
			returnVoOne.equals("参数不合法");
			return returnVoOne;
		}

		boolean flag = resourceService.addResource(param, user.getUserId());

		if (!flag) {
			returnVoOne.setCode(Constants.FAILED);
			returnVoOne.setMsg("添加资源失败");
		}

		return returnVoOne;
	}

	/**
	 * 编辑保存资源
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value = "/update")
	public ReturnVoOne modifyResource(ResourceVo res) {
		ReturnVoOne result = null;
		try {
			if (resourceService.modifyResource(res)) {
				result = new ReturnVoOne();
			} else {
				result = new ReturnVoOne(Constants.FAILED, "编辑资源失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 依据资源ID获取资源详细信息
	 */
	@ResponseBody
	@RequestMapping(value = "/get")
	public ReturnVoOne<ResourceVo> getResource(String resourceId) {
		ReturnVoOne<ResourceVo> result = null;
		try {
			ResourceVo resVo = resourceService.getResource(resourceId);
			result = new ReturnVoOne<ResourceVo>(resVo);
		} catch (Exception e) {
			result = new ReturnVoOne<ResourceVo>(Constants.FAILED, "查询失败");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取系统截图方法
	 * @param resourcePath
	 * @return
	 */
	@RequestMapping(value = "/sysscreenshot/get")
	@ResponseBody
	public ReturnVoOne<List<Map<String, String>>> sysScreenShot(String resourcePath) {
		ReturnVoOne<List<Map<String, String>>> result = null;
		try {
			List<Map<String, String>> list = handleVideoService.getUpoadScreenShot(resourcePath);
			if (list != null && !list.isEmpty()) {
				result = new ReturnVoOne<List<Map<String, String>>>(list);
			} else {
				result = new ReturnVoOne<List<Map<String, String>>>(Constants.FAILED, "截图失败");
			}
		} catch (Exception e) {
			result = new ReturnVoOne<List<Map<String, String>>>(Constants.FAILED, "截图失败");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 添加直播信息
	 */
	@ResponseBody
	@RequestMapping("live/add")
	public ReturnVoOne<String> addLiveResource(AddLiveResourceParam param, String livePath) {
		ReturnVoOne<String> returnVoOne = new ReturnVoOne<String>();
		try {
			// 校验参数
			if (!param.validate() || StringUtils.isEmpty(livePath)) {
				returnVoOne.setCode(Constants.FAILED);
				returnVoOne.setMsg("参数不合法");
				return returnVoOne;
			}

			String liveResourceId = UUIDUtils.getUUID();
			boolean flag = resourceService.addLiveResource(param, liveResourceId, livePath);

			if (flag) {
				returnVoOne.setData(liveResourceId);
			} else {
				returnVoOne.setCode(Constants.FAILED);
				returnVoOne.setMsg("添加资源失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			returnVoOne.setCode(Constants.FAILED);
			returnVoOne.setMsg("添加资源失败");
		}

		return returnVoOne;
	}

	/**
	 * 获取直播是否结束 
	 */
	@ResponseBody
	@RequestMapping("live/hasfinish")
	public ReturnVoOne<String> hasFinish(String liveResourceId) {
		ReturnVoOne<String> returnVoOne = new ReturnVoOne<String>();
		try {
			ResourceVo res = resourceService.getResource(liveResourceId);
			String msg = Constants.NOT_FINISH;
			if ("N".equals(res.getLivingFlag())) {
				msg = Constants.FINISH;
			}
			returnVoOne.setData(msg);
		} catch (Exception e) {
			e.printStackTrace();
			returnVoOne.setCode(Constants.FAILED);
			returnVoOne.setMsg("获取信息失败");
		}
		return returnVoOne;
	}

	/**
	 * 结束直播课程
	 */
	@ResponseBody
	@RequestMapping("live/finish")
	public ReturnVoOne<String> finishLive(String liveResourceId) {
		ReturnVoOne<String> returnVoOne = new ReturnVoOne<String>();
		try {
			boolean flag = handleLiveFinishService.finishLive(liveResourceId);
			String msg = flag == true ? "结束课程成功" : "结束课程失败";
			returnVoOne.setMsg(msg);
		} catch (Exception e) {
			e.printStackTrace();
			returnVoOne.setCode(Constants.FAILED);
			returnVoOne.setMsg("结束课程异常");
		}
		return returnVoOne;
	}

}
