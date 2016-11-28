package com.codyy.slr.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 文件工具类
 * 
 * @author huangshengda
 *
 */
public class FileUtils {

	public static void copyFile(String oriFile, String desFile)
			throws IOException {

		Path ori = Paths.get(oriFile);
		Path des = Paths.get(desFile);
		Files.copy(ori, des, StandardCopyOption.REPLACE_EXISTING);

	}

	/**
	 * 删除文件
	 * @param fileStr
	 * @throws IOException
	 */
	public static void delFile(String fileStr) throws IOException {
		Path filePath = Paths.get(fileStr);
		Files.delete(filePath);

	}
	
	/**
	 * 
	 * @param dir 文件夹
	 * @throws IOException 
	 */
	public static void delDirectory(String dir) throws IOException{
		Path path = Paths.get(dir);
		DirectoryStream<Path> paths = Files.newDirectoryStream(path);  
		 for(Path p : paths){  
			 Files.delete(p);
		 }
	}
	
	public static void main(String[] args) throws IOException {
		delDirectory("e:/test");
	}

	/**
	 * 
	 * @param fileList
	 *            返回查找到的文件目录列表
	 * @param dir
	 *            查找的路径
	 * @param regex
	 *            配的正则
	 * @return
	 * @throws IOException
	 */
	public static List<String> findSimilarFile(List<String> fileList,
			String dir, String regex) throws IOException {
		Iterator<Path> iterator = Files.newDirectoryStream(Paths.get(dir))
				.iterator();
		while (iterator.hasNext()) {
			File file = iterator.next().toFile();
			if (file.isDirectory()) {
				findSimilarFile(fileList, file.getPath(), regex);
			} else if (file.isFile()) {
				if (file.getName().matches(regex)) {
					fileList.add(file.getPath());
				}
			}
		}
		return fileList;
	}

	/**
	 * 依据路径创建目录
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String creatDir(String path) throws IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String strDate = sdf.format(date);

		Path dir = Paths.get(path + "/" + strDate);
		if (!Files.exists(dir)) {
			Files.createDirectory(dir);
		}

		return strDate;
	}
}
