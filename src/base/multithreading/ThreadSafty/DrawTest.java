package base.multithreading.ThreadSafty;

public class DrawTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建一个账户
		SynAccount acc = new SynAccount("123456", 1000);
		// 模拟两个用户对同一个账户取钱
		new SynDrawThread("甲", acc, 800).start();
		new SynDrawThread("乙", acc, 700).start();

	}

}
