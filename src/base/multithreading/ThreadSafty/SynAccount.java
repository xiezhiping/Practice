/**
 * 模拟两个线程从同一个银行取款账户取款的账户类
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
	// 提供一个线程安全的draw()方法来完成取钱操作
	public synchronized void draw(double drawAmount) {
		// 账户余额大于取线数目
    	if (balance >= drawAmount) {
    		// 吐钞票
    		System.out.println(Thread.currentThread().getName() + "取钱成功！取出钞票：" + drawAmount);
    		try { // 执行线程切换的代码
    			Thread.sleep(1000);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		// 修改余额
    		balance -= drawAmount;
    		System.out.println("\t余额为：" + balance);
    	} else {
    		System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
    	}
	}
}
