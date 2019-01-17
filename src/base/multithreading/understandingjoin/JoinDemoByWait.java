package base.multithreading.understandingjoin;

public class JoinDemoByWait {
    public static void main(String[] args) {
        try {
            System.out.println("main running");
            SonThreadByWait sonThread = new SonThreadByWait();
            sonThread.start();
            System.out.println("main suspend and waiting for son");
            // sonThread.join();
            synchronized (sonThread) {
				sonThread.wait();
			}
            System.out.println("son did his work, main running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SonThreadByWait extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("son running ..." + i);
        }
    }
}
