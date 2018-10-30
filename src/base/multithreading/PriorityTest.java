package base.multithreading;

public class PriorityTest extends Thread {
	// 定义一个有参数的构造器，用于创建线程时指定name
	public PriorityTest(String name) {
		super(name);
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + ",其优先级是:" + getPriority() + ",循环变量的值为：" + i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 改变主线程的优先级
		for (int i = 0; i < 10; i++) {
			if (5 == i) {
				PriorityTest low = new PriorityTest("低级");
				low.start();
				System.out.println("创建之初的优先级：" + low.getPriority());
				// 设置该线程为最低优先级
				low.setPriority(Thread.MIN_PRIORITY);
			}
			if (8 == i) {
				PriorityTest high = new PriorityTest("高级");
				high.start();
				System.out.print("创建之初的优先级：" + high.getPriority());
				// 设置该线程为最高优先级
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}

	}

}
