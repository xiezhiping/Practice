package base.IO;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter("copy.txt");
			fw.write("test\r\n");
			System.out.println("����һ�����Դ���");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
