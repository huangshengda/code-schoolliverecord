package com.codyy.slr.vo;

/**
 * 首页主播列表返回体
 * @author huangshengda
 *
 */
public class HomeLiveListVo {
	
	private String name;
	private String classlevelName;
	private String subjectName;
	private String author;
	
	public HomeLiveListVo(){
		
	}
	
	public HomeLiveListVo(String name, String classlevelName, String subjectName, String author) {
		super();
		this.name = name;
		this.classlevelName = classlevelName;
		this.subjectName = subjectName;
		this.author = author;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClasslevelName() {
		return classlevelName;
	}
	public void setClasslevelName(String classlevelName) {
		this.classlevelName = classlevelName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
