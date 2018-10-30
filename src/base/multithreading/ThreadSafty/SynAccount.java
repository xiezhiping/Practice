/**
 * ģ�������̴߳�ͬһ������ȡ���˻�ȡ����˻���
 */
package base.multithreading.ThreadSafty;

public class SynAccount {
	private String id;
	private double balance;
	public SynAccount(String id, double balance) {
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
	// �ṩһ���̰߳�ȫ��draw()���������ȡǮ����
	public synchronized void draw(double drawAmount) {
		// �˻�������ȡ����Ŀ
    	if (balance >= drawAmount) {
    		// �³�Ʊ
    		System.out.println(Thread.currentThread().getName() + "ȡǮ�ɹ���ȡ����Ʊ��" + drawAmount);
    		try { // ִ���߳��л��Ĵ���
    			Thread.sleep(1000);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		// �޸����
    		balance -= drawAmount;
    		System.out.println("\t���Ϊ��" + balance);
    	} else {
    		System.out.println(Thread.currentThread().getName() + "ȡǮʧ�ܣ����㣡");
    	}
	}
}
