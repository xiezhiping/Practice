package base.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = new FileOutputStream("E:\\java_workspace\\Practice\\src\\base\\IO\\test.txt"); // 从节点取数据的节点流
			PrintStream ps = new PrintStream(fos); // 以节点流为构造参数的处理流
			ps.println("输出数据....");
			ps.println(new PrintStreamTest());
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
