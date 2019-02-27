package base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * �ж�HashMapԴ��Ļ�����̽����ȡHashMap��Value����list�к�ʱ���
 * @author XZP
 * ����ʵ��˼·��
 * 1. ͨ���Ȼ�ȡkeyȻ��һ��һ����get
 * 2. ͨ��ֱ�ӻ�ȡvalueȻ�����
 * 3. ͨ����ȡEntrySet
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
		// ��һ�ַ���
		long s1 = System.nanoTime();
		for(Integer key : hashmap.keySet()) {
			list1.add(hashmap.get(key));
		}
		long e1 = System.nanoTime();
		System.out.println("��һ��: " + (e1 - s1) / 1000);
		// �ڶ��ַ���
		long s2 = System.nanoTime();
		for(String value : hashmap.values()) {
			list2.add(value);
			}
		long e2 = System.nanoTime();
		System.out.println("�ڶ��֣� " + (e2 - s2) / 1000);
		// ������
		long s3 = System.nanoTime();
		Set<Entry<Integer, String>> eSet = hashmap.entrySet();
		for (Entry e : eSet) {
			list3.add(e.getValue());
		}
		long e3 = System.nanoTime();
		System.out.println("������: " + (e3 - s3) / 1000);
		
	}
	
}
