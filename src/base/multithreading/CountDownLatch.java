package base.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountDownLatch {
	private static java.util.concurrent.CountDownLatch countDown = new java.util.concurrent.CountDownLatch(100);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName() + "...");
					countDown.countDown();
				}
			}, "线程" + i).start();
		}
		try {
			countDown.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 主线程阻塞
		System.out.println("main执行....");
	}

}
