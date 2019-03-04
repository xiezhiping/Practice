package base;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(100);
		for (int i = 0; i < 100; i++) {
			new Thread() {
				public void run() {
					try {
						latch.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "ÕýÔÚÖ´ÐÐ...\n");
				}
			}.start();
			latch.countDown();
		}
	}
}
