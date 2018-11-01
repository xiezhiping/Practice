package base.net.download;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownThread extends Thread {
	// ��ǰ�̵߳�����λ��
	private int startPos;
	// ���嵱ǰ�̸߳������ص��ļ���С
	private int currentPartSize;
	// ��ǰ�߳���Ҫ���ص��ļ���
	private RandomAccessFile currentPart;
	// ������߳����ص��ֽ���
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
			// ����startPos�ֽڣ�ֻ�����Լ��ǲ���
			is.skip(this.startPos);
			byte[] buffer = new byte[1024];
			int hasRead = 0;
			// ��ȡ�������ݣ�д���ı�
			while (length < currentPartSize && (hasRead = is.read(buffer)) != -1) {
				currentPart.write(buffer, 0, hasRead);
				// �ۼƸ��߳����ص��ܴ�С
				length += hasRead;
			}
			currentPart.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
