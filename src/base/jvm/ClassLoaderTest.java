package base.jvm;

public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		// �����������Ǽ���Tester��
		cl.loadClass("base.jvm.Tester");
		System.out.println("ϵͳ����Tester��");
		// �������Ż��ʼ��Tester��
		Class.forName("base.jvm.Tester");
	}

}
