package com.codyy.slr.controller;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.parambean.SearchResourceParam;
import com.codyy.slr.service.DemandResService;
import com.codyy.slr.util.MySqlKeyWordUtils;
import com.codyy.slr.util.ParamUtils;
import com.codyy.slr.vo.ResourceVo;
import com.codyy.slr.vo.ReturnVoList;

/**
 * 
 * @Description: 点播资源 
 * @author huangshengda  
 * @date 2016年12月17日   
 *
 */

@Controller
@RequestMapping("/demand")
public class DemandResController {

	private static final Logger log = Logger.getLogger(DemandResController.class);

	@Autowired
	private DemandResService demandResService;

	/**
	 * 获取点播资源信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public ReturnVoList<ResourceVo> getDemandResPageList(Page page, SearchResourceParam param) {

		ReturnVoList<ResourceVo> result = null;
		String orderBy = param.getOrderBy();
		String orderType = param.getOrderType();
		if (StringUtils.isNotBlank(orderBy) && StringUtils.isNotBlank(orderType)) {
			boolean isLegal = true; // 判断参数是否合法
			if (StringUtils.equalsIgnoreCase(orderBy, "createTime") || StringUtils.equalsIgnoreCase(orderBy, "viewCnt")) {
				if (StringUtils.equalsIgnoreCase(orderType, Constants.DESC) || StringUtils.equalsIgnoreCase(orderType, Constants.ASC)) {

				} else {
					isLegal = false;
					result = new ReturnVoList<ResourceVo>(Constants.FAILED, "参数不合法", null);
				}
			} else {
				isLegal = false;
				result = new ReturnVoList<ResourceVo>(Constants.FAILED, "参数不合法", null);
			}

			if (!isLegal) {
				return result;
			}
		}

		if (StringUtils.isNotBlank(param.getResourceNameKey())) {
			param.setResourceNameKey(MySqlKeyWordUtils.MySqlKeyWordReplace(param.getResourceNameKey()));
		}

		try {
			Map<String, Object> paramMap = ParamUtils.bean2Map(param);
			page.setMap(paramMap);

			page = demandResService.getDemandResPageList(page);

			result = new ReturnVoList<ResourceVo>(page);
		} catch (Exception e) {
			result = new ReturnVoList<ResourceVo>(Constants.FAILED, "查询失败", null);
			log.error(e.toString());
		}

		return result;
	}
}
