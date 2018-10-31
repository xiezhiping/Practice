package base.multithreading.deadlock;

public class B {
	public synchronized void bar(A a) {
		System.out.println("当前线程名:" + Thread.currentThread().getName() + "进入了B实例的bar()方法");
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("当前线程名:" + Thread.currentThread().getName() + "企图调用A实例的last()方法");
		a.last();
	}
	public synchronized void last() {
		System.out.println("进入了B类的last()方法内部");
	}
}
