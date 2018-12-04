package projects.DownUtil.Business;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import projects.DownUtil.DataLayer.HTTPHead;

public class DownloadThread extends Thread {
	// 定义文件资源的连接
	private String path;
	// 当前线程的下载位置
	private int startPos;
	// 定义当前线程负责下载文件的大小
	private int currentPartSize;
	// 当前线程需要下载的文件快
	private RandomAccessFile currentPart;
	// 定义该线程已下载的字节数
	private int length;
	public DownloadThread(int startPos, int currentPartSize, RandomAccessFile currentPart, String path) {
		this.startPos = startPos;
		this.currentPartSize = currentPartSize;
		this.currentPart = currentPart;
		this.path = path;
	}
	@Override
	public void run() {
		try {
			URL url = new URL(path);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(5*1000);
			connection.setRequestMethod(HTTPHead.METHOD);
			connection.setRequestProperty(HTTPHead.ACCEPT, "*/*");
			connection.setRequestProperty(HTTPHead.ACCEPT_LANGUAGE, "UTF-8");
			
			InputStream inputStream = connection.getInputStream();
			// 跳过startPos个字节，前面部分由其他线程下载
			inputStream.skip(this.startPos);
			byte[] buffer = new byte[1024];
			int hasRead = 0;
			// 读入网络数据并写入本地文件
			while(length < currentPartSize && (hasRead = inputStream.read(buffer)) != -1) {
				currentPart.write(buffer, 0 , hasRead); // 随机访问将缓冲buffer中的字节写入此文件，并从偏移量0开始到hasRead结束
				// 累计该线程下载的总大小
				length += hasRead;
			}
			currentPart.close();
			inputStream.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getStartPos() {
		return startPos;
	}
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	public int getCurrentPartSize() {
		return currentPartSize;
	}
	public void setCurrentPartSize(int currentPartSize) {
		this.currentPartSize = currentPartSize;
	}
	public RandomAccessFile getCurrentPart() {
		return currentPart;
	}
	public void setCurrentPart(RandomAccessFile currentPart) {
		this.currentPart = currentPart;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
