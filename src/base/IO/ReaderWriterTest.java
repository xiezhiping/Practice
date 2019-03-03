package base.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ReaderWriterTest {
	public static void main(String[] args) {
		String s = "�Ҿ�һ������ĳ���Ա";
		File file = new File("F:/java_workspace/Practice/src/base/IO/writer.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(s);
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
