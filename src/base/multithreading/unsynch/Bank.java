package base.multithreading.unsynch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	private final int[] accounts;
	// �ṩһ��ͬ����
	private Lock bankLock;
	// ���һ����������
	private Condition sufficientFunds;
	public Bank(int n, int initBalance) {
		accounts = new int[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initBalance;
		}
		// ��ʼ���ö������
		bankLock = new ReentrantLock();
		// ��ʼ��һ���������������ж�����Ƿ����
		sufficientFunds = bankLock.newCondition();
	}
	public void transfer (int from, int to, int amount) {
		bankLock.lock();
		try {
			while (accounts[from] < amount) { // ������ʱ��������������await��������ǰ�߳���������������
				sufficientFunds.await();
			}
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			System.out.println(amount + " from " + from + " to " + to);
			accounts[to] += amount;
			System.out.println(" Total Balance: " + getTotalBalance());
			sufficientFunds.signalAll(); // �ڶ����״̬�����ڵȴ��̵߳ķ���ı�ʱ����signalAll���������ѵȴ��������е��߳�
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
