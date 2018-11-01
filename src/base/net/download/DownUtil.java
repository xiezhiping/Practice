package base.net.download;

import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownUtil {
	// ����������Դ��·��
	private static String path;
	// ָ����������Դ�ı���λ��
	private String targetFile;
	// ������Ҫʹ�ö����߳�������Դ
	private int threadNum;
	// �������ص��̶߳���
	private DownThread[] threads;
	// �������ص��ļ��ܴ�С
	private int fileSize;
	
	public DownUtil(String path, String targetFile, int threadNum) {
		this.path = path;
		this.targetFile = targetFile;
		this.threadNum = threadNum;
		// ��ʼ��threads����
		threads = new DownThread[threadNum];
	}
	// ��ԭ������У�DownThread������Ϊ�ڲ��࣬���������ṩ��path��get��set����
	public static String getPath( ) {
		return DownUtil.path;
	}
	public static void setPath(String path) {
		DownUtil.path = path;
	}
	// download����
	public void download() throws Exception {
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5*1000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "image/gif"); // TODO
		conn.setRequestProperty("Accept-Language", "zh-CN");
		conn.setRequestProperty("Charset", "UTF-8");
		conn.setRequestProperty("Connection", "Keep-Alive");
		// �õ��ļ���С
		fileSize = conn.getContentLength();
		conn.disconnect();
		int currentPartSize = fileSize / threadNum + 1;
		RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
		// ���ñ����ļ��Ĵ�С
		file.setLength(fileSize);
		file.close();
		for (int i =0; i < threadNum; i++) {
			// ����ÿ���߳����صĿ�ʼλ��
			int startPos = i*currentPartSize;
			// ÿ���߳�ʹ��RandomAccessFile��������
			RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
			// ��λ���̵߳�����λ��
			currentPart.seek(startPos);
			// ���������߳�
			threads[i] = new DownThread(startPos, currentPartSize, currentPart);
			// ���������߳�
			threads[i].start();
		}
	}
	// ��ȡ������ɵİٷֱ�
	public double getCompleteRate() {
		// ͳ�ƶ���߳����ص��ܴ�С
		int sumSize = 0;
		for (int i = 0; i < threadNum; i++) {
			sumSize += threads[i].length;
		}
		// ������ɰٷֱ�
		return sumSize*1.0/fileSize;
	}
}
