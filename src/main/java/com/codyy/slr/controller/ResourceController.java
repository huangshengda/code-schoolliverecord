package com.codyy.slr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.parambean.AddResourceParam;
import com.codyy.slr.parambean.SearchResourceParam;
import com.codyy.slr.service.ResourceService;
import com.codyy.slr.util.MySqlKeyWordUtils;
import com.codyy.slr.util.ParamUtils;
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

	/**
	 * 后台资源管理
	 * 
	 * @param page
	 * @return
	 * 
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public ReturnVoList<ResourceVo> getResourcePageList(Page page,
			SearchResourceParam param) {

		if (StringUtils.isNotBlank(param.getResourceNameKey())) {
			param.setResourceNameKey(MySqlKeyWordUtils
					.MySqlKeyWordReplace(param.getResourceNameKey()));
		}

		if (StringUtils.isNotBlank(param.getAuthorKey())) {
			param.setAuthorKey(MySqlKeyWordUtils.MySqlKeyWordReplace(param
					.getAuthorKey()));
		}
		
		ReturnVoList<ResourceVo> result = null;
		
		try{
			Map<String, Object> paramMap = ParamUtils.bean2Map(param);
			page.setMap(paramMap);

			page = resourceService.getResourcePageList(page);

			result = new ReturnVoList<ResourceVo>(page);
		}catch(Exception e){
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
	@RequestMapping(value = "/myResource/list", method = RequestMethod.POST)
	@ResponseBody
	public ReturnVoList<ResourceVo> getMyResourcePageList(Page page) {
		
		ReturnVoList<ResourceVo> result = null;
		
		try{
			
			page = resourceService.getMyResourcePageList(page);
			
			result = new ReturnVoList<ResourceVo>(page);
		}catch(Exception e){
			result = new ReturnVoList<ResourceVo>(Constants.FAILED, "查询失败", null);
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@RequestMapping("getRecommendResourceList")
	@ResponseBody
	public ReturnVoOne<List<ResourceVo>> getRecommendResourceList(String resourceId) {
		ResourceVo homeResourceListVo = new ResourceVo();
		ResourceVo homeResourceListVo1 = new ResourceVo();
		ResourceVo homeResourceListVo2 = new ResourceVo();

		List<ResourceVo> list = new ArrayList<ResourceVo>();
		list.add(homeResourceListVo);
		list.add(homeResourceListVo1);
		list.add(homeResourceListVo2);

		ReturnVoOne<List<ResourceVo>> returnList = new ReturnVoOne<List<ResourceVo>>(
				list);

		return returnList;
	}

	/**
	 * 删除资源(逻辑删除)
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/delete")
	public ReturnVoOne delResource(String resourceId) {
		ReturnVoOne result = null;
		try{
			resourceService.delResByResId(resourceId);
			result = new ReturnVoOne();
		}catch(Exception e){
			result = new ReturnVoOne(Constants.FAILED,"删除失败");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 添加资源
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("addResource")
	public ReturnVoOne addResource(AddResourceParam param) {
		ReturnVoOne returnVoOne = new ReturnVoOne();
		// 校验参数
		if (!param.validate()) {
			returnVoOne.setCode(Constants.FAILED);
			returnVoOne.equals("参数不合法");
			return returnVoOne;
		}

		boolean flag = resourceService.addResource(param);

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
	@RequestMapping(value="/update")
	public ReturnVoOne modifyResource(ResourceVo res) {
		ReturnVoOne result = null;
		try{
			if(resourceService.modifyResource(res)){
				result = new ReturnVoOne();
			}else{
				result = new ReturnVoOne(Constants.FAILED,"编辑资源失败");
			}
		}catch(Exception e){
			result = new ReturnVoOne(Constants.FAILED,"编辑资源失败");
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 依据资源ID获取资源详细信息
	 */
	@ResponseBody
	@RequestMapping(value="/get")
	public ReturnVoOne<ResourceVo> getResource(String resourceId) {
		ReturnVoOne<ResourceVo> result = null;
		try{
			ResourceVo resVo = resourceService.getResource(resourceId);
			result = new ReturnVoOne<ResourceVo>(resVo);
		}catch(Exception e){
			result = new ReturnVoOne<ResourceVo>(Constants.FAILED,"查询失败");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 点播资源播放
	 * @param resourceId
	 */
	@RequestMapping(value="/view")
	public void playResource(HttpServletRequest req, HttpServletResponse res, String resourceId){
		//TODO 未实行
	}
	
	/**
	 * 获取系统截图方法
	 * @param resourcePath
	 * @return
	 */
	@RequestMapping(value="/sysScreenShot/get")
	@ResponseBody
	public ReturnVoOne<String> sysScreenShot(String resourcePath){
		ReturnVoOne<String> result = null;
		try{
			//TODO 根据资源路径截图
			result = new ReturnVoOne<String>("thumb/wewwfsdfsdfasdfasfd.png");
		}catch(Exception e){
			result = new ReturnVoOne<String>(Constants.FAILED,"截图失败");
			e.printStackTrace();
		}
		return result;
	}
}
