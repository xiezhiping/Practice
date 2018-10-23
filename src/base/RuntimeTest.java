package base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RuntimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();
		System.out.println("处理器数量：" + runtime.availableProcessors() + " 空闲：" + runtime.freeMemory() + "总内存：" + runtime.totalMemory());
		System.out.print(runtime.getClass());
		List<?> c = new ArrayList<String>();
		c.add(null);
		System.out.println(c);
		// test

	}

}
