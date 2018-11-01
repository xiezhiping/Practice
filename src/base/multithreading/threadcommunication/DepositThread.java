package base.multithreading.threadcommunication;

public class DepositThread extends Thread {
	// 模拟用户账户
	private Account account;
	// 当前存款线程希望存的钱
	private double depositAmount;
	public DepositThread(String name, Account account, double depositAmount) {
		super(name);
		this.account = account;
		this.depositAmount = depositAmount;
	}
	// 重复100次执行存款操作
	public void run() {
		for (int i = 0 ; i < 10 ; i++) {
			System.out.println("执行到这里:deposit");
			account.deposit(depositAmount);
		}
	}
}
