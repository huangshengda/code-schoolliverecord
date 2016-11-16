package com.codyy.slr.common.page;

import java.util.List;
import java.util.Map;

public class Page {
	private int totalDatas; // 总条数

	private int curPage; // 当前页

	private int pageSize = 20; // 每页显示条数(默认每页条数)

	private int totalPages; // 总页数

	private Map<String, Object> map; // 查询条件

	private List<?> data; // 分页结果

	private boolean isPaging = true; // 是否需要分页

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public boolean isPaging() {
		return isPaging;
	}

	public void setPaging(boolean isPaging) {
		this.isPaging = isPaging;
	}

	public int getTotalDatas() {
		return totalDatas;
	}

	public void setTotalDatas(int totalDatas) {
		this.totalDatas = totalDatas;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		totalPages = totalDatas == 0 ? 0 : ((totalDatas-1)/pageSize)+1;
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
