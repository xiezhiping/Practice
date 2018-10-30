/**
 * 模拟两个线程从同一个银行取款账户取款的账户类
 */
package base.multithreading.ThreadSafty;

public class Account {
	private String id;
	private double balance;
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
	public void setBalance(double balance) {
		this.balance = balance;
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
