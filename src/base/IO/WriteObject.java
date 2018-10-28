/**
 * 使用ObjectOutputStream将Person类写入磁盘
 */
package base.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class WriteObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ObjectOutput oos = new ObjectOutputStream(new FileOutputStream("E:\\java_workspace\\Practice\\src\\base\\IO\\object.txt"));
			Person person = new Person("张三", 12);
			oos.writeObject(person);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
