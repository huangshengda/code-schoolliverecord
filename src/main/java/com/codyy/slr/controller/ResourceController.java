package com.codyy.slr.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
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
import com.codyy.slr.parambean.DirInfo;
import com.codyy.slr.parambean.SearchResourceParam;
import com.codyy.slr.service.HandleLiveFinishService;
import com.codyy.slr.service.HandleVideoService;
import com.codyy.slr.service.ResourceService;
import com.codyy.slr.util.FileUtils;
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

	private static final Logger log = Logger.getLogger(ResourceController.class);

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
			log.error(e.toString());
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
			log.error(e.toString());
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
			log.error(e.toString());
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

		boolean flag = resourceService.addResource(param, user.getUserId());

		if (!flag) {
			returnVoOne.setCode(Constants.FAILED);
			returnVoOne.setMsg("添加资源失败");
		}

		return returnVoOne;
	}

	/**
	 * 
	 * @Description: modifyResource  
	 * @param res
	 * @param resourceId
	 * @param thumbFlag 1表示新上传图片
	 * @return
	 *
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value = "/update")
	public ReturnVoOne modifyResource(AddUploadResourceParam res, String resourceId, String thumbFlag) {
		ReturnVoOne result = null;
		ResourceVo resVo = new ResourceVo();
		try {
			resVo.setResourceId(resourceId);
			resVo.setAuthor(res.getAuthor());
			resVo.setClasslevelId(res.getClasslevelIds());
			resVo.setSubjectId(res.getSubjectId());
			resVo.setResourceName(res.getResNickName());

			if ("1".equals(thumbFlag)) {
				// 1.创建图片文件夹
				DirInfo imageDirInfo = FileUtils.creatDir(new Date(), Constants.IMG_PATH);
				// 2.移动图片
				FileUtils.moveFile(Constants.TEMP + Constants.PATH_SEPARATOR + res.getThumbName(),
						imageDirInfo.getAbsPath() + Constants.PATH_SEPARATOR + res.getThumbName());
				resVo.setThumbPath(imageDirInfo.getRelPath() + Constants.PATH_SEPARATOR + res.getThumbName());
			}

			if (resourceService.modifyResource(resVo)) {
				result = new ReturnVoOne();
			} else {
				result = new ReturnVoOne(Constants.FAILED, "编辑资源失败");
			}
		} catch (Exception e) {
			result = new ReturnVoOne(Constants.FAILED, "编辑资源异常");
			log.error(e.toString());
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
			String thumbPath = resVo.getThumbPath();
			resVo.setThumbName(thumbPath.substring(thumbPath.lastIndexOf("/") + 1));
			String storePath = resVo.getStorePath();
			if (storePath != null) {
				resVo.setType(storePath.substring(storePath.lastIndexOf(".") + 1));
			}
			result = new ReturnVoOne<ResourceVo>(resVo);
		} catch (Exception e) {
			result = new ReturnVoOne<ResourceVo>(Constants.FAILED, "查询失败");
			log.error(e.toString());
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
			log.error(e.toString());
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

			String liveResourceId = UUIDUtils.getUUID();
			boolean flag = resourceService.addLiveResource(param, liveResourceId, livePath);

			if (flag) {
				returnVoOne.setData(liveResourceId);
			} else {
				returnVoOne.setCode(Constants.FAILED);
				returnVoOne.setMsg("添加资源失败");
			}

		} catch (Exception e) {
			log.error(e.toString());
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
			log.error(e.toString());
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
	public ReturnVoOne<String> finishLive(final String liveResourceId) {
		ReturnVoOne<String> returnVoOne = new ReturnVoOne<String>();
		try {
			boolean flag = resourceService.updateLiveResourceLivingPath(liveResourceId);
			log.info("liveResourceId =" + liveResourceId + ":更新数据库,直播路径设置为空.结果为:" + (flag == true ? "success" : "fail"));
			if (flag) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(Constants.CONTACT_VIODE_THREAD_WAIT_TIME * 1000);
						} catch (InterruptedException e) {
							log.error("liveResourceId =" + liveResourceId + " :合并视频,线程等待时间出错.");
							log.error(e.toString());
						}
						handleLiveFinishService.finishLive(liveResourceId);
					}
				}).start();

				returnVoOne.setMsg("结束课程成功");
			} else {
				returnVoOne.setMsg("结束课程失败,更新直播路径为空失败");
			}
		} catch (Exception e) {
			log.error(e.toString());
			returnVoOne.setCode(Constants.FAILED);
			returnVoOne.setMsg("结束课程异常");
		}
		return returnVoOne;
	}

	/**
	 * 资源阅览量加一
	 */
	@ResponseBody
	@RequestMapping("viewcnt/addone")
	public ReturnVoOne<Integer> addResViewCnt(String resourceId) {
		ReturnVoOne<Integer> one = new ReturnVoOne<Integer>();
		try {
			boolean flag = resourceService.addResViewCnt(resourceId);
			if (!flag) {
				one.setMsg("资源阅览量加一更新失败");
				one.setCode(Constants.FAILED);
			}
			int viewCnt = resourceService.getResource(resourceId).getViewCnt();
			one.setData(viewCnt);
		} catch (Exception e) {
			one.setCode(Constants.FAILED);
			one.setMsg("资源阅览量加一更新异常");
		}
		return one;
	}

	/**
	 * 资源下载量加一
	 */
	@ResponseBody
	@RequestMapping("downloadcnt/addone")
	public ReturnVoOne<Integer> addResDownloadCnt(String resourceId) {
		ReturnVoOne<Integer> one = new ReturnVoOne<Integer>();
		try {
			boolean flag = resourceService.addResDownloadCnt(resourceId);
			if (!flag) {
				one.setMsg("资源下载量加一更新失败");
				one.setCode(Constants.FAILED);
			}
			int downloadcnt = resourceService.getResource(resourceId).getDownloadCnt();
			one.setData(downloadcnt);
		} catch (Exception e) {
			one.setCode(Constants.FAILED);
			one.setMsg("资源下载量加一更新异常");
		}
		return one;
	}

	/**
	 * 获取结束课程时间差
	 */
	@ResponseBody
	@RequestMapping("difftime/get")
	public ReturnVoOne<Long> getServerTime() {
		ReturnVoOne<Long> one = new ReturnVoOne<Long>();
		try {
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.HOUR_OF_DAY, Constants.DIRECTOR_FINISH_HOUR);
			calendar.set(Calendar.MINUTE, Constants.DIRECTOR_FINISH_MIN);
			calendar.set(Calendar.SECOND, Constants.DIRECTOR_FINISH_SEC);
			one.setData(calendar.getTime().getTime() - date.getTime());
		} catch (Exception e) {
			one.setCode(Constants.FAILED);
			one.setMsg("获取服务器时间异常");
		}
		return one;
	}

}
