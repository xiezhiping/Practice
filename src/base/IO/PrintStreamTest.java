package base.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = new FileOutputStream("E:\\java_workspace\\Practice\\src\\base\\IO\\test.txt"); // �ӽڵ�ȡ���ݵĽڵ���
			PrintStream ps = new PrintStream(fos); // �Խڵ���Ϊ��������Ĵ�����
			ps.println("�������....");
			ps.println(new PrintStreamTest());
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
