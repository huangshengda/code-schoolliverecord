package com.codyy.slr.vo;

import java.io.Serializable;
import java.util.List;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;

public class ReturnVoList<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private int code;// 1:成功, 0:业务错误,
	private String msg;
	private List<T> data;
	private int totalDatas;
	// 分页页数
	private int totalPages;
	// 当前页
	private int curPage;

	public ReturnVoList() {
		this.msg="操作成功";
		this.code = Constants.SUCCESS;
	}
	
	public ReturnVoList(int code,String msg,List<T> list) {
		this.msg=msg;
		this.code = code;
		this.data = list;
	}
	
	@SuppressWarnings("unchecked")
	public ReturnVoList(Page page) {
		this.code = 1;
		this.msg = "操作成功";
		this.data = (List<T>) page.getData();
		this.totalDatas = (int) page.getTotalDatas();
		this.totalPages = page.getTotalPages();
		this.curPage = page.getCurPage();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotalDatas() {
		return totalDatas;
	}

	public void setTotalDatas(int totalDatas) {
		this.totalDatas = totalDatas;
	}
}
