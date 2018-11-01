package base.multithreading.threadcommunication;

public class Account {
	private String id;
	private double balance;
	// ��ʶ�˻����Ƿ����д��
	private boolean flag = false;
	public Account(String id, double balance) {
		this.id =id;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public synchronized void draw(double drawAmount) {
		try {
			// ���flagΪ�٣������˻��л�û���˴�Ǯ��ȥ��ȡǮ��������
			if (!flag) {
				wait();
			} else {
				// ִ��ȡǮ����
				System.out.println(Thread.currentThread().getName() + "ȡǮ:" + drawAmount);
				balance -= drawAmount;
				System.out.println("�˻����Ϊ��" + balance);
				flag = false;
				// ���������߳�
				notifyAll();
			}
			
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	public synchronized void deposit(double depositAmount) {
		try {
			// ���flagΪ�棬�����˻����Ѿ����˴�Ǯ��ȥ����Ǯ��������
			if (flag) {
				wait();
			} else {
				// ִ�д�����
				System.out.println(Thread.currentThread().getName() + "��" + depositAmount);
				balance += depositAmount;
				System.out.println("�˻����Ϊ��" + balance);
				// ����ʶ�˻��Ƿ��д���flag��Ϊtrue
				flag = true;
				// ���������߳�
				notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ����������������id����дhashCode()��equals()����
	public int hashCode() {
		return id.hashCode();
	}
	public boolean equals(Object obj) {// ��дequals������Ҫ��дhashCode���������߼��ϱ���һ�£�����
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == Account.class) {
			Account target = (Account)obj;
			return target.getId().equals(id);
		}
		return false;
	}
}
