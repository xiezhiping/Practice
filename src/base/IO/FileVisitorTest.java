package base.IO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// ����·��Ŀ¼�����е��ļ�����Ŀ¼
		Files.walkFileTree(Paths.get("e:", "java_workspace", "Practice"), new SimpleFileVisitor<Path>() {
			// �����ļ�ʱ�����÷���
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println("\t���ڷ��ʣ�" + file + "�ļ�");
				// �ҵ�FileVisitorTest.java�ļ�
				if (file.endsWith("README.md")) {
					System.out.println("--�Ѿ��ҵ�Ŀ¼�ļ�--" + file);
					return FileVisitResult.CONTINUE;
				} else {
					return FileVisitResult.CONTINUE;
				}
				
			}
			// ��ʼ����Ŀ¼ʱ����
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
				System.out.println("\t���ڷ��ʣ�" + dir + "·��");
				return FileVisitResult.CONTINUE;
			}
		});

	}

}
