package base.multithreading.deadlock;

public class A {
	public synchronized void foo(B b) {
		System.out.println("当前线程名:" + Thread.currentThread().getName() + "进入了A实例的foo()方法");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("当前线程名:" + Thread.currentThread().getName() + "企图调用B实例的last()方法");
		b.last();
	}
	public synchronized void last() {
		System.out.println("进入了A类的last()方法内部");
	}
}
