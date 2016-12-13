package com.codyy.slr.controller;

import org.springframework.stereotype.Controller;

/**
 * 
 * @Description: 上传
 * @author bingshaowen 
 * @date 2016年12月6日   
 *
 */
@Controller
public class NewUploadController {
	/*
	
	Logger log = Logger.getLogger(NewUploadController.class);
	
	*//**
		* 
		* @Description: 视频上传
		* @param file
		* @param sequence
		* @param request
		* @return
		*
		*/
	/*
	
	@ResponseBody
	@RequestMapping("video/upload")
	public void videoUpload(String sequence, HttpServletRequest req, HttpServletResponse resp) throws IOException {
	
	ReturnVoOne<UploadVo> one = new ReturnVoOne<UploadVo>();
	
	CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	resolver.setDefaultEncoding("UTF-8");
	resolver.setMaxUploadSize(Constants.MAX_UPLOAD_SIZE_VIDEO * 1024 * 1024);
	MultipartHttpServletRequest multiRequest = null;
	try {
	resolver.setServletContext(WebcontentThreadLocal.getVal().getSession().getServletContext());
	resolver.setMaxInMemorySize(1024 * 1024);
	// 放入零时文件夹
	resolver.setUploadTempDir(new FileSystemResource(Constants.IMG_TEMP));
	multiRequest = resolver.resolveMultipart(WebcontentThreadLocal.getVal());
	} catch (IllegalArgumentException exx) {
	one.setCode(Constants.FAILED);
	one.setMsg("创建文件夹失败");
	WebContext.write(JSONObject.toJSONString(one));
	log.error("Given uploadTempDir could not be created");
	return;
	} catch (MaxUploadSizeExceededException e) {
	one.setCode(Constants.FAILED);
	one.setMsg("上传文件太大");
	WebContext.write(JSONObject.toJSONString(one));
	log.error("multiFile is big");
	return;
	} catch (MultipartException ex) {
	one.setCode(Constants.FAILED);
	one.setMsg("上传请求被取消");
	WebContext.write(JSONObject.toJSONString(one));
	log.error("uploading request is supposed to be cancelled");
	return;
	}
	
	Collection<MultipartFile> files = multiRequest.getFileMap().values();
	if (files == null || files.size() == 0) {
	one.setCode(Constants.FAILED);
	one.setMsg("文件是为空");
	resp.getWriter().write(JSONObject.toJSONString(one));
	log.error("uploaded file is empty");
	return;
	}
	MultipartFile multiFile = files.iterator().next();
	
	String original = multiFile.getOriginalFilename();
	original = (original == null) ? "" : original;
	String suffix = "";
	int x = original.lastIndexOf('.');
	if (x >= 0) {
	suffix = original.substring(x);
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
	
	// 开始传输
	multiFile.transferTo(file);
	one.setData(uploadVo);
	resp.getWriter().write(JSONObject.toJSONString(one));
	}
	
	*//**
		* 
		* @Description: 上传进度
		* @param filename
		* @param filesize
		* @param sequence
		* @param request
		* @return
		*
		*/
	/*
	
	@RequestMapping("/progress")
	public void uploadFile(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") CommonsMultipartFile file) throws IOException {
	response.setContentType("text/html");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out;
	boolean flag = false;
	if (file.getSize() > 0) {
	// 文件上传的位置可以自定义
	flag = FileUploadUtil.uploadFile(request, file);
	}
	out = response.getWriter();
	if (flag == true) {
	out.print("1");
	} else {
	out.print("2");
	}
	}
	
	@ModelAttribute
	public void initRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
	WebContext.setRequest(request);
	WebContext.setResponse(response);
	}
	
	*/}
