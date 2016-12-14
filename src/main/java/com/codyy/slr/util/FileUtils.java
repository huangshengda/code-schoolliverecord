package com.codyy.slr.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.parambean.DirInfo;

/**
 * 文件工具类
 * 
 * @author huangshengda
 *
 */
public class FileUtils {

	public static void copyFile(String oriFile, String desFile) throws IOException {

		Path ori = Paths.get(oriFile);
		Path des = Paths.get(desFile);
		Files.copy(ori, des, StandardCopyOption.REPLACE_EXISTING);
	}

	public static void moveFile(String oriFile, String desFile) throws IOException {

		Path ori = Paths.get(oriFile);
		Path des = Paths.get(desFile);
		Files.move(ori, des, StandardCopyOption.ATOMIC_MOVE);
	}

	/**
	 * 删除文件
	 * 
	 * @param fileStr
	 * @throws IOException
	 */
	public static void delFile(String fileStr) throws IOException {
		Path filePath = Paths.get(fileStr);
		Files.delete(filePath);

	}

	/**
	 * 
	 * @param dir
	 *            文件夹
	 * @throws IOException
	 */
	public static void delDirectory(String dir) throws IOException {
		Path path = Paths.get(dir);
		DirectoryStream<Path> paths = Files.newDirectoryStream(path);
		for (Path p : paths) {
			Files.delete(p);
		}
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
	public static List<File> findSimilarFile(List<File> fileList, String dir, String regex) throws IOException {
		Iterator<Path> iterator = Files.newDirectoryStream(Paths.get(dir)).iterator();
		while (iterator.hasNext()) {
			File file = iterator.next().toFile();
			if (file.isDirectory()) {
				findSimilarFile(fileList, file.getPath(), regex);
			} else if (file.isFile()) {
				if (file.getName().matches(regex)) {
					fileList.add(file);
				}
			}
		}
		return fileList;
	}

	public static void sortFileByCreateTime(List<File> fileList) {
		if (fileList != null && fileList.size() > 0) {
			Collections.sort(fileList, new Comparator<File>() {
				public int compare(File file, File newFile) {
					if (file.lastModified() < newFile.lastModified()) {
						return -1;
					} else if (file.lastModified() == newFile.lastModified()) {
						return 0;
					} else {
						return 1;
					}
				}
			});
		}
	}

	public static List<String> fileListToFileStrList(List<File> fileList) {
		List<String> list = new ArrayList<>();
		for (File file : fileList) {
			list.add(file.getPath());
		}
		return list;
	}

	public static long getFileSize(String fileStr) {
		File file = new File(fileStr);
		if (file.exists() && file.isFile()) {
			return file.length();
		} else {
			return 0;
		}

	}

	/**
	 * 
	 * @param path
	 * @return absPath 绝对路径  relPath 相对路径  strDate日期字符串
	 * @throws IOException
	 */
	public static DirInfo creatDir(Date date, String path) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String strDate = sdf.format(date);
		String pathStr = path + Constants.PATH_SEPARATOR + strDate;
		Path dir = Paths.get(pathStr);
		if (!Files.exists(dir)) {
			Files.createDirectory(dir);
		}
		DirInfo info = new DirInfo();
		info.setRelPath(Constants.PATH_SEPARATOR + strDate);
		info.setAbsPath(pathStr);
		info.setStrDate(strDate);
		return info;
	}

	/**
	 * 创建文件
	 * 
	 * @param path
	 *            文件路径(绝对路径)
	 * @return
	 * @throws IOException
	 */
	public static boolean createFile(String path) throws IOException {
		boolean result = false;

		Path file = Paths.get(path);

		if (!Files.exists(file)) {
			Files.createFile(file);
			result = true;
		}

		return result;
	}

	/**
	 * 写入操作
	 * 
	 * @param paths
	 *            视频地址集合
	 * @param filePath
	 *            写入文件路径
	 * @throws IOException
	 */
	public static void writeToFileByLine(List<String> paths, String filePath) throws IOException {
		Path file = Paths.get(filePath);

		BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8);

		for (String path : paths) {
			writer.append("file '" + path + "'");
			writer.newLine();
		}

		writer.flush();
		writer.close();
	}
}
