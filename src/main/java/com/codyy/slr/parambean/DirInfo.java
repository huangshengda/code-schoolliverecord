package com.codyy.slr.parambean;

/**  
 * @Description: 文件夹信息类
 * @author huangshengda  
 * @date 2016年12月14日   
 *  
*/
public class DirInfo {

	private String absPath;// 绝对路径
	private String relPath;// 相对路径

	public String getAbsPath() {
		return absPath;
	}

	public void setAbsPath(String absPath) {
		this.absPath = absPath;
	}

	public String getRelPath() {
		return relPath;
	}

	public void setRelPath(String relPath) {
		this.relPath = relPath;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DirInfo [absPath=");
		builder.append(absPath);
		builder.append(", relPath=");
		builder.append(relPath);
		builder.append("]");
		return builder.toString();
	}

}
