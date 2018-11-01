package base.multithreading.threadcommunication;

public class DrawTest {

	public static void main(String[] args) {
		// 创建一个账户
		Account account = new Account("123456", 0);
		new DrawThread("取钱者", account , 800).start();
		new DrawThread("存款者甲", account, 800).start();
	}
}
