package base.multithreading.threadcommunication;
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
    	for (int i = 0; i < 10; i++) {
    		System.out.println("执行到这里:draw " + drawAmount);
    		account.draw(drawAmount);
    	}
        }
    }
