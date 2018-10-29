package base.multithreading;

public class InvokeRun extends Thread {
	private int i;
	public void run() {
		for (; i < 100; i++) {
			// 直接调用run方法，Thread的this.getName()返回的是该对象的名字而不是当前线程的名字
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i =0; i < 100; i++) {
			// 调用Thread的currentThread()获取当前的线程
			System.out.print(Thread.currentThread().getName() + " " + i);
			if (20 == i) {
				// 测试直接调用线程的run方法，以下两行代码并不会创建两个线程
				new InvokeRun().run();
				new InvokeRun().start();
			}
		}

	}

}
