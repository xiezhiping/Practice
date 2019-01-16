package base.multithreading.unsynch;

public class UnsynchBankTest {
	public static final int NACCOUNTS = 100;
	public static final int ININ_BALANCE = 1000;
	public static void main(String[] args) {
		Bank b = new Bank(NACCOUNTS, ININ_BALANCE);
		int i = 0;
		for (; i < NACCOUNTS; i++) {
			TransferRunnable r = new TransferRunnable(b, i, ININ_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}
}
