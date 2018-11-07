package base.jvm;

public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		// 下面语句仅仅是加载Tester类
		cl.loadClass("base.jvm.Tester");
		System.out.println("系统加载Tester类");
		// 下面语句才会初始化Tester类
		Class.forName("base.jvm.Tester");
	}

}
