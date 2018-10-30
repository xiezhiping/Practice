package base.multithreading.ThreadSafty;

public class DrawTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建一个账户
		Account acc = new Account("123456", 1000);
		// 模拟两个用户对同一个账户取钱
		new DrawThread("甲", acc, 800).start();
		new DrawThread("乙", acc, 700).start();

	}

}
