package base.jvm.reflection;

import java.lang.reflect.Constructor;

public class ClassTest {
	public ClassTest() {
		
	}
	// 定义一个有参数的构造器
	public ClassTest(String name) {
		System.out.println("执行有参数的构造器...");
	}
	// 定义一个无参数的info方法
	public void info() {
		System.out.println("执行一个无参数的info方法");
	}
	public void info(String info) {
		System.out.println("执行有参数的info方法" + ", 其str参数为：" + info);
	}
	// 定义一个测试用的内部类
	class Inner {
		public Inner() {
			
		}
	}
	public static void main(String[] args) throws Exception {
		// 获取ClassTest对应的class对象
		Class<Class> clazz = Class.class;
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for (Constructor c: constructors) {
			System.out.println(c);
//			Object outer = c.newInstance();
		}
		// 获取该对象对应类的全部public构造器
		Constructor[] publicContructors = clazz.getConstructors();
		System.out.println("全部public构造器:");
		for (Constructor c : publicContructors) {
			System.out.println(c);
			Object o = c.newInstance();
		}
		// 使用forName方法加载ClassTest的Inner内部类
		Class inClazz = Class.forName("ClassTest$Inner");
		System.out.println("inClazz对应类的外部类为：" + inClazz.getDeclaredClasses());
	}
}
