package com.codyy.slr.upload;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

import com.codyy.slr.vo.Progress;

/**

 * 功能描述： 文件上传进度<br>

 */

public class FileUploadProgressListener implements ProgressListener {
	private HttpSession session;

	public void update(long pBytesRead, long pContentLength, int pItems) {
		Progress status = (Progress) session.getAttribute("status");
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		status.setpBytesRead(pBytesRead);
		status.setpContentLength(pContentLength);
		status.setpItems(pItems);

	}

	public FileUploadProgressListener(HttpSession session) {
		this.session = session;
		Progress status = new Progress();// 保存上传状态
		session.setAttribute("status", status);
	}
}
