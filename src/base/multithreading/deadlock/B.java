package base.multithreading.deadlock;

public class B {
	public synchronized void bar(A a) {
		System.out.println("��ǰ�߳���:" + Thread.currentThread().getName() + "������Bʵ����bar()����");
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("��ǰ�߳���:" + Thread.currentThread().getName() + "��ͼ����Aʵ����last()����");
		a.last();
	}
	public synchronized void last() {
		System.out.println("������B���last()�����ڲ�");
	}
}
