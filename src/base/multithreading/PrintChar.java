//package base.multithreading;
//
//public class PrintChar1 {
//	private int no;
//	private char c = 'A';
//	public PrintChar(int no) {
//		this.no = no;
//	}
//	public synchronized void print() {
//		if (no > 52) {
//			return;
//		}
//		try {
//			while (no % 2 != 0) {
//				wait();
//			}
//			System.out.print(c);
//			if (c > 'Z') {
//				c = 'A';
//			}
//			no++;
//			notifyAll();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//	}
//}
//}
