package projects.DownUtil.Business;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import projects.DownUtil.DataLayer.DownloadTarget;
import projects.DownUtil.DataLayer.HTTPHead;

public class MultiThreadDownload {
	private static int DEFAULT_Thread_NUM = 1; // ����Ĭ���߳���
	// ����������Դ��·��
	private String path;
	// ָ�������ص��ļ��ı���λ��
	private String targetFile;
	// �������ص��̶߳���
	private static DownloadThread[] threads = new DownloadThread[DEFAULT_Thread_NUM];
	// ����ÿ���߳��������ݵ���ʼλ��
	private long[] startPos = new long[DEFAULT_Thread_NUM];
	// ����ÿ���߳��������ݵĽ�ֹλ��
	private long[] endPos = new long[DEFAULT_Thread_NUM];
	// �����ڵ�ǰ�߳����£������ļ���С��ÿ���̸߳���Part�Ĵ�С
	private long currentPartSize;
	// �������ص��ļ����ܴ�С
	private static long fileSize;
    // ͳ�ƶ���߳��Ѿ����ص��ܴ�С
	private static long sumSize = 0;
	
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
	public static int getCompleteRate() {
		for(int i = 0; i < DEFAULT_Thread_NUM;i++) {
			sumSize += threads[i].getLength();
		}
		// �����Ѿ���ɵİٷֱ�
		return (int)(sumSize * 1.0 / fileSize * 100);
	}
	private void setBreakPoint(long[] startPos, long[] endPos, File tempFile) {
		RandomAccessFile rantempFile = null;
		try {
			if (tempFile.exists()) {
				System.out.println("�ļ��Ѵ��ڣ���������...");
				rantempFile = new RandomAccessFile(tempFile, "rw");
				for (int i = 0; i < DEFAULT_Thread_NUM; i++) {
					rantempFile.seek(8*i + 8);
					startPos[i] = rantempFile.readLong();
					rantempFile.seek(8 * (i + 1000) + 16);
					endPos[i] = rantempFile.readLong();
                    System.out.println("thread" + (i + 1) + " startPos:"
                            + startPos[i] + ", endPos: " + endPos[i]);
				}
			} else {
                rantempFile = new RandomAccessFile(tempFile, "rw");
                
                //���һ���̵߳Ľ�ֹλ�ô�СΪ������Դ�Ĵ�С
                for (int i = 0; i < DEFAULT_Thread_NUM; i++) {
                    startPos[i] = currentPartSize * i;
                    if (i == DEFAULT_Thread_NUM - 1) {
                        endPos[i] = fileSize;
                    } else {
                        endPos[i] = currentPartSize * (i + 1) - 1;
                    }
 
                    rantempFile.seek(8 * i + 8);
                    rantempFile.writeLong(startPos[i]);
                    rantempFile.seek(8 * (i + 1000) + 16);
                    rantempFile.writeLong(endPos[i]);
                    System.out.println("thread" + (i + 1) + " startPos:"
                            + startPos[i] + ", endPos: " + endPos[i]);
			}
		}
			} 
		catch (FileNotFoundException e) {
		e.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			try {
				if (rantempFile != null) {
					rantempFile.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}	
}

