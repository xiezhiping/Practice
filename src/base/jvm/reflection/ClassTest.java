package base.jvm.reflection;

import java.lang.reflect.Constructor;

public class ClassTest {
	public ClassTest() {
		
	}
	// ����һ���в����Ĺ�����
	public ClassTest(String name) {
		System.out.println("ִ���в����Ĺ�����...");
	}
	// ����һ���޲�����info����
	public void info() {
		System.out.println("ִ��һ���޲�����info����");
	}
	public void info(String info) {
		System.out.println("ִ���в�����info����" + ", ��str����Ϊ��" + info);
	}
	// ����һ�������õ��ڲ���
	class Inner {
		public Inner() {
			
		}
	}
	public static void main(String[] args) throws Exception {
		// ��ȡClassTest��Ӧ��class����
		Class<Class> clazz = Class.class;
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for (Constructor c: constructors) {
			System.out.println(c);
//			Object outer = c.newInstance();
		}
		// ��ȡ�ö����Ӧ���ȫ��public������
		Constructor[] publicContructors = clazz.getConstructors();
		System.out.println("ȫ��public������:");
		for (Constructor c : publicContructors) {
			System.out.println(c);
			Object o = c.newInstance();
		}
		// ʹ��forName��������ClassTest��Inner�ڲ���
		Class inClazz = Class.forName("ClassTest$Inner");
		System.out.println("inClazz��Ӧ����ⲿ��Ϊ��" + inClazz.getDeclaredClasses());
	}
}
