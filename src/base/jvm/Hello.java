package base.jvm;

public class Hello {
	public static void main (String[] args) {
		for (String arg : args) {
			System.out.println("运行时参数:" + args);
		}
	}
}
