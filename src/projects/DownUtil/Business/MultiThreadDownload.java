package projects.DownUtil.Business;

import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import projects.DownUtil.DataLayer.DownloadTarget;
import projects.DownUtil.DataLayer.HTTPHead;

public class MultiThreadDownload {
	private static int DEFAULT_Thread_NUM = 5; // ����Ĭ���߳���
	// ����������Դ��·��
	private String path;
	// ָ�������ص��ļ��ı���λ��
	private String targetFile;
	private DownloadTarget downloadTarget = null;
	// �������ص��̶߳���
	private DownloadThread[] threads = new DownloadThread[DEFAULT_Thread_NUM];
	// �����ڵ�ǰ�߳����£������ļ���С��ÿ���̸߳���Part�Ĵ�С
	private int currentPartSize;
	// �������ص��ļ����ܴ�С
	private int fileSize;
	
	// �������߳�����ʱ���������һ������url���ļ���Դ������Ϣ��DownloadTarget����
	public MultiThreadDownload(DownloadTarget downloadTarget) {
		this.path = downloadTarget.getUrl();
		this.targetFile = downloadTarget.getSavePath();
		System.out.println("targetFile::" + this.targetFile);
	}
	public void download() throws Exception {
		URL url = new URL(path);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setConnectTimeout(5*1000);
		connection.setRequestMethod(HTTPHead.METHOD);
		connection.setRequestProperty(HTTPHead.ACCEPT, "*/*");
		connection.setRequestProperty(HTTPHead.ACCEPT_LANGUAGE, "UTF-8");
		connection.setRequestProperty(HTTPHead.CONNECTION, "Keep-Alive");
		// �õ������ļ����ܴ�С
		fileSize = connection.getContentLength();
		connection.disconnect(); // ָʾ���ڷ�����������ܻ�����������
		currentPartSize = fileSize / (DEFAULT_Thread_NUM + 1);
		RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
		// ���ñ����ļ��Ĵ�С
		file.setLength(fileSize);
		file.close();
		for (int i = 0; i < DEFAULT_Thread_NUM; i ++) {
			// ����ÿ���߳����صĿ�ʼλ��
			int startPos = i*currentPartSize;
			// ÿ���߳�ʹ��һ��RandomAccessFile��������
			RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
			// ������̵߳�����λ��
			currentPart.seek(startPos);
			// ���������߳�
			threads[i] = new DownloadThread(startPos, currentPartSize, currentPart, path);
			// ���������߳�
			threads[i].start();
		}
		
	}
	public double getCompleteRate() {
		// ͳ�ƶ���߳��Ѿ����ص��ܴ�С
		int sumSize = 0;
		for(int i = 0; i < DEFAULT_Thread_NUM;i++) {
			sumSize += threads[i].getLength();
		}
		// �����Ѿ���ɵİٷֱ�
		return sumSize * 1.0 / fileSize;
	}
}
