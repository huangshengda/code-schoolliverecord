package com.codyy.slr.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.DmsServer;
import com.codyy.slr.service.DmsServerService;
import com.codyy.slr.vo.DmsServerVo;
import com.codyy.slr.vo.ReturnVoList;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 
 * @Description: Dms服务器
 * @author bingshaowen 
 * @date 2016年12月6日   
 *
 */
@Controller
@RequestMapping("base/dmsserver")
public class DmsServerController {

	private static final Logger log = Logger.getLogger(DmsServerController.class);

	@Autowired
	DmsServerService dmsServerService;

	/**
	 * 
	 * @Description: 获取服务器
	 * @param dmsServerName
	 * @return
	 *
	 */
	@RequestMapping("list")
	@ResponseBody
	public ReturnVoList<DmsServerVo> getDmsServerList(Page page, String dmsServerName) {
		int code = Constants.SUCCESS;
		int i = 0;
		String msg = "查询成功";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dmsServerName", dmsServerName);
		page.setMap(map);
		List<DmsServerVo> dmsServerList = new ArrayList<DmsServerVo>();
		try {
			dmsServerList = dmsServerService.getDmsServerList(page);
			for (DmsServerVo dmsServerVo : dmsServerList) {
				dmsServerVo.setSort(++i);
			}
			page.setData(dmsServerList);
		} catch (Exception e) {
			code = Constants.FAILED;
			msg = "查询失败";
			log.error(e.toString());
		}
		return new ReturnVoList<DmsServerVo>(page, code, msg);
	}

	@RequestMapping("list/unpaged")
	@ResponseBody
	public ReturnVoList<DmsServerVo> getDmsServerListunpaged() {
		Page page = new Page();
		int code = Constants.SUCCESS;
		String msg = "查询成功";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dmsServerName", null);
		page.setMap(map);
		page.setPaging(false);
		List<DmsServerVo> dmsServerList = new ArrayList<DmsServerVo>();
		try {
			dmsServerList = dmsServerService.getDmsServerList(page);
		} catch (Exception e) {
			code = Constants.FAILED;
			msg = "查询失败";
			log.error(e.toString());
		}
		return new ReturnVoList<DmsServerVo>(code, msg, dmsServerList);
	}

	/**
	 * 
	 * @Description: 增加服务器
	 * @param dmsServer
	 * @return
	 *
	 */
	@RequestMapping("add")
	@ResponseBody
	public ReturnVoOne<DmsServer> addDmsServer(DmsServer dmsServer) {
		int code;
		String msg;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = dmsServerService.addDmsServer(dmsServer);
			code = Integer.parseInt(String.valueOf(map.get("code")));
			msg = String.valueOf(map.get("msg"));
		} catch (Exception e) {
			code = Constants.FAILED;
			msg = "操作失败";
			log.error(e.toString());
		}
		return new ReturnVoOne<DmsServer>(code, msg);
	}

	/**
	 * 
	 * @Description: 删除服务器
	 * @param serverId
	 * @return
	 *
	 */
	@RequestMapping("delete")
	@ResponseBody
	public ReturnVoOne<DmsServer> delDmsServer(String serverId) {
		int code = Constants.SUCCESS;
		String msg = "删除成功";
		try {
			dmsServerService.delDmsServer(serverId);
		} catch (Exception e) {
			msg = "删除失败";
			code = Constants.FAILED;
		}

		return new ReturnVoOne<DmsServer>(code, msg);
	}

	/**
	 * 
	 * @Description: 修改服务器名称
	 * @param dmsServer
	 * @return
	 *
	 */
	@RequestMapping("update")
	@ResponseBody
	public ReturnVoOne<DmsServer> modifyDmsServer(DmsServer dmsServer) {
		int code = Constants.SUCCESS;
		String msg = "编辑成功";
		Page page = new Page();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dmsServerName", dmsServer.getServerName());
		page.setMap(map);
		try {
			List<DmsServerVo> list = dmsServerService.getDmsServerList(page);
			if ((list.size() == 0) || ((list.size() == 1) && (dmsServer.getServerId().equals(list.get(0).getServerId())))) {
				dmsServer.setLastModifyTime(new Date());
				if (dmsServerService.modifyDmsServer(dmsServer) != 1) {
					msg = "编辑失败";
					code = Constants.FAILED;
				}
				;
			} else {
				msg = "服务器名称重复";
				code = Constants.FAILED;
			}
		} catch (Exception e) {
			code = Constants.FAILED;
			msg = "操作失败";
			log.error(e.toString());
			;
		}
		return new ReturnVoOne<DmsServer>(code, msg);
	}

}
