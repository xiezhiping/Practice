package base.multithreading.unsynch;

public class TransferRunnable implements Runnable {
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 100;
	
	public TransferRunnable(Bank b, int from, double max) {
		bank = b;
		fromAccount = from;
		maxAmount = max;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				int toAccount = (int)(bank.size() * Math.random());
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((long) (DELAY * Math.random()));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
