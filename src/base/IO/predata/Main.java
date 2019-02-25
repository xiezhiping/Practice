package base.IO.predata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		File file = new File("F:\\java_workspace\\Practice\\src\\base\\IO\\predata\\resource\\data.txt");
		FileReader fd = new FileReader(file);
		BufferedReader br = new BufferedReader(fd);
		String s = "";
		StringBuilder sb = new StringBuilder();
		String sub1 = "";
		String sub2 = "";
		// ¶Á
		while((s = br.readLine()) != null) {
			sub1 = s.split(":")[0];
			sub2 = s.split(":")[1];
			if ("front".equals(sub2) == false) {
				sub2 = "front";
			}
			sb.append(sub1 + ":" + sub2 + "\n");
		}
		System.out.println(sb.toString());
		// Ð´
		File f = new File("F:\\java_workspace\\Practice\\src\\base\\IO\\predata\\resource\\result.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
