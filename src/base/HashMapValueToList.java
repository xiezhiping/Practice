package base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 研读HashMap源码的基础上探究获取HashMap的Value放入list中耗时情况
 * @author XZP
 * 三种实现思路：
 * 1. 通过先获取key然后一个一个的get
 * 2. 通过直接获取value然后放入
 * 3. 通过获取EntrySet
 */
public class HashMapValueToList {
	public static void main(String[] args) {
		HashMap<Integer, String> hashmap = new HashMap<>();
		List list1 = new ArrayList<>();
		List list2 = new ArrayList<>();
		List list3 = new ArrayList<>();
		for(int i = 0; i < 10000000; i++) {
			hashmap.put(i, "value" + i);
		}
		// 第一种方法
		long s1 = System.nanoTime();
		for(Integer key : hashmap.keySet()) {
			list1.add(hashmap.get(key));
		}
		long e1 = System.nanoTime();
		System.out.println("第一种: " + (e1 - s1) / 1000);
		// 第二种方法
		long s2 = System.nanoTime();
		for(String value : hashmap.values()) {
			list2.add(value);
			}
		long e2 = System.nanoTime();
		System.out.println("第二种： " + (e2 - s2) / 1000);
		// 第三种
		long s3 = System.nanoTime();
		Set<Entry<Integer, String>> eSet = hashmap.entrySet();
		for (Entry e : eSet) {
			list3.add(e.getValue());
		}
		long e3 = System.nanoTime();
		System.out.println("第三次: " + (e3 - s3) / 1000);
		
	}
	
}
