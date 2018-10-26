package base.IO;

import java.io.File;

public class FilenameFilterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(".");
		// 下面list接收参数部分实现了accept()方法，实现该方法就是指定自己的规则，指定那些文件应该由list()列出:java文件和文件夹被列出
		String[] nameList = file.list((dir, name) -> name.endsWith(".java") || new File(name).isDirectory());
		for (String name: nameList) {
			System.out.println(name);
		}
	}

}
