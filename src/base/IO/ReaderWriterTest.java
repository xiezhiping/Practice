package base.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ReaderWriterTest {
	public static void main(String[] args) {
		// write
		String s = "我就一有梦想的程序员\r\n陪我一起写代码";
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
		// read
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String ss;
			while((ss = br.readLine()) != null) {
				System.out.print(ss);
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
