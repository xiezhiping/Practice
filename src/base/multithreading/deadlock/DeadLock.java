package base.multithreading.deadlock;


public class DeadLock implements Runnable {
	A a = new A();
	B b = new B();
	public void init() {
		Thread.currentThread().setName("���߳�");
		a.foo(b);
		System.out.println("�������߳�֮��");
	}
    public void run() {
    	Thread.currentThread().setName("���߳�");
    	b.bar(a);
    	System.out.println("���븱�߳�֮��");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DeadLock dl = new DeadLock();
        new Thread(dl).start();
        dl.init();
        System.out.println("ִ�����...");
	}

}
