package base.algorithm;

import java.util.LinkedHashMap;

import base.NULL;

public class LRUCache<V> {
	private int capacity = 16; // 设置缓存默认值
	private Node<V> head = null; // 头指针
	private Node<V> tail = null; // 尾指针
	private int count;
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	public void read(V value) {
		if (head == null) {
			System.out.println("缓存为空");
		}
		Node next = head;
		while(next != null) {
			if (next.getValue() == value) {
				remove(next);
				insertHead((V) next.getValue());
			}
			next = next.getNext();
		}
	}
	// 往缓存里面插入数据
	public void push(V value) {
		count++;
		if (count > capacity) { // 超过了缓存大小要删除tail
			removeTail();
		}
		insertHead(value);
	}
	// 判断这个节点是否是head节点或者tail节点的情况
	private void remove(Node node) {
		if (node.getPre() != null) {
			node.getPre().setNext(node.getNext());			
		}
		if (node.getNext() != null) {
			node.getNext().setPre(node.getPre());			
		}
		node.setPre(null);
		node.setNext(null);
	}
	// 删除尾部的代码
	private void removeTail() {
		if (tail == null) {
			return;
		} else {
			if (tail.getPre() == null) {
				tail = null;
			} else {
				tail.getPre().setNext(null);
				tail = tail.getPre();
			}
		}
		count--;
	}
	// 从头插入
	private void insertHead(V value) {
		Node<V> node = new Node<V>(value);
		if (head == null) {
			head = node;
		} else {
			head.setPre(node);
			node.setNext(head);
			head = node;
		}
		if (tail == null) { // 如果为空要处理一下
			tail = node;
		}
	}
}
// 数据节点
class Node<V> {
	private V value;
	private Node<V> pre;
	private Node<V> next;
	public Node(V value) {
		this.value = value;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public Node<V> getPre() {
		return pre;
	}
	public void setPre(Node<V> pre) {
		this.pre = pre;
	}
	public Node<V> getNext() {
		return next;
	}
	public void setNext(Node<V> next) {
		this.next = next;
	}
}
