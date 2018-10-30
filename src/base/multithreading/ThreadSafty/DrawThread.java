package base.multithreading.ThreadSafty;

public class DrawThread extends Thread {
	// 模拟用户账户
	private Account account;
	// 当前取钱线程希望取的钱
	private double drawAmount;
    public DrawThread(String name, Account account, double drawAmount) {
    	super(name);
    	this.account = account;
    	this.drawAmount = drawAmount;
    }
    // 当多个线程修改同一个共享数据时，将涉及数据安全问题
    public void run() {
    	// 账户余额大于取线数目
    	if (account.getBalance() >= drawAmount) {
    		// 吐钞票
    		System.out.println(getName() + "取钱成功！取出钞票：" + drawAmount);
    		try { // 执行线程切换的代码
    			Thread.sleep(1000);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		// 修改余额
    		account.setBalance(account.getBalance() - drawAmount);
    		System.out.println("\t余额为：" + account.getBalance());
    	} else {
    		System.out.println(getName() + "取钱失败！余额不足！");
    	}
    }

}
