package com.codyy.slr.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;

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
	
	public static void delFile(String fileStr) throws IOException {
		
		Path filePath =Paths.get(fileStr);
		Files.delete(filePath);
		
	}
	
	/**
	 * 
	 * @param fileList 返回查找到的文件目录列表
	 * @param dir 查找的路径
	 * @param regex 配的正则
	 * @return
	 * @throws IOException
	 */
	public static List<String> findSimilarFile(List<String> fileList,String dir, String regex) throws IOException {
		Iterator<Path> iterator = Files.newDirectoryStream(Paths.get(dir)).iterator();
		while(iterator.hasNext()) {
			File file = iterator.next().toFile();
			if(file.isDirectory()) {
				findSimilarFile(fileList,file.getPath(), regex);
			} else if(file.isFile()) {
				if(file.getName().matches(regex)) {
					fileList.add(file.getPath());
				}
			}
		}
		return fileList;
	}
}
