/**
 * ģ�������̴߳�ͬһ������ȡ���˻�ȡ����˻���
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
