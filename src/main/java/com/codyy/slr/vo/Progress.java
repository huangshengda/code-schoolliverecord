package com.codyy.slr.vo;

/**
 * 
 * @Description: 进度类  
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
public class Progress {

	private long pBytesRead;
	private long pContentLength;
	private long pItems;

	public long getpBytesRead() {
		return pBytesRead;
	}

	public void setpBytesRead(long pBytesRead) {
		this.pBytesRead = pBytesRead;
	}

	public long getpContentLength() {
		return pContentLength;
	}

	public void setpContentLength(long pContentLength) {
		this.pContentLength = pContentLength;
	}

	public long getpItems() {
		return pItems;
	}

	public void setpItems(long pItems) {
		this.pItems = pItems;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Progress [pBytesRead=");
		builder.append(pBytesRead);
		builder.append(", pContentLength=");
		builder.append(pContentLength);
		builder.append(", pItems=");
		builder.append(pItems);
		builder.append("]");
		return builder.toString();
	}

}
