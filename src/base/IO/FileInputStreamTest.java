package base.IO;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// �����ֽ�������
		FileInputStream fis = new FileInputStream("E:\\java_workspace\\Practice\\src\\base\\IO\\FileInputStreamTest.java");
		// ����һ������Ϊ1024������
		byte[] bbuf = new byte[1024];
		// ���ڱ���ʵ�ʶ�ȡ���ֽ���
		int hasRead = 0;
		// ʹ��ѭ��ʵ��ȡ����
		while ((hasRead = fis.read(bbuf)) > 0) {
			// ��������ȡ�����ݽ��ֽ�����תΪ�ַ�������
			System.out.println(new String(bbuf, 0, hasRead));
		}
		// �ر��ļ�������������finally���������ȫ
		fis.close();

	}

}
