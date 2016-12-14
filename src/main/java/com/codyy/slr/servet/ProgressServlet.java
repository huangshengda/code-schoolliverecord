package com.codyy.slr.servet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.vo.FileUploadStatus;
import com.codyy.slr.vo.ReturnVoOne;

public class ProgressServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		ReturnVoOne<Integer> one = new ReturnVoOne<Integer>();
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		FileUploadStatus status = (FileUploadStatus) session.getAttribute("status");
		try {
			if (status == null) {
				one.setData(0);
				response.getWriter().write(JSONObject.toJSONString(one));
			}
			response.reset();
			if (status.getPContentLength() == 0) {
				one.setData(0);
			} else {
				Double per = status.getPBytesRead() * 1.0 / status.getPContentLength() * 1.0 * 100;
				one.setData(per.intValue());
			}
			response.getWriter().write(JSONObject.toJSONString(one));
		} catch (IOException e) {
			one.setCode(Constants.FAILED);
			one.setMsg("获取进度失败");
			e.printStackTrace();
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.doPost(request, response);

	}
}
