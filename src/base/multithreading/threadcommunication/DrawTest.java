package base.multithreading.threadcommunication;

public class DrawTest {

	public static void main(String[] args) {
		// ����һ���˻�
		Account account = new Account("123456", 0);
		new DrawThread("ȡǮ��", account , 800).start();
		new DrawThread("����߼�", account, 800).start();
	}
}
