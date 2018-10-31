package base.multithreading.deadlock;


public class DeadLock implements Runnable {
	A a = new A();
	B b = new B();
	public void init() {
		Thread.currentThread().setName("主线程");
		a.foo(b);
		System.out.println("进入主线程之后");
	}
    public void run() {
    	Thread.currentThread().setName("副线程");
    	b.bar(a);
    	System.out.println("进入副线程之后");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DeadLock dl = new DeadLock();
        new Thread(dl).start();
        dl.init();
        System.out.println("执行完毕...");
	}

}
