package com.codyy.slr.service;

import static java.nio.file.StandardOpenOption.READ;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.codyy.slr.util.StringUtils;

/**
 * File Description      : 公共方法:图片、视频流下载
 * Author                : GuangY
 * Create Date           : 2016/11/18
 * Reviewed By           :
 * Reviewed Date         :
 * Modified By           :
 * Modified Date         :
 * Comments              :
 * CopyRight             : COPYRIGHT(c) www.codyy.com   All Rights Reserved(2016)
 * *******************************************************************************************
 */
@Service
public class CommonsService {

	private static final int BUFFER_LENGTH = 1024 * 16;
	private static final long EXPIRE_TIME = 1000 * 60 * 60 * 24;
	private static final Pattern RANGE_PATTERN = Pattern.compile("bytes=(?<start>\\d*)-(?<end>\\d*)");

	/**
	 * 把文件作为流返回给客服端
	 * @throws IOException 
	 */
	public void sendFileAsResponse(HttpServletRequest req, HttpServletResponse response, String storPath, String rootPath) throws IOException {

		String realPath = buildFilePath(storPath, rootPath);

		Path file = Paths.get(realPath);

		int length = (int) Files.size(file);
		int start = 0;
		int end = length - 1;

		String range = req.getHeader("Range");
		range = range == null ? "" : range;
		Matcher matcher = RANGE_PATTERN.matcher(range);

		if (matcher.matches()) {
			String startGroup = matcher.group("start");
			start = startGroup.isEmpty() ? start : Integer.valueOf(startGroup);
			start = start < 0 ? 0 : start;

			String endGroup = matcher.group("end");
			end = endGroup.isEmpty() ? end : Integer.valueOf(endGroup);
			end = end > length - 1 ? length - 1 : end;
		}

		int contentLength = end - start + 1;

		response.reset();
		response.setBufferSize(BUFFER_LENGTH);
		response.setHeader("Accept-Ranges", "bytes");
		response.setDateHeader("Last-Modified", Files.getLastModifiedTime(file).toMillis());
		response.setDateHeader("Expires", System.currentTimeMillis() + EXPIRE_TIME);
		// response.setContentType(Files.probeContentType(file));
		response.setContentType("application/x-download");
		response.setHeader("Content-Range", String.format("bytes %s-%s/%s", start, end, length));
		response.setHeader("Content-Length", String.format("%s", contentLength));
		if (StringUtils.isNotEmpty(range)) {
			response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
		}
		// 设置响应客户端内容类型

		int bytesRead;
		int bytesLeft = contentLength;
		ByteBuffer buffer = ByteBuffer.allocate(BUFFER_LENGTH);

		try (SeekableByteChannel input = Files.newByteChannel(file, READ); OutputStream output = response.getOutputStream();) {

			input.position(start);

			while ((bytesRead = input.read(buffer)) != -1 && bytesLeft > 0) {
				buffer.clear();
				output.write(buffer.array(), 0, bytesLeft < bytesRead ? bytesLeft : bytesRead);
				bytesLeft -= bytesRead;
			}
		}

	}

	/**
	 * 获取真实的文件路径
	 * @param storPath
	 * @param rootPath
	 * @param type
	 * @return
	 */
	public String buildFilePath(String storPath, String rootPath) {
		StringBuilder realPath = new StringBuilder();
		realPath.append(rootPath);
		realPath.append("/");
		realPath.append(storPath);
		return realPath.toString();
	}
}
