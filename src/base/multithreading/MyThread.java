package base.multithreading;

public class MyThread extends Thread {
    private int i;
    public void run() {
    	for (; i < 100; i++) {
    		System.out.println(this.getName() + " " + i);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (20 == i) {
				// 创建并启动第一个线程
				new MyThread().start();
				// 创建并启动第二个线程
				new MyThread().start();
			}
		}
		
		

	}

}
