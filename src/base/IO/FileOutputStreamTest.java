package base.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fis = new FileInputStream("E:\\java_workspace\\Practice\\src\\base\\IO\\FileOutputStreamTest.java");
			FileOutputStream fos = new FileOutputStream("E:\\java_workspace\\Practice\\src\\base\\IO\\Copy.java");
			byte[] bbuf = new byte[32];
			int hasRead = 0;
			while ((hasRead = fis.read(bbuf)) > 0) {
				// ����������ȡ�����ݣ�ÿ��һ�ξ�д���ļ��������������д����
				fos.write(bbuf, 0, hasRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
