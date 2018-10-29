
package base.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FuturetaskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����Callable����
		FuturetaskTest ft = new FuturetaskTest();
		// ��ʹ��Lambda���ʽ����Callable<Integer>����
		FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)() -> {
			int i = 0;
			for ( ; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " ��ѭ������i��ֵ��" + i);
			}
			// call����Ӧ���з���ֵ
			return i;
		});
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " ��ѭ������i��ֵ�� " + i);
			if (20 == i) {
				// ʵ�ʻ�����Callable�����������������̵߳�
				new Thread(task, "�з���ֵ���߳�").start();
			}
		}
		try {
			// ��ȡ�̷߳���ֵ
			System.out.println("���̵߳ķ���ֵ�� " + task.get());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
