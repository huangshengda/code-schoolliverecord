package com.codyy.slr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.vo.HomeLiveListVo;
import com.codyy.slr.vo.ResourceListVo;
import com.codyy.slr.vo.ReturnVoList;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 首页controller
 * @author huangshengda
 *
 */


@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("getHomeLivePageList")
	@ResponseBody
	public ReturnVoList<HomeLiveListVo> getHomeLivePageList(Page page){
		
		HomeLiveListVo homeLiveListVo= new HomeLiveListVo("湖水","一年级","语文","张三");
		HomeLiveListVo homeLiveListVo1= new HomeLiveListVo("湖水","一年级","语文","李四");
		HomeLiveListVo homeLiveListVo2= new HomeLiveListVo("湖水","一年级","语文","王五");
		HomeLiveListVo homeLiveListVo3= new HomeLiveListVo("湖水","一年级","语文","赵六");
		
		List<HomeLiveListVo> list = new ArrayList<HomeLiveListVo>();
		list.add(homeLiveListVo);
		list.add(homeLiveListVo1);
		list.add(homeLiveListVo2);
		list.add(homeLiveListVo3);
		
		page.setData(list);
		
		ReturnVoList<HomeLiveListVo> returnResult = new ReturnVoList<HomeLiveListVo>(page);
		return returnResult;
	}
	
	@RequestMapping("getHomeResourceList")
	@ResponseBody
	public ReturnVoOne<List<ResourceListVo>> getHomeResourceList(){
		
		ResourceListVo homeResourceListVo= new ResourceListVo("湖水","一年级","语文","张三",1,"image");
		ResourceListVo homeResourceListVo1= new ResourceListVo("湖水","一年级","语文","张三",2,"image");
		ResourceListVo homeResourceListVo2= new ResourceListVo("湖水","一年级","语文","张三",3,"image");

		
		List<ResourceListVo> list = new ArrayList<ResourceListVo>();
		list.add(homeResourceListVo);
		list.add(homeResourceListVo1);
		list.add(homeResourceListVo2);
		
		ReturnVoOne<List<ResourceListVo>> returnVoOne = new ReturnVoOne<List<ResourceListVo>>(list);
		return returnVoOne;
	}
	
}
