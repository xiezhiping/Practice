package base.multithreading.ThreadSafty;

import java.util.concurrent.atomic.AtomicInteger;

public class IPlusPlusTest {
	public static volatile AtomicInteger i = new AtomicInteger(0);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int j = 0; j < 100; j++) {
					i.addAndGet(1);
					System.out.println("A: " + i);
				}
//				try {
//					Thread.currentThread().sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int j = 0; j < 100; j++) {
					i.addAndGet(1);
					System.out.println("B: " + i);
				}
//				try {
////					Thread.currentThread().sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		});
		thread1.start();
		thread2.start();
	}

}
