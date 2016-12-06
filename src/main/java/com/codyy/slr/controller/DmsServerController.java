package com.codyy.slr.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public ReturnVoList<DmsServerVo> getDmsServerList(String dmsServerName) {
		int code = Constants.SUCCESS;
		int i = 0;
		String msg = "查询成功";
		List<DmsServerVo> dmsServerList = new ArrayList<DmsServerVo>();
		try {
			dmsServerList = dmsServerService.getDmsServerList(dmsServerName);
			for (DmsServerVo dmsServerVo : dmsServerList) {
				dmsServerVo.setSort(++i);
			}
		} catch (Exception e) {
			code = Constants.FAILED;
			msg = "查询失败";
			e.printStackTrace();
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
			e.printStackTrace();
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
		dmsServerService.delDmsServer(serverId);
		msg = "删除失败";
		code = Constants.FAILED;

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
		try {
			List<DmsServerVo> list = dmsServerService.getDmsServerList(dmsServer.getServerName());
			if (list.size() == 0) {
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
			e.printStackTrace();
		}
		return new ReturnVoOne<DmsServer>(code, msg);
	}

}
