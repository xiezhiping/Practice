package base.algorithm;

import java.util.HashMap;

public class LRUTest {
	public static void main(String[] args) {
		LRU lru = new LRU(10);
		for (int i = 0; i < 10; i++) {
			lru.set("ABC", i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.print(lru.get("ABC") + " ");
		}
	}
}
class LRU {
	private HashMap<String, Node> map;
	private int capacity;
	private Node head;
	private Node tail;
	public void set(String key, Object value) {
		Node node = map.get(key);
		if (node == null) {
			node = new Node(key, value);
			if (map.size() >= capacity) {
				// 每次容量不足删除最久未使用的元素
				remove(tail, true);
			}
		} else {
			node = map.get(key);
			node.value = value;
			remove(node, false);
		}
		// 将新添加的元素置为head
		setHead(node);
	}
	public Object get(String key) {
		Node node = map.get(key);
		if (node != null) {
			// 将操作过的元素置为head
			remove(node, false);
			setHead(node);
			return node.value;
		}
		return null;
	}
	private void setHead(Node node) {
		// 先从该链表中删除该元素
		if (head != null) {
			node.next = head;
			head.pre = node;
		}
		head = node;
		if (tail == null) {
			tail = node;
		}
	}
	private void remove(Node node, boolean flag) {
		if (node.pre != null) {
			node.pre.next = node.next;
		} else {
			head = node.next;
		}
		if (node.next != null) {
			node.next.pre = node.pre;
		} else {
			tail = node.pre;
		}
		node.next = null;
		node.pre = null;
		if (flag) {
			map.remove(node.key);
		}
	}
	public LRU(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
	}
}
class Node {
	String key;
	Object value;
	Node pre;
	Node next;
	public Node(String key, Object value) {
		this.key = key;
		this.value = value;
	}
}