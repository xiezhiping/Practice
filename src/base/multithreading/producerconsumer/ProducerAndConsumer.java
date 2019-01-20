package base.multithreading.producerconsumer;

public class ProducerAndConsumer {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Productor pro = new Productor(clerk);
		Consumer con = new Consumer(clerk);
		
		new Thread(pro, "������A").start();
		new Thread(con, "������B").start();
		new Thread(pro, "������C").start();
		new Thread(con, "������D").start();
	}
}

// ��Ա
class Clerk {
	private int product = 0;
	
	// ����
	public synchronized void get() { // ѭ�������� 0 
		while (product >= 1) {
			System.out.println("��Ʒ������");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " : " + ++product);
		this.notifyAll();
	}
	// ����
	public synchronized void sale() { // product = 0;ѭ��������0
		while (product <= 0) {
			System.out.println("ȱ��");
			try {
				this.wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " : " + --product);
		this.notifyAll();
	}
}
// ������
class Productor implements Runnable {
	private Clerk clerk;
	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.get();
		}
		
	}
	
}
// ������
class Consumer implements Runnable {
	private Clerk clerk;
	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			clerk.sale();
		}
	}
}
