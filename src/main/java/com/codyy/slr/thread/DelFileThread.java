package com.codyy.slr.thread;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import com.codyy.slr.util.FileUtils;

/**
 * 删除dms文件线程
 * @author huangshengda
 *
 */
public class DelFileThread implements Runnable{
	
	private final static Logger log = Logger.getLogger(DelFileThread.class); 
	
	private List<String> delFileList;
	
	public DelFileThread(List<String> delFileList) {
		super();
		this.delFileList = delFileList;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		log.info("delete dms video begin");
		if(!CollectionUtils.isEmpty(delFileList)){
			for (String fileStr : delFileList) {
				try {
					FileUtils.delFile(fileStr);
					log.info("delete "+ fileStr +" success.");
				} catch (IOException e) {
					log.info("delete "+ fileStr +" fail.");
					e.printStackTrace();
				}
			}
		}
		log.info("delete dms video end");
	}

	
}
