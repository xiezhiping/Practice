package base.multithreading;

public class PrintNumRunnable implements Runnable {
	private PrintNum pnNum;
	public PrintNumRunnable(PrintNum pn) {
		 this.pnNum = pn;
	}
	@Override
	public void run() {
		pnNum.print();
	}
	
}
