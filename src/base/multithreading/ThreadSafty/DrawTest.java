package base.multithreading.ThreadSafty;

public class DrawTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����һ���˻�
		SynAccount acc = new SynAccount("123456", 1000);
		// ģ�������û���ͬһ���˻�ȡǮ
		new SynDrawThread("��", acc, 800).start();
		new SynDrawThread("��", acc, 700).start();

	}

}
