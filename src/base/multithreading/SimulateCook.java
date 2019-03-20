package base.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 该类使用两种多线程模拟做饭的过程：首先要有厨具（通过网购），然后是自己去小区买菜
 * @author xzp
 *
 */
public class SimulateCook {
	public static CookTool cookTool = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 这是第一种使用常规线程通信的方式
		long startTime = System.currentTimeMillis();
		// 下单购买厨具的过程
		Thread buyCookToolThread = new BuyCookTool();
		buyCookToolThread.start();
		try {
			buyCookToolThread.join(); // 等待购买好厨具，否则厨具为null
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("我要去买菜了...");
		try {
			Thread.sleep(2000);// 模拟买菜耗时
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		System.out.println("终于可以做饭了....");
		cook(cookTool, new Food("萝卜"));
		System.out.println("总共耗时:" + (System.currentTimeMillis() - startTime));
		
		// 接下来使用第二种使用Future模式的异步线程通信
		System.out.println("我又要准备做饭了，这次我决定再买一种厨具，不过我想高效一点...");
		long startTime2 = System.currentTimeMillis();
		FutureTask<CookTool> task = new FutureTask<>(new BuyCookToolByFuture()); // 这才真正体现了多线程的意义
		new Thread(task).start();
		System.out.println("我要去买菜了...");
			try {
				Thread.sleep(2000);// 模拟买菜耗时
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("终于可以做饭了....");
			try {
				cook(task.get(), new Food("萝卜"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("第二次总共耗时:" + (System.currentTimeMillis() - startTime2));		
}
	public static void cook(CookTool cookTool, Food food) {
		System.out.println("我用 " + cookTool.id + " 做了一顿 " + food.name);
	}
}
class Food {
	String name;
	public Food(String name) {
		this.name = name;
	}
}
/**
 * 采用实现Callable<>接口的Future模式
 */
class BuyCookToolByFuture implements Callable<CookTool> {

	@Override
	public CookTool call() throws Exception {
		// TODO Auto-generated method stub
		// 选一款喜欢的厨具
				int id = 456; // 模拟一个id和价格
				try {
					Thread.sleep(2000); // 模拟挑选耗时
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("选好了.....");
				int price = 10; // 付款
				System.out.println("已下单等待接收,快递派送中....");
				try {
					Thread.sleep(2000); // 模拟快递配送耗时
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SimulateCook.cookTool = new CookTool(id, price); // 终于取到厨具
				System.out.println("终于取到厨具....");
		return SimulateCook.cookTool;
	}
	
}

/**
 * 采用普通的多线程模式
 * @author xzp
 *
 */
class BuyCookTool extends Thread {
	@Override
	public void run() {
		// 选一款喜欢的厨具
		int id = 123; // 模拟一个id和价格
		try {
			Thread.sleep(2000); // 模拟挑选耗时
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("选好了.....");
		int price = 10; // 付款
		System.out.println("已下单等待接收,快递派送中....");
		try {
			Thread.sleep(2000); // 模拟快递配送耗时
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimulateCook.cookTool = new CookTool(id, price); // 终于取到厨具
		System.out.println("终于取到厨具....");
	}
}
// 厨具类
class CookTool {
	int id;
	int price;
	public CookTool(int id, int price) {
		this.id = id;
		this.price = price;
	}
}
