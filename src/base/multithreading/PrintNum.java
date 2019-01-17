//package base.multithreading;
//
//public class PrintNum {
//	private int no;
//	private int num = 1;
//	public PrintNum(int no) {
//		this.no = no;
//	}
//	public synchronized void print() {
//		if (no > 52) {
//			return;
//		}
//		try {
//			while (no % 2 == 0) {
//				wait();
//			}
//			System.out.print(num);
//			if (num == 26) {
//				num = 1;
//			}
//			no++;
//			notifyAll();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//	}
//}
//}
