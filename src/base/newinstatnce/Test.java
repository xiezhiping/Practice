package base.newinstatnce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;

public class Test {
	public static void main(String[] args) {
		// ��һ����ʽ:new
		Student std1 = new Student(1, "std1");
		System.out.println(std1.getName());
		// �ڶ�����ʽ:ʹ�÷���
		try {
			Student std2 = (Student) Class.forName("base.newinstatnce.Student").newInstance();
			std2.setId(2);
			std2.setName("std2");
			System.out.println(std2.getName());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �����ַ�ʽ: ͨ��������
		try {
			Student std3 = Student.class.getConstructor().newInstance();
			System.out.println(std3.getName());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �����ַ���:ʹ��clone�ķ�ʽ
		Student std3;
		try {
			std3 = (Student)std1.clone();
			System.out.println(std3.getName());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �����֣������л�
		ObjectOutputStream oos; // �����л�
		try {
			oos = new ObjectOutputStream(new FileOutputStream("F:\\java_workspace\\Practice\\src\\base\\newinstatnce\\object.txt"));
			oos.writeObject(std1);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ObjectInputStream ois; // �����л�
		try {
			ois = new ObjectInputStream(new FileInputStream("F:\\java_workspace\\Practice\\src\\base\\newinstatnce\\object.txt"));
			Student std5 = (Student)ois.readObject();
			System.out.println(std5.getName());
		} catch (FileNotFoundException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
