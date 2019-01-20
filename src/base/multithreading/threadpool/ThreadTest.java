package base.multithreading.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {

    public static void main(String[] args) {
        System.out.println("main start");
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
         Future<?> future1 = threadPool.submit(new MyRunnable()) ;
        Future<String> future = threadPool.submit(new MyCallable());
        try {
            // ����ᷢ������
            System.out.println(future.get());
        } catch (Exception e) {

        } finally {
            threadPool.shutdown();
        }
        System.out.println("main end");
    }
}


class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        // ģ���ʱ����
        Thread.sleep(3000);
        System.out.println("MyCallable �̣߳�" + Thread.currentThread().getName());
        return "MyCallable" ;
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        // ģ���ʱ����
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyRunnable");
    }
}
