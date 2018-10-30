package base.multithreading;

public class PriorityTest extends Thread {
	// ����һ���в����Ĺ����������ڴ����߳�ʱָ��name
	public PriorityTest(String name) {
		super(name);
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + ",�����ȼ���:" + getPriority() + ",ѭ��������ֵΪ��" + i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �ı����̵߳����ȼ�
		for (int i = 0; i < 10; i++) {
			if (5 == i) {
				PriorityTest low = new PriorityTest("�ͼ�");
				low.start();
				System.out.println("����֮�������ȼ���" + low.getPriority());
				// ���ø��߳�Ϊ������ȼ�
				low.setPriority(Thread.MIN_PRIORITY);
			}
			if (8 == i) {
				PriorityTest high = new PriorityTest("�߼�");
				high.start();
				System.out.print("����֮�������ȼ���" + high.getPriority());
				// ���ø��߳�Ϊ������ȼ�
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}

	}

}
