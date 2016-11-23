package com.codyy.slr.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.FileSystemResource;
import org.springframework.util.FileCopyUtils;

/**
 * 文件工具类
 * @author huangshengda
 *
 */
public class FileUtils {
	
	public static void copyFile(String oriFile, String desFile) throws IOException {
		
		Path ori =Paths.get(oriFile);
		Path des =Paths.get(desFile);
		Files.copy(ori, des,StandardCopyOption.REPLACE_EXISTING);
		
	}
	
	public static void delFile(String fileStr) throws IOException{
		Path filePath =Paths.get(fileStr);
		Files.delete(filePath);
	}
	
}
