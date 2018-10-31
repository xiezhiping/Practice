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
		// 遍历路径目录下所有的文件和子目录
		Files.walkFileTree(Paths.get("e:", "java_workspace", "Practice"), new SimpleFileVisitor<Path>() {
			// 访问文件时触发该方法
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println("\t正在访问：" + file + "文件");
				// 找到FileVisitorTest.java文件
				if (file.endsWith("README.md")) {
					System.out.println("--已经找到目录文件--" + file);
					return FileVisitResult.CONTINUE;
				} else {
					return FileVisitResult.CONTINUE;
				}
				
			}
			// 开始访问目录时触发
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
				System.out.println("\t正在访问：" + dir + "路径");
				return FileVisitResult.CONTINUE;
			}
		});

	}

}
