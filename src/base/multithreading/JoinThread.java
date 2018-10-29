package base.multithreading;

public class JoinThread extends Thread {
	// 提供一个带name参数的构造器用于区别线程
	public JoinThread(String name) {
		super(name);
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 启动子线程
		new JoinThread("线程1").start();
		for ( int i = 0; i < 10; i++) {
			if (5 == i) {
				JoinThread jt = new JoinThread("被Join的线程");
				jt.start();
				// main线程调用了jt线程的join()方法，main线程必须等jt执行结束之后才向下执行
				jt.join();
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
		}

	}

}
