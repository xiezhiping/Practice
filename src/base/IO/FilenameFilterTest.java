package base.IO;

import java.io.File;

public class FilenameFilterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(".");
		// ����list���ղ�������ʵ����accept()������ʵ�ָ÷�������ָ���Լ��Ĺ���ָ����Щ�ļ�Ӧ����list()�г�:java�ļ����ļ��б��г�
		String[] nameList = file.list((dir, name) -> name.endsWith(".java") || new File(name).isDirectory());
		for (String name: nameList) {
			System.out.println(name);
		}
	}

}
