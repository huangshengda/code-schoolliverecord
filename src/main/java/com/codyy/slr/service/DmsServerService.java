package com.codyy.slr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.dao.DmsServerMapper;
import com.codyy.slr.entity.DmsServer;
import com.codyy.slr.util.UUIDUtils;
import com.codyy.slr.vo.DmsServerVo;

@Service
public class DmsServerService {
	@Autowired
	DmsServerMapper dmsServerMapper;

	public List<DmsServerVo> getDmsServerList(String dmsServerName) {
		return dmsServerMapper.getDmsServerList(dmsServerName);
	}

	public Map<String, Object> addDmsServer(DmsServer dmsServer) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = 0;
		int code = Constants.SUCCESS;
		String msg = "添加成功";
		List<DmsServerVo> list = dmsServerMapper.getDmsServerList(null);
		for (DmsServerVo dms : list) {
			if (dmsServer.getServerName().equals(dms.getServerName())) {
				count++;
			}
		}
		if (count == 0) {
			dmsServer.setServerId(UUIDUtils.getUUID());
			if (dmsServerMapper.insertSelective(dmsServer) != 1) {
				msg = "添加失败";
				code = Constants.FAILED;
			}
			;
		} else {
			msg = "学科名称重复";
			code = Constants.FAILED;
		}
		map.put("code", code);
		map.put("msg", msg);
		return map;
	}

	public int modifyDmsServer(DmsServer dmsServer) {
		return dmsServerMapper.updateByPrimaryKeySelective(dmsServer);
	}

	public void delDmsServer(String serverId) {
		dmsServerMapper.deleteByPrimaryKey(serverId);
	}

}
