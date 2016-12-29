package com.codyy.slr.servet;

import java.io.File;
import java.io.IOException;
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

public class UploadImageServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(UploadImageServlet.class);

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReturnVoOne<UploadVo> one = new ReturnVoOne<UploadVo>();
		// 1.判断req是否有效
		if (!ServletFileUpload.isMultipartContent(req)) {
			one.setCode(Constants.FAILED);
			one.setMsg("请求req无效");
			resp.getWriter().write(JSONObject.toJSONString(one));
			log.error("file not surpported");
			return;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2.设置存储路径
		factory.setRepository(new File(Constants.TEMP));
		// 3.设置缓存区容量
		factory.setSizeThreshold(1024 * 1024);
		// 4.通过工厂建立ServletFileUpload对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 5.设置精度监听
		MyProgressListener getBarListener = new MyProgressListener(req.getSession(), req.getParameter("sequence"));
		upload.setProgressListener(getBarListener);

		// 6.设置文件最大值
		upload.setFileSizeMax(Constants.MAX_UPLOAD_SIZE_IMAGE * 1024 * 1024L);
		// 7.设置文件编码
		upload.setHeaderEncoding("UTF-8");

		try {
			// 8.得到所有Form提交的表单记录
			List<FileItem> formList = upload.parseRequest(req);
			Iterator<FileItem> formItem = formList.iterator();
			while (formItem.hasNext()) {
				FileItem item = (FileItem) formItem.next();
				if (item.isFormField()) {
					// 表示一个普通Form元素
					log.info("Field Name:" + item.getFieldName());
				} else {
					// 表示文件域
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
					if (!Constants.UPLOAD_IMAGE_TYPE.contains(suffix)) {
						one.setCode(Constants.FAILED);
						one.setMsg("文件格式不支持上传");
						resp.getWriter().write(JSONObject.toJSONString(one));
						log.error("file not surpported");
						return;
					}
					UploadVo uploadVo = new UploadVo();
					String resourceId = UUIDUtils.getUUID();
					uploadVo.setResourceId(resourceId + suffix);
					File file = new File(Constants.TEMP + Constants.PATH_SEPARATOR + resourceId + suffix);

					item.write(file);
					one.setData(uploadVo);
					resp.getWriter().write(JSONObject.toJSONString(one));
				}
			}
		} catch (Exception e) {
			one.setCode(Constants.FAILED);
			one.setMsg("上传异常");
			resp.getWriter().write(JSONObject.toJSONString(one));
			log.error(e.toString());
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
