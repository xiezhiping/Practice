package base.multithreading.ThreadSafty;

import java.lang.reflect.Array;
import java.util.concurrent.CountDownLatch;

public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
        Object arr = Array.newInstance(int.class, 10);
        Array.setInt(arr, 0, 2);
        System.out.println(Array.getInt(arr, 0));
    }

}
