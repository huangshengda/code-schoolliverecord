package com.codyy.slr.vo;

import java.io.Serializable;
import java.util.List;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;

public class ReturnVoList<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private int result;// 1:成功, 0:业务错误,
	private String msg;
	private List<T> data;
	private int count;
	private int totalDatas;

	// 分页页数
	private int totalPages;
	// 当前页
	private int curPage;

	public ReturnVoList() {
		this.msg="操作成功";
		this.result = Constants.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public ReturnVoList(Page page) {
		this.result = 1;
		this.data = (List<T>) page.getData();
		this.totalDatas = (int) page.getTotal();
		this.totalPages = page.getTotal();
		this.curPage = page.getEnd();
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
