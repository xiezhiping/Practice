package base.IO;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter("copy.txt");
			fw.write("这是一行测试代码\r\n");
			System.out.println("这是一条测试代码");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
