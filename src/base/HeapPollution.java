/**
 * 堆污染：当把一个不带泛型的对象赋值给一个带泛型的变量时，往往就会发生
 * 1. 对于形参个数可变，该形参类型又是泛型，更容易导致“堆污染”：java在不支持泛型数组的情况，程序只能把List<String>...当成List[]处理
 */
package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HeapPollution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapPollution.faultyMethod(Arrays.asList("Hello"), Arrays.asList("World"));

	}
	@SafeVarargs
	public static void faultyMethod(List<String> ... listStrArray) {
		// 此处相当于把List<String>赋值给了List，已经发生了堆污染
		List[] listArray = listStrArray;
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(new Random().nextInt(100));
		// 把listArray的第一个元素赋值为myArray
		listArray[0] = myList;
		String string = listStrArray[0].get(0);
	}

}
