package com.codyy.slr.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.util.ConfigUtils;
import com.codyy.slr.util.FileUtils;
import com.codyy.slr.util.UUIDUtils;

@Service
public class SystemScreenShotService {
	private static Log log = LogFactory.getLog(SystemScreenShotService.class);
	
	private static final String PATH;
	private static final String IMG_PATH = ConfigUtils.getValue(Constants.IMG_PATH);

	static {
		String absolutePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		if (isLinux()) {
			absolutePath = absolutePath.replace("classes/", "");
			PATH = absolutePath + "lib/ffmpeg";
		} else {
			absolutePath = absolutePath.substring(1, absolutePath.indexOf("classes/"));
			PATH = absolutePath + "lib/ffmpeg.exe";
		}
	}

	public void getSysScreenShot(String videoPath, String resId, String type) throws IOException, InterruptedException {
		String imgsPath = IMG_PATH + "/" + FileUtils.creatDir(IMG_PATH);
		if (type.equals("living")) {
			getShotImgs(videoPath, imgsPath, resId, 1);
		} else {
			getShotImgs(videoPath, imgsPath, resId, 9);
		}
	}

	/**
	 * 生成视频截图
	 * @param videoPath
	 * @param imgsPath
	 * @param resId
	 * @param imgNum
	 * @return
	 * @throws ExecuteException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private List<String> getShotImgs(String videoPath, String imgsPath, String resId,int imgNum) throws ExecuteException, IOException, InterruptedException{
		List<String> list = new ArrayList<String>();
		
		int videoTime = getVideoTime(videoPath, PATH);
		
		if (videoTime >= 1) {
			
			String startTime = "1"; //截图开始开始时间
			String rnum = "1"; //每隔1秒截一张图
			String endTime = "" + (imgNum * 10); //截图终止时间
			
			if (imgNum == 1) { //只截一张图
				if (videoTime >=5 ) { //视频总时长大于5秒,取第5秒的图片
					startTime = "5";
					endTime = "5";
				} else { //视频总时长小于5秒,去第一秒的图片
					endTime = "1";
				}
			} else { //截多张图
				rnum = "0.1"; //每隔10秒截一张图
			}
			
			CommandLine cmdLine = new CommandLine(PATH);
			cmdLine.addArgument("-ss");
			cmdLine.addArgument(startTime);
			cmdLine.addArgument("-i");
			cmdLine.addArgument(videoPath);
			cmdLine.addArgument("-y");
			cmdLine.addArgument("-f");			cmdLine.addArgument("image2");
			cmdLine.addArgument("-r");
			cmdLine.addArgument(rnum);
			cmdLine.addArgument("-t");
			cmdLine.addArgument(endTime);
			cmdLine.addArgument(imgsPath + "/" + resId + "_%3d.jpg");
			
			DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
			DefaultExecutor executor = new DefaultExecutor();  
			executor.setExitValue(1);  
			
			ExecuteWatchdog watchdog = new ExecuteWatchdog(5000);
			executor.setWatchdog(watchdog);
			executor.execute(cmdLine,resultHandler); 
			resultHandler.waitFor(); 
		}
		
		Path dir = Paths.get(imgsPath);
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir, resId + "_*.jpg")){
			for(Path e : stream){
				list.add(e.getFileName().toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 获取视频总时间
	 * @param viedo_path	视频路径
	 * @param ffmpeg_path	ffmpeg路径
	 * @return
	 */
	private int getVideoTime(String videoPath, String ffmpegPath) {
		CommandLine commands = new CommandLine(ffmpegPath);
		commands.addArgument("-i");
		commands.addArgument(videoPath);
		
		try {

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			ByteArrayOutputStream errorStream = new ByteArrayOutputStream();

			PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream, errorStream);

			DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
			DefaultExecutor executor = new DefaultExecutor();
			executor.setExitValue(1);

			ExecuteWatchdog watchdog = new ExecuteWatchdog(5000);
			executor.setWatchdog(watchdog);
			executor.setStreamHandler(streamHandler);
			executor.execute(commands, resultHandler);
			resultHandler.waitFor();

			String out = outputStream.toString();

			String error = errorStream.toString();
			
			log.info("out:"+out);
			log.info("error:"+error);
			
			// 从视频信息中解析时长
			String regexDuration = "Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";
			Pattern pattern = Pattern.compile(regexDuration);
			Matcher m = pattern.matcher(error.toString());
			if (m.find()) {
				int time = getTimelen(m.group(1));
				log.info("视频时长：" + time + ", 开始时间：" + m.group(2) + ",比特率：" + m.group(3) + "kb/s");
				return time;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	// 格式:"00:00:10.68"
	private int getTimelen(String timelen) {
		int min = 0;
		String strs[] = timelen.split(":");
		if (strs[0].compareTo("0") > 0) {
			min += Integer.valueOf(strs[0]) * 60 * 60;// 秒
		}
		if (strs[1].compareTo("0") > 0) {
			min += Integer.valueOf(strs[1]) * 60;
		}
		if (strs[2].compareTo("0") > 0) {
			min += Math.round(Float.valueOf(strs[2]));
		}
		return min;
	}
	
	/**
	 * 判断系统是否是linux
	 * @return
	 */
	private static Boolean isLinux() {
		String os = System.getProperty("os.name").toLowerCase();
		Boolean isLinux  = os.indexOf("linux") >= 0 ? true:false;
		return isLinux;
	}
	
	public static void main(String[] args) throws IOException{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String str = sdf.format(date);
		System.out.println(str);
		Path dir = Paths.get("D:/imgs/"+str);
		if(!Files.exists(dir)){
			Files.createDirectory(dir);
		}
	}
}
