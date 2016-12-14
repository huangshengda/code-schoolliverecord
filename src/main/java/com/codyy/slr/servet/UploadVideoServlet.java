package com.codyy.slr.servet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.util.UUIDUtils;
import com.codyy.slr.vo.ReturnVoOne;
import com.codyy.slr.vo.UploadVo;

public class UploadVideoServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(UploadVideoServlet.class);

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReturnVoOne<UploadVo> one = new ReturnVoOne<UploadVo>();

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(2048 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		MyProgressListener getBarListener = new MyProgressListener(req);
		upload.setProgressListener(getBarListener);
		try {
			List<FileItem> formList = upload.parseRequest(req);
			Iterator<FileItem> formItem = formList.iterator();
			// 将进度监听器加载进去
			while (formItem.hasNext()) {
				FileItem item = (FileItem) formItem.next();
				if (item.isFormField()) {
					log.info("Field Name:" + item.getFieldName());
				} else {
					String original = item.getName();
					original = (original == null) ? "" : original;
					String suffix = "";
					if (original != null) {
						int x = original.lastIndexOf('.');
						if (x >= 0) {
							suffix = original.substring(x);
						}
					}
					suffix = suffix.toLowerCase();
					if (!Constants.UPLOAD_VIDEO_TYPE.contains(suffix)) {
						one.setCode(Constants.FAILED);
						one.setMsg("文件格式不支持上传");
						resp.getWriter().write(JSONObject.toJSONString(one));
						log.error("file not surpported");
						return;
					}
					String resourceId = UUIDUtils.getUUID();
					UploadVo uploadVo = new UploadVo();
					uploadVo.setResourceId(resourceId);
					File file = new File(Constants.TEMP + File.separatorChar + resourceId + suffix);

					OutputStream out = item.getOutputStream();
					InputStream in = item.getInputStream();
					req.getSession().setAttribute("outPutStream", out);
					req.getSession().setAttribute("inPutStream", in);
					item.write(file);
					one.setData(uploadVo);
					resp.getWriter().write(JSONObject.toJSONString(one));
				}
			}
		} catch (Exception e) {
			one.setCode(Constants.FAILED);
			one.setMsg("上传异常");
			resp.getWriter().write(JSONObject.toJSONString(one));
			e.printStackTrace();
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
