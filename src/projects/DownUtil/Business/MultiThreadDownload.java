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
	// �������ص��̶߳���
	private DownloadThread[] threads = new DownloadThread[DEFAULT_Thread_NUM];
	// ����ÿ���߳��������ݵ���ʼλ��
	private long[] startPos = new long[DEFAULT_Thread_NUM];
	// ����ÿ���߳��������ݵĽ�ֹλ��
	private long[] endPos = new long[DEFAULT_Thread_NUM];
	// �����ڵ�ǰ�߳����£������ļ���С��ÿ���̸߳���Part�Ĵ�С
	private long currentPartSize;
	// �������ص��ļ����ܴ�С
	private long fileSize;
	
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
		fileSize = connection.getContentLengthLong(); // �ҿ�����������ȡ���ȷ�����ʵ�֣�һ������int������ΧΪ-1������һ�������˴���
		System.out.println("fileSize::" + fileSize);
		connection.disconnect(); // ָʾ���ڷ�����������ܻ�����������
		currentPartSize = fileSize % DEFAULT_Thread_NUM == 0 ? fileSize / (DEFAULT_Thread_NUM) : fileSize / (DEFAULT_Thread_NUM);
		RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
		// ���ñ����ļ��Ĵ�С
		if (fileSize > 0) {
			file.setLength(fileSize);
		} else {
			throw new Exception("�ļ���СΪ������������Ƿ���ȷ���߼���Ƿ��ļ���С������Χ");
		}
		file.close();
		for (int i = 0; i < DEFAULT_Thread_NUM; i ++) {
			// ����ÿ���߳����صĿ�ʼλ��
			long startPos = i*currentPartSize;
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
		long sumSize = 0;
		for(int i = 0; i < DEFAULT_Thread_NUM;i++) {
			sumSize += threads[i].getLength();
		}
		// �����Ѿ���ɵİٷֱ�
		return sumSize * 1.0 / fileSize;
	}
}
