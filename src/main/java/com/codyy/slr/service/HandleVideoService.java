package com.codyy.slr.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.util.FileUtils;
import com.codyy.slr.util.HostConfigUtils;
import com.codyy.slr.util.UUIDUtils;

@Service
public class HandleVideoService {
	private static Log log = LogFactory.getLog(HandleVideoService.class);

	// ffmpeg绝对路径
	private static final String PATH;

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

	/**
	 * 获取系统截图
	 * 
	 * @param req
	 * @param videoPath
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Map<String, String> getUpoadScreenShot(HttpServletRequest req, String videoPath) throws IOException, InterruptedException {
		Map<String, String> map = new HashMap<String, String>();
		String contextpath = HostConfigUtils.getHost(req) + "/download/img/" + Constants.IMG_TEMP;
		String resId = StringUtils.split(videoPath, ".")[0];
		videoPath = Constants.TEMP + "/" + videoPath;

		List<String> imgs = null;

		// 截图失败尝试次数
		for (int i = 0; i < Constants.SHOT_IMG_TIMES; i++) {
			imgs = getShotImgs(videoPath, resId, Constants.SHOT_NUM, Constants.TEMP);
			if (imgs != null && !imgs.isEmpty()) {
				break;
			}
		}

		for (String img : imgs) {
			map.put(img, contextpath + "/" + img);
		}

		return map;
	}

	/**
	 * 生成视频截图
	 * 
	 * @param videoPath
	 *            视频路径
	 * @param resId
	 *            资源ID
	 * @param imgNum
	 *            截图图片张数
	 * @return
	 * @throws ExecuteException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public List<String> getShotImgs(String videoPath, String resId, int imgNum, String desDir) throws ExecuteException, IOException, InterruptedException {
		List<String> list = new ArrayList<String>();

		int videoTime = getVideoTime(videoPath);

		if (videoTime >= 1) {

			String startTime = "1"; // 截图开始开始时间
			String rnum = "1"; // 每隔1秒截一张图
			String endTime = "" + (imgNum * 10); // 截图终止时间

			if (imgNum == 1) { // 只截一张图
				if (videoTime >= 5) { // 视频总时长大于5秒,取第5秒的图片
					startTime = "5";
					endTime = "1";
				} else { // 视频总时长小于5秒,去第一秒的图片
					endTime = "1";
				}
			} else { // 截多张图
				rnum = "0.1"; // 每隔10秒截一张图
			}

			CommandLine cmdLine = new CommandLine(PATH);
			cmdLine.addArgument("-ss");
			cmdLine.addArgument(startTime);
			cmdLine.addArgument("-i");
			cmdLine.addArgument(videoPath);
			cmdLine.addArgument("-y");
			cmdLine.addArgument("-f");
			cmdLine.addArgument("image2");
			cmdLine.addArgument("-r");
			cmdLine.addArgument(rnum);
			cmdLine.addArgument("-t");
			cmdLine.addArgument(endTime);
			cmdLine.addArgument(desDir + "/" + resId + "_%3d.png");

			DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
			DefaultExecutor executor = new DefaultExecutor();
			executor.setExitValue(0);

			ExecuteWatchdog watchdog = new ExecuteWatchdog(Constants.SHOT_IMG_TIME * 1000);
			executor.setWatchdog(watchdog);
			executor.execute(cmdLine, resultHandler);
			resultHandler.waitFor();

			if (executor.isFailure(resultHandler.getExitValue())) {
				log.error(videoPath + ":截图失败");
			}

			if (watchdog.killedProcess()) {
				log.error(videoPath + ":截图超时");
			}
		}

		Path dir = Paths.get(desDir);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, resId + "_*.png")) {
			for (Path e : stream) {
				list.add(e.getFileName().toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 获取视频总时间
	 * 
	 * @param viedo_path
	 *            视频路径
	 * @return
	 */
	private int getVideoTime(String videoPath) {
		CommandLine commands = new CommandLine(PATH);
		commands.addArgument("-i");
		commands.addArgument(videoPath);

		try {

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			ByteArrayOutputStream errorStream = new ByteArrayOutputStream();

			PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream, errorStream);

			DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
			DefaultExecutor executor = new DefaultExecutor();
			executor.setExitValue(0);

			ExecuteWatchdog watchdog = new ExecuteWatchdog(Constants.SHOT_IMG_TIME * 1000);
			executor.setWatchdog(watchdog);
			executor.setStreamHandler(streamHandler);
			executor.execute(commands, resultHandler);
			resultHandler.waitFor();

			String out = outputStream.toString();

			String error = errorStream.toString();

			log.info("out:" + out);
			log.error("error:" + error);

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
	 * 
	 * @return
	 */
	private static Boolean isLinux() {
		String os = System.getProperty("os.name").toLowerCase();
		Boolean isLinux = os.indexOf("linux") >= 0 ? true : false;
		return isLinux;
	}

	/**
	 * 合并视频对外接口
	 * 
	 * @param paths
	 *            视频列表
	 * @param outPath
	 *            输出路径
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean concatVideos(List<String> paths, String outPath) throws IOException, InterruptedException {
		boolean result = false;

		String fileList = Constants.TEMP + File.separator + UUIDUtils.getUUID() + ".txt";

		if (FileUtils.createFile(fileList)) {
			FileUtils.writeToFileByLine(paths, fileList);

			if (concatVideo(fileList, outPath)) {
				result = true;
			}
		}

		return result;
	}

	/**
	 * 合并视频(具体操作命令与业务无关)
	 * 
	 * @param fileList
	 *            视频列表
	 * @param outPath
	 *            输出路径
	 * @throws ExecuteException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private boolean concatVideo(String fileList, String outPath) throws ExecuteException, IOException, InterruptedException {
		boolean result = true;

		if (!isLinux()) {
			fileList = fileList.replace("/", "\\");
		}

		CommandLine cmdLine = new CommandLine(PATH);
		cmdLine.addArgument("-f");
		cmdLine.addArgument("concat");
		cmdLine.addArgument("-y");
		cmdLine.addArgument("-safe");
		cmdLine.addArgument("0");
		cmdLine.addArgument("-i");
		cmdLine.addArgument(fileList);
		cmdLine.addArgument("-c");
		cmdLine.addArgument("copy");
		cmdLine.addArgument(outPath);

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(0);

		ExecuteWatchdog watchdog = new ExecuteWatchdog(Constants.CONCAT_VIDEO_TIME * 1000);
		executor.setWatchdog(watchdog);
		executor.execute(cmdLine, resultHandler);
		resultHandler.waitFor();

		if (executor.isFailure(resultHandler.getExitValue())) {
			log.error(outPath + ":合并失败");
			result = false;
		}

		if (watchdog.killedProcess()) {
			log.error(outPath + ":合并超时");
			result = false;
		}

		return result;
	}
}
