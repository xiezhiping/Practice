package base;

import java.util.ArrayList;
import java.util.Iterator;

public class ATest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
//		for(int i = 0; i < 5; i++) {
//			System.out.println(list.get(i));
//			list.remove(i);
//		}
		Iterator<Integer> ite = list.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
			ite.remove();
		}
	}
}
