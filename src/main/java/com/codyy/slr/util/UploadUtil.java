package com.codyy.slr.util;



public class UploadUtil {
	
	public static String createFilename(String filename){
		String suffix = "";
		if (StringUtils.isNotBlank(filename)){
			int p = filename.lastIndexOf('.');
			if ( p >= 0 ){
				suffix = filename.substring(p);
			}
		}
		String randFileName = UUIDUtils.getUUID() + suffix;
		
		return randFileName;
		
	}
	

	
	
}
