package base.multithreading.ThreadSafty;

public class SynDrawThread extends Thread {
	// ģ���û��˻�
	private SynAccount account;
	// ��ǰȡǮ�߳�ϣ��ȡ��Ǯ
	private double drawAmount;
    public SynDrawThread(String name, SynAccount account, double drawAmount) {
    	super(name);
    	this.account = account;
    	this.drawAmount = drawAmount;
    }
    // ������߳��޸�ͬһ����������ʱ�����漰���ݰ�ȫ����
    public void run() {
    	// ֱ�ӵ���account�����draw()������ִ��ȡǮ����
    	// ͬ��������ͬ����������this,Ҳ���ǵ���draw�����Ķ���
    	account.draw(drawAmount);
    }

}
