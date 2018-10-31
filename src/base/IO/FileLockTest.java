package base.IO;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			// 使用FileOutputStream获取FileChannel
			FileChannel channel = new FileOutputStream("test.txt").getChannel();
			// 使用非阻塞方式对文件进行加锁
			FileLock lock = channel.tryLock();
			Thread.sleep(1000);
			lock.release();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
