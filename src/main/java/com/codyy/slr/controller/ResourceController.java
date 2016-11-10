package com.codyy.slr.controller;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.entity.ResComment;
import com.codyy.slr.parambean.SearchResourceParam;
import com.codyy.slr.util.ParamUtil;
import com.codyy.slr.vo.ResCommentVo;
import com.codyy.slr.vo.ResourceVo;
import com.codyy.slr.vo.ReturnVoList;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 点播列表页面 我的课程页面 点播详情页
 * @author huangshengda
 *
 */


@Controller
@RequestMapping("/resource")
public class ResourceController {

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
	 * 获取资源评论(一级评论,二级评论前五条)
	 */
	@ResponseBody
	@RequestMapping("getResCommentPageList")
	public ReturnVoList<ResCommentVo> getResCommentPageList(Page page, String resourceId) {
		return null;
	}
	
	/**
	 * 获取资源二级评论
	 */
	@ResponseBody
	@RequestMapping("getResSubCommentPageList")
	public ReturnVoList<ResCommentVo> getbResSuCommentPageList(Page page,String parentCommentId){
			
		return null;
	}
	
	/**
	 * 添加资源评论
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("addResComment")
	public ReturnVoOne addResComment(ResComment resComment) {
		ReturnVoOne returnVoOne = new ReturnVoOne();
		return returnVoOne;
	}
	
	/**
	 * 删除资源评论
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("deleteResComment")
	public ReturnVoOne deleteResComment(ResComment resComment) {
		ReturnVoOne returnVoOne = new ReturnVoOne();
		return returnVoOne;
	}
}
