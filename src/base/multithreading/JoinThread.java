package base.multithreading;

public class JoinThread extends Thread {
	// �ṩһ����name�����Ĺ��������������߳�
	public JoinThread(String name) {
		super(name);
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// �������߳�
		new JoinThread("�߳�1").start();
		for ( int i = 0; i < 10; i++) {
			if (5 == i) {
				JoinThread jt = new JoinThread("��Join���߳�");
				jt.start();
				// main�̵߳�����jt�̵߳�join()������main�̱߳����jtִ�н���֮�������ִ��
				jt.join();
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
		}

	}

}
