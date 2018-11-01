package base.net.download;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownThread extends Thread {
	// 当前线程的下载位置
	private int startPos;
	// 定义当前线程负责下载的文件大小
	private int currentPartSize;
	// 当前线程需要下载的文件快
	private RandomAccessFile currentPart;
	// 定义该线程下载的字节数
	public int length;
	public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart) {
		this.startPos = startPos;
		this.currentPart = currentPart;
		this.currentPartSize = currentPartSize;
	}
	public void run() {
		try {
			URL url = new URL(DownUtil.getPath());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5*1000);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "image/gif");
			conn.setRequestProperty("Accept-Language", "zh-CN");
			conn.setRequestProperty("Charset", "UTF-8");
			InputStream is = conn.getInputStream();
			// 跳过startPos字节，只负责自己那部分
			is.skip(this.startPos);
			byte[] buffer = new byte[1024];
			int hasRead = 0;
			// 读取网络数据，写入文本
			while (length < currentPartSize && (hasRead = is.read(buffer)) != -1) {
				currentPart.write(buffer, 0, hasRead);
				// 累计该线程下载的总大小
				length += hasRead;
			}
			currentPart.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
