package com.codyy.slr.servet;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.servet.base.BaseServlet;

public class UploadBatchUserFileServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public UploadBatchUserFileServlet() {
		super(50, Constants.UPLOAD_BATCHUSER_FILE_TYPE);
	}

}
