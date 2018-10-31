package base.IO;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			// ʹ��FileOutputStream��ȡFileChannel
			FileChannel channel = new FileOutputStream("test.txt").getChannel();
			// ʹ�÷�������ʽ���ļ����м���
			FileLock lock = channel.tryLock();
			Thread.sleep(1000);
			lock.release();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
