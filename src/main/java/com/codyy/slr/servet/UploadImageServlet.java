package com.codyy.slr.servet;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.servet.base.BaseServlet;

public class UploadImageServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public UploadImageServlet() {
		super(Constants.MAX_UPLOAD_SIZE_IMAGE, Constants.UPLOAD_IMAGE_TYPE);
	}

}
