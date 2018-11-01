package base.multithreading.threadcommunication;

public class Account {
	private String id;
	private double balance;
	// 标识账户中是否已有存款
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
			// 如果flag为假，表明账户中还没有人存钱进去，取钱方法阻塞
			if (!flag) {
				wait();
			} else {
				// 执行取钱操作
				System.out.println(Thread.currentThread().getName() + "取钱:" + drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额为：" + balance);
				flag = false;
				// 唤醒其他线程
				notifyAll();
			}
			
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	public synchronized void deposit(double depositAmount) {
		try {
			// 如果flag为真，表明账户中已经有人存钱进去，存钱方法阻塞
			if (flag) {
				wait();
			} else {
				// 执行存款操作
				System.out.println(Thread.currentThread().getName() + "存款：" + depositAmount);
				balance += depositAmount;
				System.out.println("账户余额为：" + balance);
				// 将标识账户是否有存款的flag置为true
				flag = true;
				// 唤醒其他线程
				notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 下面两个方法根据id来重写hashCode()和equals()方法
	public int hashCode() {
		return id.hashCode();
	}
	public boolean equals(Object obj) {// 重写equals方法就要重写hashCode方法，在逻辑上保持一致！！！
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
