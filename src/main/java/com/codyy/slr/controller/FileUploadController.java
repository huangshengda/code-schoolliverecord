package com.codyy.slr.controller;

import org.springframework.stereotype.Controller;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author huangshengda  
 * @date 2016年12月13日   
 *  
*/
@Controller
public class FileUploadController {
	/*
	Logger log = Logger.getLogger(FileUploadController.class);
	
	*//** 
		* upload  上传文件 
		* @param request 
		* @param response 
		* @return 
		* @return 
		* @throws Exception 
		*/
	/*
	@RequestMapping(value = "/video/upload", method = RequestMethod.POST)
	public void upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
	final HttpSession hs = request.getSession();
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if (!isMultipart) {
		response.getWriter().write("final");
		return;
	}
	// Create a factory for disk-based file items
	FileItemFactory factory = new DiskFileItemFactory();
	
	// Create a new file upload handler
	ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setProgressListener(new ProgressListener() {
		public void update(long pBytesRead, long pContentLength, int pItems) {
			ProcessInfo pri = new ProcessInfo();
			pri.itemNum = pItems;
			pri.readSize = pBytesRead;
			pri.totalSize = pContentLength;
			pri.show = pBytesRead + "/" + pContentLength + " byte";
			pri.rate = Math.round(new Float(pBytesRead) / new Float(pContentLength) * 100);
			hs.setAttribute("proInfo", pri);
		}
	});
	List<FileItem> items = upload.parseRequest(request);
	String path = request.getSession().getServletContext().getRealPath("upload");
	System.out.println(path);
	for (FileItem item : items) {
		if (item.isFormField()) {
	
		} else {
			System.out.println(path + "/" + item.getFieldName());
			File targetFile = new File(Constants.TEMP + Constants.PATH_SEPARATOR + "1.mp4");
			if (!targetFile.exists()) {
				targetFile.createNewFile();
			}
			item.write(targetFile);
		}
	}
	System.out.println("上传文件的个数为：" + items.size());
	response.getWriter().write("success");
	}
	
	*//** 
		* process 获取进度 
		* @param request 
		* @param response 
		* @return 
		* @throws Exception 
		*/
	/*
	@RequestMapping(value = "/progress")
	@ResponseBody
	public Object process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	return (ProcessInfo) request.getSession().getAttribute("proInfo");
	}
	
	class ProcessInfo {
	public long totalSize = 1;
	public long readSize = 0;
	public String show = "";
	public int itemNum = 0;
	public int rate = 0;
	}
	
	*/}
