package base.multithreading;

public class RunnableTest implements Runnable {
	private int i;
	public void run() {
		for ( ; i < 100 ; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (20  == i) {
				RunnableTest rt = new RunnableTest();
				// 通过new Thread（target, name）方法创建新线程
				new Thread(rt, "线程1").start();
				new Thread(rt, "线程2").start();
			}
		}

	}

}
