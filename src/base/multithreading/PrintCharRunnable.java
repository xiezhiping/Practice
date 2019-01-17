package base.multithreading;

public class PrintCharRunnable implements Runnable{
	private PrintChar pc;
	public PrintCharRunnable(PrintChar pc) {
		// TODO Auto-generated constructor stub
		this.pc  = pc;
	}
	@Override
	public void run() {
		pc.print();
	}
}
