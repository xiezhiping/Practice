package base.multithreading.unsynch;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	private final int[] accounts;
	// 提供一个同步锁
	private Lock bankLock = new ReentrantLock();
	public Bank(int n, int initBalance) {
		accounts = new int[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initBalance;
		}
	}
	public synchronized void transfer (int from, int to, double amount) {
		if (accounts[from] < amount) return;
		bankLock.lock();
		try {
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			System.out.println(amount + " from " + from + " to " + to);
			accounts[to] += amount;
			System.out.println(" Total Balance: " + getTotalBalance());
		} finally {
			bankLock.unlock();
		}
	}
	public synchronized int getTotalBalance() {
		bankLock.lock();
		try {
			int sum  = 0;
			for (double a : accounts) {
				sum += a;
			}
			return sum;
		} finally {
			bankLock.unlock();
		}
	}
	public int size() {
		return accounts.length;
	}
} 
