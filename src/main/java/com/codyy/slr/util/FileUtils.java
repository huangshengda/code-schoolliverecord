package com.codyy.slr.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
	
	/**
	 * 依据路径创建目录
	 * @param path
	 * @return
	 * @throws IOException 
	 */
	public static String creatDir(String path) throws IOException{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String strDate = sdf.format(date);
		
		Path dir = Paths.get(path + "/" + strDate);
		if(!Files.exists(dir)){
			Files.createDirectory(dir);
		}
		
		return strDate;
	}
}
