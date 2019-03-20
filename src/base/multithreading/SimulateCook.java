package base.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ����ʹ�����ֶ��߳�ģ�������Ĺ��̣�����Ҫ�г��ߣ�ͨ����������Ȼ�����Լ�ȥС�����
 * @author xzp
 *
 */
public class SimulateCook {
	public static CookTool cookTool = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���ǵ�һ��ʹ�ó����߳�ͨ�ŵķ�ʽ
		long startTime = System.currentTimeMillis();
		// �µ�������ߵĹ���
		Thread buyCookToolThread = new BuyCookTool();
		buyCookToolThread.start();
		try {
			buyCookToolThread.join(); // �ȴ�����ó��ߣ��������Ϊnull
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��Ҫȥ�����...");
		try {
			Thread.sleep(2000);// ģ����˺�ʱ
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		System.out.println("���ڿ���������....");
		cook(cookTool, new Food("�ܲ�"));
		System.out.println("�ܹ���ʱ:" + (System.currentTimeMillis() - startTime));
		
		// ������ʹ�õڶ���ʹ��Futureģʽ���첽�߳�ͨ��
		System.out.println("����Ҫ׼�������ˣ�����Ҿ�������һ�ֳ��ߣ����������Чһ��...");
		long startTime2 = System.currentTimeMillis();
		FutureTask<CookTool> task = new FutureTask<>(new BuyCookToolByFuture()); // ������������˶��̵߳�����
		new Thread(task).start();
		System.out.println("��Ҫȥ�����...");
			try {
				Thread.sleep(2000);// ģ����˺�ʱ
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("���ڿ���������....");
			try {
				cook(task.get(), new Food("�ܲ�"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�ڶ����ܹ���ʱ:" + (System.currentTimeMillis() - startTime2));		
}
	public static void cook(CookTool cookTool, Food food) {
		System.out.println("���� " + cookTool.id + " ����һ�� " + food.name);
	}
}
class Food {
	String name;
	public Food(String name) {
		this.name = name;
	}
}
/**
 * ����ʵ��Callable<>�ӿڵ�Futureģʽ
 */
class BuyCookToolByFuture implements Callable<CookTool> {

	@Override
	public CookTool call() throws Exception {
		// TODO Auto-generated method stub
		// ѡһ��ϲ���ĳ���
				int id = 456; // ģ��һ��id�ͼ۸�
				try {
					Thread.sleep(2000); // ģ����ѡ��ʱ
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("ѡ����.....");
				int price = 10; // ����
				System.out.println("���µ��ȴ�����,���������....");
				try {
					Thread.sleep(2000); // ģ�������ͺ�ʱ
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SimulateCook.cookTool = new CookTool(id, price); // ����ȡ������
				System.out.println("����ȡ������....");
		return SimulateCook.cookTool;
	}
	
}

/**
 * ������ͨ�Ķ��߳�ģʽ
 * @author xzp
 *
 */
class BuyCookTool extends Thread {
	@Override
	public void run() {
		// ѡһ��ϲ���ĳ���
		int id = 123; // ģ��һ��id�ͼ۸�
		try {
			Thread.sleep(2000); // ģ����ѡ��ʱ
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ѡ����.....");
		int price = 10; // ����
		System.out.println("���µ��ȴ�����,���������....");
		try {
			Thread.sleep(2000); // ģ�������ͺ�ʱ
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimulateCook.cookTool = new CookTool(id, price); // ����ȡ������
		System.out.println("����ȡ������....");
	}
}
// ������
class CookTool {
	int id;
	int price;
	public CookTool(int id, int price) {
		this.id = id;
		this.price = price;
	}
}
