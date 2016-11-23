package com.codyy.slr.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.util.FileCopyUtils;

/**
 * 文件工具类
 * @author huangshengda
 *
 */
public class FileUtils {
	
	public static void copyFile(String oriFile, String desFile) throws IOException {
		
		FileOutputStream os=new FileOutputStream(new File(oriFile));
		FileSystemResource resource = new FileSystemResource(desFile);
		
		FileCopyUtils.copy(resource.getInputStream(),os);
		
	}
	
	public static void delFile(String filePath){
		
		File file = new File(filePath);
		file.delete();
		
	}
	
}
