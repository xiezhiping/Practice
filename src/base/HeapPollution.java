/**
 * ����Ⱦ������һ���������͵Ķ���ֵ��һ�������͵ı���ʱ�������ͻᷢ��
 * 1. �����βθ����ɱ䣬���β��������Ƿ��ͣ������׵��¡�����Ⱦ����java�ڲ�֧�ַ�����������������ֻ�ܰ�List<String>...����List[]����
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
		// �˴��൱�ڰ�List<String>��ֵ����List���Ѿ������˶���Ⱦ
		List[] listArray = listStrArray;
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(new Random().nextInt(100));
		// ��listArray�ĵ�һ��Ԫ�ظ�ֵΪmyArray
		listArray[0] = myList;
		String string = listStrArray[0].get(0);
	}

}
