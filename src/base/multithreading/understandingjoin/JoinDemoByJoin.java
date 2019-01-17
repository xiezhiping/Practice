package base.multithreading.understandingjoin;

public class JoinDemoByJoin {
    public static void main(String[] args) {
        try {
            System.out.println("main running");
            SonThread sonThread = new SonThread();
            sonThread.start();
            System.out.println("main suspend and waiting for son");
            sonThread.join();
            System.out.println("son did his work, main running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SonThread extends Thread {
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
