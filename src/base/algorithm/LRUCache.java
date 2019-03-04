package base.algorithm;

import java.util.LinkedHashMap;

import base.NULL;

public class LRUCache<V> {
	private int capacity = 16; // ���û���Ĭ��ֵ
	private Node<V> head = null; // ͷָ��
	private Node<V> tail = null; // βָ��
	private int count;
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	public void read(V value) {
		if (head == null) {
			System.out.println("����Ϊ��");
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
	// �����������������
	public void push(V value) {
		count++;
		if (count > capacity) { // �����˻����СҪɾ��tail
			removeTail();
		}
		insertHead(value);
	}
	// �ж�����ڵ��Ƿ���head�ڵ����tail�ڵ�����
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
	// ɾ��β���Ĵ���
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
	// ��ͷ����
	private void insertHead(V value) {
		Node<V> node = new Node<V>(value);
		if (head == null) {
			head = node;
		} else {
			head.setPre(node);
			node.setNext(head);
			head = node;
		}
		if (tail == null) { // ���Ϊ��Ҫ����һ��
			tail = node;
		}
	}
}
// ���ݽڵ�
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
