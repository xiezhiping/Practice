package base.multithreading.ThreadSafty;

public class DrawTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����һ���˻�
		Account acc = new Account("123456", 1000);
		// ģ�������û���ͬһ���˻�ȡǮ
		new DrawThread("��", acc, 800).start();
		new DrawThread("��", acc, 700).start();

	}

}
