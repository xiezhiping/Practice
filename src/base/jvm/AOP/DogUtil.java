package base.jvm.AOP;

public class DogUtil {
	// 第一个拦截器
	public void method1() {
		System.out.println("模拟第一个通用方法");
	}
	// 第二个拦截器
	public void method2() {
		System.out.println("模拟第二个通用方法");
	}
}
