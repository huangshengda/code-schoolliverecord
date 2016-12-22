package com.codyy.slr.vo;

import java.util.List;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.DmsServer;

public class DmsServerVo extends DmsServer {

	private List<String> opt;

	private int sort;

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public List<String> getOpt() {
		return (opt == null ? Constants.EDIT_DELETE : opt);
	}

	public void setOpt(List<String> opt) {
		this.opt = opt;
	}
}
