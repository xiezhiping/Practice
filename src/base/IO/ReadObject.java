package base.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\java_workspace\\Practice\\src\\base\\IO\\object.txt"));
			// ���������ж�ȡһ��java����
			Object object = ois.readObject();
			System.out.println(object + "    " + "Person:" + ((Person)object).getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
