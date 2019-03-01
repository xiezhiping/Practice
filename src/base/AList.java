package base;

public class AList<T> {
	private Node<T> head;
	public Node<T> getHead() {
		return head;
	}
	public void setHead(Node<T> head) {
		this.head = head;
	}
	public AList(T data) {
		this.head = new Node<>(data);
	}
	public void headInsert(T data) {
		Node<T> node = new Node<>(data);
		node.setNext(head.getNext());
		head.setNext(node);
	}
	public void tailInsert(T data) {
		Node<T> node = new Node(data);
		if (head.getNext() == null) {
			head.setNext(node);
		} else {
			Node<T> p = head;
			while(p.getNext() != null) {
				p = p.getNext();
			}
			p.setNext(node);
		}
	}
	public void show() {
		Node<T> node = head.getNext();
		while(node != null) {
			System.out.print(node.getData() + " ");
			node = node.getNext();
		}
		System.out.println();
	}
	public boolean delete(T data) {
		Node<T> node = head.getNext();
		Node<T> s = head;
		while(node != null) {
			if (node.getData().equals(data)) {
				s.setNext(node.getNext());
				return true;
			}
			s = node;
			node = node.getNext();
		}
		return false;
	}
	public static void main(String[] args) {
		AList<Integer> list = new AList<Integer>(-1);
		for(int i = 0; i < 10; i++) {
			list.headInsert(i);
		}
		list.delete(7);
		list.show();
	}
 }
class Node<E> {
	private E data; // 链表存储的数据
	private Node next; // 下一个节点
	public Node(E data) {
		this.data = data;
	}
	public E getData() {
		return this.data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public Node<E> getNext() {
		return this.next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
}
