package com.codyy.slr.vo;

import java.io.Serializable;

/**  
 * @Description: 菜单
 * @author huangshengda  
 * @date 2016年12月14日   
 *  
*/
public class MenuVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String url;;

	public MenuVo() {
		super();
	}

	public MenuVo(int id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
