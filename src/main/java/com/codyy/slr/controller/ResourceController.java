package com.codyy.slr.controller;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.parambean.AddResourceParam;
import com.codyy.slr.parambean.SearchResourceParam;
import com.codyy.slr.service.ResourceService;
import com.codyy.slr.util.ParamUtil;
import com.codyy.slr.vo.ResourceVo;
import com.codyy.slr.vo.ReturnVoList;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 点播列表页面 我的课程页面 点播详情页 后台管理
 * @author huangshengda
 *
 */


@Controller
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	
	
	/**
	 * 点播列表页面资源 我的课程资源列表
	 * @param page
	 * @return
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping("getResourcePageList")
	@ResponseBody
	public ReturnVoList<ResourceVo> getResourcePageList(Page page,SearchResourceParam param) throws Exception{
		Map<String, Object> paramMap = ParamUtil.bean2Map(param);
		page.setMap(paramMap);
		ResourceVo homeResourceListVo= new ResourceVo();
		ResourceVo homeResourceListVo1= new ResourceVo();
		ResourceVo homeResourceListVo2= new ResourceVo();

		
		List<ResourceVo> list = new ArrayList<ResourceVo>();
		list.add(homeResourceListVo);
		list.add(homeResourceListVo1);
		list.add(homeResourceListVo2);
		
		page.setData(list);
		
		ReturnVoList<ResourceVo> returnList = new ReturnVoList<ResourceVo>(page);
		
		return returnList;
	}
	
	@RequestMapping("getRecommendResourceList")
	@ResponseBody
	public ReturnVoOne<List<ResourceVo>> getRecommendResourceList(){
		ResourceVo homeResourceListVo= new ResourceVo();
		ResourceVo homeResourceListVo1= new ResourceVo();
		ResourceVo homeResourceListVo2= new ResourceVo();

		
		List<ResourceVo> list = new ArrayList<ResourceVo>();
		list.add(homeResourceListVo);
		list.add(homeResourceListVo1);
		list.add(homeResourceListVo2);
		
		
		ReturnVoOne<List<ResourceVo>> returnList = new ReturnVoOne<List<ResourceVo>>(list);
		
		return returnList;
	}
	
	/**
	 * 删除资源
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("delResource")
	public ReturnVoOne delResource(String resourceId) {
		resourceService.delResByResId(resourceId);
		return new ReturnVoOne();
	}
	
	/**
	 * 添加资源
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("addResource")
	public ReturnVoOne addResource(AddResourceParam param) {
		ReturnVoOne returnVoOne = new ReturnVoOne();
		//校验参数
		if(!param.validate()){
			returnVoOne.setCode(Constants.FAILED);
			returnVoOne.equals("参数不合法");
		}
		
		boolean flag = resourceService.addResource(param);
		
		if(!flag){
			returnVoOne.setCode(Constants.FAILED);
			returnVoOne.setMsg("添加资源失败");
		}
		
		return returnVoOne;
	}
	
	/**
	 * 编辑资源
	 */
	@ResponseBody
	@RequestMapping("modifyResource")
	public ReturnVoOne modifyResource() {
		ReturnVoOne returnVoOne = new ReturnVoOne();
		return returnVoOne;
	}
}
