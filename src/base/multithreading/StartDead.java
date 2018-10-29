package base.multithreading;

public class StartDead extends Thread {
	private int i;
	public void run() {
		for (; i < 100; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建线程对象
		StartDead sd = new StartDead();
		for ( int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (20 == i) {
				// 启动线程
				sd.start();
				// 判断线程isAlive()
				System.out.println(sd.isAlive());
			}
			if (i > 20 && !sd.isAlive()) {
				// 试图再次启动该线程
				sd.start();
				System.out.println(sd.isAlive());
			}
		}

	}

}
