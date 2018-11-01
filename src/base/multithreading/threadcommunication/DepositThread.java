package base.multithreading.threadcommunication;

public class DepositThread extends Thread {
	// ģ���û��˻�
	private Account account;
	// ��ǰ����߳�ϣ�����Ǯ
	private double depositAmount;
	public DepositThread(String name, Account account, double depositAmount) {
		super(name);
		this.account = account;
		this.depositAmount = depositAmount;
	}
	// �ظ�100��ִ�д�����
	public void run() {
		for (int i = 0 ; i < 10 ; i++) {
			System.out.println("ִ�е�����:deposit");
			account.deposit(depositAmount);
		}
	}
}
