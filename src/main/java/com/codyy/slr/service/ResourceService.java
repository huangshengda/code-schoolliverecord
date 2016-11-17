package com.codyy.slr.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

import static java.nio.file.StandardOpenOption.READ;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.dao.ResourceMapper;
import com.codyy.slr.entity.Resource;
import com.codyy.slr.parambean.AddResourceParam;
import com.codyy.slr.util.UUIDUtils;
import com.codyy.slr.vo.HomeLiveVo;
import com.codyy.slr.vo.ResourceVo;

@Service
public class ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;

	public boolean addResource(AddResourceParam param) {
		boolean flag = true;
		Resource resource = param.toResource();
		String resourceId = UUIDUtils.getUUID();
		resource.setResourceId(resourceId);
		resource.setCreateTime(new Date());
		resource.setSourceType(Constants.UPLOAD);
		resource.setViewCnt(0L);
		resource.setLivingFlag(Constants.N);
		resource.setSize(param.getSize());

		int num = resourceMapper.addResource(resource);
		if (num == 1) {
			String[] classlevelIdList = param.getClasslevelIds().split(",");
			List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();
			for (String string : classlevelIdList) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("resourceId", resourceId);
				map.put("classlevelId", string);
				paramList.add(map);
			}
			int num1 = resourceMapper.addResIdClslevelIdList(paramList);
			if (num1 != paramList.size()) {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}

	// 依据资源ID逻辑删除资源
	public int delResByResId(String resourceId) {
		Resource res = new Resource();
		res.setResourceId(resourceId);
		// TODO 缺少获取UserID的方法
		res.setDeleteUserId("");
		res.setDeleteTime(new Date());

		return resourceMapper.delResByResId(res);
	}

	// 获取所有直播课程信息
	public List<HomeLiveVo> getHomeLiveList() {
		return resourceMapper.getHomeLiveList();
	}

	// 获取资源列表
	public Page getResourcePageList(Page page) {
		List<ResourceVo> list = resourceMapper.getResourcePageList(page);
		if (list.size() >= 1) {
			Map<String, Object> map = page.getMap();
			if (map != null && !map.isEmpty()) {
				Object sourceType = map.get("sourceType");
				// 判断资源类型是否为空,不为空则为查询数据赋值查看、编辑、删除操作
				if (sourceType != null
						&& StringUtils.isNotBlank(sourceType.toString())) {
					for (ResourceVo resourceVo : list) {
						resourceVo.setOpt(Constants.VIEW_EDIT_DELETE);
					}
				}
			}
		}
		page.setData(list);
		return page;
	}

	// 获取我的课程资源列表
	public Page getMyResourcePageList(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		// TODO 缺少获取userId方法
		map.put("createUserId", "userId");

		page.setMap(map);

		List<ResourceVo> list = resourceMapper.getResourcePageList(page);
		if (list.size() >= 1) {
			for (ResourceVo resourceVo : list) {
				resourceVo.setOpt(Constants.DELETE);
			}
		}
		page.setData(list);
		return page;
	}

	// 根据资源ID获取资源
	public ResourceVo getResource(String resourceId) {
		return resourceMapper.getResource(resourceId);
	}

	// 更新资源信息
	public boolean modifyResource(ResourceVo res) {
		boolean result = false;
		String resourceId = res.getResourceId();

		int delResult = resourceMapper.delResIDRClslevelID(resourceId);

		if (delResult == 1) {
			int mResult = resourceMapper.modifyResource(res);
			if (mResult == 1) {
				if (StringUtils.isNotBlank(res.getClasslevelId())) {
					String[] ids = res.getClasslevelId().split(",");
					List<Map<String, String>> list = new ArrayList<Map<String, String>>();
					for (String id : ids) {
						Map<String, String> map = new HashMap<String, String>();
						map.put("resourceId", resourceId);
						map.put("classlevelId", id);
						list.add(map);
					}
					int addResult = resourceMapper.addResIdClslevelIdList(list);
					if (addResult == list.size()) {
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	public void processRequest(final HttpServletRequest request, final HttpServletResponse response, String resourcePath) throws IOException {

	    String videoFilename = URLDecoder.decode(request.getParameter("video"), "UTF-8");
	    Path video = Paths.get(videoPath, videoFilename);

	    int length = (int) Files.size(video);
	    int start = 0;
	    int end = length - 1;

	    String range = request.getHeader("Range");
	    range=range==null?"":range;
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
	    response.setHeader("Content-Disposition", String.format("inline;filename=\"%s\"", videoFilename));
	    response.setHeader("Accept-Ranges", "bytes");
	    response.setDateHeader("Last-Modified", Files.getLastModifiedTime(video).toMillis());
	    response.setDateHeader("Expires", System.currentTimeMillis() + EXPIRE_TIME);
	    response.setContentType(Files.probeContentType(video));
	    response.setHeader("Content-Range", String.format("bytes %s-%s/%s", start, end, length));
	    response.setHeader("Content-Length", String.format("%s", contentLength));
	    response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);

	    int bytesRead;
	    int bytesLeft = contentLength;
	    ByteBuffer buffer = ByteBuffer.allocate(BUFFER_LENGTH);

	    try (SeekableByteChannel input = Files.newByteChannel(video, READ);
	            OutputStream output = response.getOutputStream()) {

	      input.position(start);

	      while ((bytesRead = input.read(buffer)) != -1 && bytesLeft > 0) {
	        buffer.clear();
	        output.write(buffer.array(), 0, bytesLeft < bytesRead ? bytesLeft : bytesRead);
	        bytesLeft -= bytesRead;
	      }
	    }
	  }
	
	private static final int BUFFER_LENGTH = 1024 * 16;
	private static final long EXPIRE_TIME = 1000 * 60 * 60 * 24;
	private static final Pattern RANGE_PATTERN = Pattern.compile("bytes=(?<start>\\d*)-(?<end>\\d*)");
	private String videoPath;
}
