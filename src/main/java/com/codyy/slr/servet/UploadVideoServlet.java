package com.codyy.slr.servet;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.servet.base.BaseServlet;

public class UploadVideoServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public UploadVideoServlet() {
		super(Constants.MAX_UPLOAD_SIZE_VIDEO, Constants.UPLOAD_VIDEO_TYPE);
	}

}
