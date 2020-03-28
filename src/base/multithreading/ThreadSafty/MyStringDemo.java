package base.multithreading.ThreadSafty;


import java.util.concurrent.CountDownLatch;	


public class MyStringDemo {	
private String string;	

private String getString() {	
    return string;	
}	

private void setString(String string) {	
    this.string = string;	
}	

public static void main(String[] args) {	
    int threads = 9;	
    MyStringDemo demo = new MyStringDemo();	
    CountDownLatch countDownLatch = new CountDownLatch(threads);	
    for (int i = 0; i < threads; i++) {	
        Thread thread = new Thread(() -> {	
            demo.setString(Thread.currentThread().getName());	
            System.out.println(demo.getString());	
            countDownLatch.countDown();	
        }, "thread - " + i);	
        thread.start();	
    }	

}	

}	

