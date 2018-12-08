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
	private static int DEFAULT_Thread_NUM = 1; // 设置默认线程数
	// 定义下载资源的路径
	private String path;
	// 指定所下载的文件的保存位置
	private String targetFile;
	// 定义下载的线程对象
	private static DownloadThread[] threads = new DownloadThread[DEFAULT_Thread_NUM];
	// 保存每个线程下载数据的起始位置
	private long[] startPos = new long[DEFAULT_Thread_NUM];
	// 保存每个线程下载数据的截止位置
	private long[] endPos = new long[DEFAULT_Thread_NUM];
	// 定义在当前线程数下，根据文件大小，每个线程负责Part的大小
	private long currentPartSize;
	// 定义下载的文件的总大小
	private static long fileSize;
    // 统计多个线程已经下载的总大小
	private static long sumSize = 0;
	
	// 启动多线程下载时，传入的是一个包含url（文件来源）等信息的DownloadTarget对象
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
		// 得到下载文件的总大小
		fileSize = connection.getContentLengthLong(); // 我看了下两个获取长度方法的实现，一个返回int（超范围为-1），另一个则作了处理
		System.out.println("fileSize::" + fileSize);
		connection.disconnect(); // 指示近期服务器不大可能会有其他请求
		currentPartSize = fileSize % DEFAULT_Thread_NUM == 0 ? fileSize / (DEFAULT_Thread_NUM) : fileSize / (DEFAULT_Thread_NUM);
		RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
		// 设置本地文件的大小
		if (fileSize > 0) {
			file.setLength(fileSize);
		} else {
			throw new Exception("文件大小为负，检查链接是否正确或者检查是否文件大小超出范围");
		}
		file.close();
		for (int i = 0; i < DEFAULT_Thread_NUM; i ++) {
			// 计算每个线程下载的开始位置
			long startPos = i*currentPartSize;
			// 每个线程使用一个RandomAccessFile进行下载
			RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
			// 定义该线程的下载位置
			currentPart.seek(startPos);
			// 创建下载线程
			threads[i] = new DownloadThread(startPos, currentPartSize, currentPart, path);
			// 启动下载线程
			threads[i].start();
		}
	}
	public static int getCompleteRate() {
		for(int i = 0; i < DEFAULT_Thread_NUM;i++) {
			sumSize += threads[i].getLength();
		}
		// 返回已经完成的百分比
		return (int)(sumSize * 1.0 / fileSize * 100);
	}
	private void setBreakPoint(long[] startPos, long[] endPos, File tempFile) {
		RandomAccessFile rantempFile = null;
		try {
			if (tempFile.exists()) {
				System.out.println("文件已存在，继续下载...");
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
                
                //最后一个线程的截止位置大小为请求资源的大小
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

