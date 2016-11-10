package com.codyy.slr.vo;

import java.io.Serializable;

import com.codyy.slr.constant.Constants;

public class ReturnVoOne<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code; // 1:成功, 0:失败
	private String msg;
	private T data;

	public ReturnVoOne(T data) {
		this.code = Constants.SUCCESS;
		this.msg = "操作成功";
		this.data = data;
	}

	public ReturnVoOne() {
		this.msg = "操作成功";
		this.code = Constants.SUCCESS;
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
