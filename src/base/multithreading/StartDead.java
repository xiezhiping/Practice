package base.multithreading;

public class StartDead extends Thread {
	private int i;
	public void run() {
		for (; i < 100; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �����̶߳���
		StartDead sd = new StartDead();
		for ( int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (20 == i) {
				// �����߳�
				sd.start();
				// �ж��߳�isAlive()
				System.out.println(sd.isAlive());
			}
			if (i > 20 && !sd.isAlive()) {
				// ��ͼ�ٴ��������߳�
				sd.start();
				System.out.println(sd.isAlive());
			}
		}

	}

}
