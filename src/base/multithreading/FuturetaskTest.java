
package base.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FuturetaskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建Callable对象
		FuturetaskTest ft = new FuturetaskTest();
		// 先使用Lambda表达式创建Callable<Integer>对象
		FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)() -> {
			int i = 0;
			for ( ; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " 的循环变量i的值：" + i);
			}
			// call方法应该有返回值
			return i;
		});
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的值： " + i);
			if (20 == i) {
				// 实质还是以Callable对象来创建并启动线程的
				new Thread(task, "有返回值的线程").start();
			}
		}
		try {
			// 获取线程返回值
			System.out.println("子线程的返回值： " + task.get());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
