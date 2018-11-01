package base.net.download;

import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownUtil {
	// 定义下载资源的路径
	private static String path;
	// 指定所下载资源的保存位置
	private String targetFile;
	// 定义需要使用多少线程下载资源
	private int threadNum;
	// 定义下载的线程对象
	private DownThread[] threads;
	// 定义下载的文件总大小
	private int fileSize;
	
	public DownUtil(String path, String targetFile, int threadNum) {
		this.path = path;
		this.targetFile = targetFile;
		this.threadNum = threadNum;
		// 初始化threads数组
		threads = new DownThread[threadNum];
	}
	// 在原本设计中，DownThread类是作为内部类，故在这里提供了path的get、set方法
	public static String getPath( ) {
		return DownUtil.path;
	}
	public static void setPath(String path) {
		DownUtil.path = path;
	}
	// download方法
	public void download() throws Exception {
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5*1000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "image/gif"); // TODO
		conn.setRequestProperty("Accept-Language", "zh-CN");
		conn.setRequestProperty("Charset", "UTF-8");
		conn.setRequestProperty("Connection", "Keep-Alive");
		// 得到文件大小
		fileSize = conn.getContentLength();
		conn.disconnect();
		int currentPartSize = fileSize / threadNum + 1;
		RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
		// 设置本地文件的大小
		file.setLength(fileSize);
		file.close();
		for (int i =0; i < threadNum; i++) {
			// 计算每个线程下载的开始位置
			int startPos = i*currentPartSize;
			// 每个线程使用RandomAccessFile进行下载
			RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
			// 定位该线程的下载位置
			currentPart.seek(startPos);
			// 创建下载线程
			threads[i] = new DownThread(startPos, currentPartSize, currentPart);
			// 启动下载线程
			threads[i].start();
		}
	}
	// 获取下载完成的百分比
	public double getCompleteRate() {
		// 统计多个线程下载的总大小
		int sumSize = 0;
		for (int i = 0; i < threadNum; i++) {
			sumSize += threads[i].length;
		}
		// 返回完成百分比
		return sumSize*1.0/fileSize;
	}
}
