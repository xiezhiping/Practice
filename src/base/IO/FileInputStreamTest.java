package base.IO;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 创建字节输入流
		FileInputStream fis = new FileInputStream("E:\\java_workspace\\Practice\\src\\base\\IO\\FileInputStreamTest.java");
		// 创建一个长度为1024的容器
		byte[] bbuf = new byte[1024];
		// 用于保存实际读取的字节数
		int hasRead = 0;
		// 使用循环实现取数据
		while ((hasRead = fis.read(bbuf)) > 0) {
			// 从容器中取出数据将字节数组转为字符串输入
			System.out.println(new String(bbuf, 0, hasRead));
		}
		// 关闭文件输入流，放在finally块里面更安全
		fis.close();

	}

}
