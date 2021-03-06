package com.codyy.slr.servet;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

public class MyProgressListener implements ProgressListener {
	private HttpSession session;

	private String sequence;

	public MyProgressListener(HttpSession session, String sequence) {
		this.session = session;
		this.sequence = sequence;
		FileUploadStatus status = new FileUploadStatus();
		session.setAttribute(sequence, status);
	}

	/* pBytesRead  到目前为止读取文件的比特数
	 * pContentLength 文件总大小
	 * pItems 目前正在读取第几个文件
	 */
	public void update(long pBytesRead, long pContentLength, int pItems) {
		FileUploadStatus status = (FileUploadStatus) session.getAttribute(this.sequence);
		status.setPBytesRead(pBytesRead);
		status.setPContentLength(pContentLength);
		status.setPItems(pItems);
	}

}
