/**
 * File�����֪ʶ�Ĳ�����
 */
package base.IO;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
        File[] roots = File.listRoots();
        System.out.println("====ϵͳ���и�·������====");
        for (File root: roots) {
        	System.out.println(root);
        }
	}

}
