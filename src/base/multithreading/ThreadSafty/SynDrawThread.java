package base.multithreading.ThreadSafty;

public class SynDrawThread extends Thread {
	// 模拟用户账户
	private SynAccount account;
	// 当前取钱线程希望取的钱
	private double drawAmount;
    public SynDrawThread(String name, SynAccount account, double drawAmount) {
    	super(name);
    	this.account = account;
    	this.drawAmount = drawAmount;
    }
    // 当多个线程修改同一个共享数据时，将涉及数据安全问题
    public void run() {
    	// 直接调用account对象的draw()方法来执行取钱操作
    	// 同步方法的同步监视器是this,也就是调用draw方法的对象
    	account.draw(drawAmount);
    }

}
