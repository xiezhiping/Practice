package base.multithreading.deadlock;

public class A {
	public synchronized void foo(B b) {
		System.out.println("��ǰ�߳���:" + Thread.currentThread().getName() + "������Aʵ����foo()����");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("��ǰ�߳���:" + Thread.currentThread().getName() + "��ͼ����Bʵ����last()����");
		b.last();
	}
	public synchronized void last() {
		System.out.println("������A���last()�����ڲ�");
	}
}
