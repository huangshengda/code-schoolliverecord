package com.codyy.slr.servet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.vo.ReturnVoOne;

public class ProgressServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(ProgressServlet.class);

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		ReturnVoOne<Integer> one = new ReturnVoOne<Integer>();
		response.reset();
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		FileUploadStatus status = (FileUploadStatus) session.getAttribute(request.getParameter("sequence"));
		try {
			if (status == null) {
				one.setData(0);
				response.getWriter().write(JSONObject.toJSONString(one));
				return;
			}
			if (status.getPContentLength() == 0) {
				one.setData(0);
			} else {
				Double per = status.getPBytesRead() * 1.0 / status.getPContentLength() * 1.0 * 100;
				one.setData(per.intValue());
			}
		} catch (IOException e) {
			one.setCode(Constants.FAILED);
			one.setMsg("获取进度失败");
			log.error(e.toString());
		}
		try {
			response.getWriter().write(JSONObject.toJSONString(one));
		} catch (IOException e) {
			log.error(e.toString());
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.doPost(request, response);

	}
}
