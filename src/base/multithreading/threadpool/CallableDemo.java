package base.multithreading.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<String> future = executor.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("call");
				TimeUnit.SECONDS.sleep(1);
				return "call over";
			}
					
		});
		System.out.println(future.get());
	}
}
