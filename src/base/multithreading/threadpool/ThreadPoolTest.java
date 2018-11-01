package base.multithreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// ����һ�����й̶��߳������̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(6);
		// ʹ��Lambda���ʽ����Runnable����
		Runnable target = () -> {
			for (int i = 0; i < 100 ; i++) {
				System.out.println(Thread.currentThread().getName() + "��iֵΪ��" + i);
			}
		};
		// ���̳߳����ύ�����߳�
		pool.submit(target);
		pool.submit(target);
		// �ر��̳߳�
		pool.shutdown();

	}

}
