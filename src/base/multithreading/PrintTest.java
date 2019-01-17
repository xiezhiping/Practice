package base.multithreading;

public class PrintTest {
	public static volatile boolean isNum = true;
	public static Object obj = new Object();
	public static void main(String[] args) {
		PrintChar pc = new PrintChar();
		PrintNum pn = new PrintNum();
		PrintNumRunnable pnr = new PrintNumRunnable(pn);
		PrintCharRunnable pcr = new PrintCharRunnable(pc);
		Thread pnt = new Thread(pnr);
		Thread pct = new Thread(pcr);
		pnt.start();
		pct.start();
	}
}
class PrintChar {
	private char c = 'A';
	public PrintChar() {
	}
	public void print() {
		synchronized (PrintTest.obj) {
			try {
				for (int i = 0; i < 26; i++) {
					if (PrintTest.isNum == true) { // ÆæÊý´òÓ¡Êý×Ö
						PrintTest.obj.wait();
					}
					System.out.print(c);
					c++;
					if (c > 'Z') {
						c = 'A';
					}
					PrintTest.isNum = true;
					PrintTest.obj.notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
		}
		}
}
}
class PrintNum {
	private int num = 1;
	public PrintNum() {
	}
	public void print() {
	synchronized (PrintTest.obj) {
		try {
			for (int i = 0; i < 26; i++) {
				if (PrintTest.isNum == false) {
					PrintTest.obj.wait();
				}
				System.out.print(num);
				num++;
				if (num > 26) {
					num = 1;
				}
				PrintTest.isNum = false;
				PrintTest.obj.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
	}
	}
}
}

