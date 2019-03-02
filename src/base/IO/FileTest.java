/**
 * File类相关知识的测试类
 */
package base.IO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.print.attribute.standard.Finishings;

public class FileTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        File file = new File(".");
        File file1 = new File("F:/java_workspace/Practice/src/base/IO/predata/resource/data.txt");
        FileInputStream fis = new FileInputStream(file1);
        byte[] read = new byte[1024];
        int len = fis.read(read);
        String s = new String(read, 0, len);
        System.out.println(s);
        byte[] write = s.getBytes();
        File file3 = new File("F:/java_workspace/Practice/src/base/IO/predata/resource/output.txt");
        FileOutputStream fos = new FileOutputStream(file3);
//        fos.write(write);
        
        // 缓冲流
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write(write);
        bos.close();
        bos.flush();
        System.out.println(file.getAbsolutePath());
        File[] roots = File.listRoots();
        System.out.println("====系统所有根路径如下====");
        for (File root: roots) {
        	System.out.println(root);
        }
	}

}
