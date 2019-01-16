package base.multithreading.unsynch;

public class Bank {
	private final double[] accounts;
	public Bank(int n, double initBalance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initBalance;
		}
	}
	public void transfer (int from, int to, double amount) {
		if (accounts[from] < amount) return;
		System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out.println(amount + " from " + from + " to " + to);
		accounts[to] += amount;
		System.out.println(" Total Balance: " + getTotalBalance());
	}
	public double getTotalBalance() {
		double sum  = 0;
		for (double a : accounts) {
			sum += a;
		}
		return sum;
	}
	public int size() {
		return accounts.length;
	}
} 
