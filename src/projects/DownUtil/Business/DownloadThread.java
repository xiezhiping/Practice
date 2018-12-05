package projects.DownUtil.Business;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import projects.DownUtil.DataLayer.HTTPHead;

public class DownloadThread extends Thread {
	// �����ļ���Դ������
	private String path;
	// ��ǰ�̵߳�����λ��
	private long startPos;
	// ���嵱ǰ�̸߳��������ļ��Ĵ�С
	private long currentPartSize;
	// ��ǰ�߳���Ҫ���ص��ļ���
	private RandomAccessFile currentPart;
	// ������߳������ص��ֽ���
	private long length;
	public DownloadThread(long startPos, long currentPartSize, RandomAccessFile currentPart, String path) {
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
			// ����startPos���ֽڣ�ǰ�沿���������߳�����
			inputStream.skip(this.startPos);
			byte[] buffer = new byte[1024];
			int hasRead = 0;
			// �����������ݲ�д�뱾���ļ�
			while(length < currentPartSize && (hasRead = inputStream.read(buffer)) != -1) {
				currentPart.write(buffer, 0 , hasRead); // ������ʽ�����buffer�е��ֽ�д����ļ�������ƫ����0��ʼ��hasRead����
				// �ۼƸ��߳����ص��ܴ�С
				length += hasRead;
			}
			currentPart.close();
			inputStream.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public long getStartPos() {
		return startPos;
	}
	public void setStartPos(long startPos) {
		this.startPos = startPos;
	}
	public long getCurrentPartSize() {
		return currentPartSize;
	}
	public void setCurrentPartSize(long currentPartSize) {
		this.currentPartSize = currentPartSize;
	}
	public RandomAccessFile getCurrentPart() {
		return currentPart;
	}
	public void setCurrentPart(RandomAccessFile currentPart) {
		this.currentPart = currentPart;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
