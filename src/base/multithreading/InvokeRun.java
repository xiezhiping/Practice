package base.multithreading;

public class InvokeRun extends Thread {
	private int i;
	public void run() {
		for (; i < 100; i++) {
			// ֱ�ӵ���run������Thread��this.getName()���ص��Ǹö�������ֶ����ǵ�ǰ�̵߳�����
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i =0; i < 100; i++) {
			// ����Thread��currentThread()��ȡ��ǰ���߳�
			System.out.print(Thread.currentThread().getName() + " " + i);
			if (20 == i) {
				// ����ֱ�ӵ����̵߳�run�������������д��벢���ᴴ�������߳�
				new InvokeRun().run();
				new InvokeRun().start();
			}
		}

	}

}
