package com.codyy.slr.upload;

import com.codyy.slr.vo.Progress;

/**
 * @author xierongbing
 * 用于ResourceServer 文件上传
 */
public class FileUploadProgressUtil {
	/**
	 * key的前缀
	 */
	private static String presfix = "upload_progress_";

	/**
	 * 根据sequence,来获取上传进度
	 */
	public static Progress getProgress(String sequence) {
		/*
		
		Progress progress = new Progress();
		if (!boundHashOperations.hasKey("pBytesRead")) {
		return progress;
		}
		progress.setBytesRead(Long.parseLong(boundHashOperations.get("pBytesRead")));
		progress.setContentLength(Long.parseLong(boundHashOperations.get("pContentLength")));
		progress.setItems(Integer.parseInt(boundHashOperations.get("pItems")));
		return progress;
		*/
		return null;
	}

	/**
	 * 根据sequence,来设置上传进度与
	 */
	public static void putProgress(String sequence, long pBytesRead, long pContentLength, int pItems) {
		/*
		BoundHashOperations<String, String, String> boundHashOperations = template.boundHashOps(presfix + sequence);
		boundHashOperations.put("pBytesRead", pBytesRead + "");
		boundHashOperations.put("pContentLength", pContentLength + "");
		boundHashOperations.put("pItems", pItems + "");
		boundHashOperations.expire(2, TimeUnit.HOURS);
		*/
	}
}
