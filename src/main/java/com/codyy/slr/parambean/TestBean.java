package com.codyy.slr.parambean;

import com.codyy.common.testUI.annotation.ApiModelProperty;

public class TestBean {
	@ApiModelProperty("����")
	private String name ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
