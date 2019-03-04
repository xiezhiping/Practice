package base;

import java.util.ArrayList;
import java.util.LinkedList;

public class DequeTest {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			linkedList.add(i);
			linkedList.addLast(2);
			list.add(i);
		}
		for (int i = 9; i >=0; i--) {
			System.out.print(linkedList.get(i) + " " + " list: " + list.get(i) + " ");
		}
	}
}
