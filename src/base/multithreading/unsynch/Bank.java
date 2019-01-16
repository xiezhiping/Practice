package base.multithreading.unsynch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	private final int[] accounts;
	// 提供一个同步锁
	private Lock bankLock;
	// 添加一个条件对象
	private Condition sufficientFunds;
	public Bank(int n, int initBalance) {
		accounts = new int[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initBalance;
		}
		// 初始化该对象的锁
		bankLock = new ReentrantLock();
		// 初始化一个条件对象，用于判断余额是否充足
		sufficientFunds = bankLock.newCondition();
	}
	public void transfer (int from, int to, int amount) {
		bankLock.lock();
		try {
			while (accounts[from] < amount) { // 当余额不足时，条件对象会调用await方法将当前线程阻塞，并交出锁
				sufficientFunds.await();
			}
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			System.out.println(amount + " from " + from + " to " + to);
			accounts[to] += amount;
			System.out.println(" Total Balance: " + getTotalBalance());
			sufficientFunds.signalAll(); // 在对象的状态有利于等待线程的方向改变时调用signalAll方法，唤醒等待该条件中的线程
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			bankLock.unlock();
		}
	}
	public int getTotalBalance() {
		bankLock.lock();
		try {
			int sum  = 0;
			for (int a : accounts) {
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
