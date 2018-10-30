package base.multithreading.ThreadSafty;

public class DrawThread extends Thread {
	// ģ���û��˻�
	private Account account;
	// ��ǰȡǮ�߳�ϣ��ȡ��Ǯ
	private double drawAmount;
    public DrawThread(String name, Account account, double drawAmount) {
    	super(name);
    	this.account = account;
    	this.drawAmount = drawAmount;
    }
    // ������߳��޸�ͬһ����������ʱ�����漰���ݰ�ȫ����
    public void run() {
    	// �˻�������ȡ����Ŀ
    	if (account.getBalance() >= drawAmount) {
    		// �³�Ʊ
    		System.out.println(getName() + "ȡǮ�ɹ���ȡ����Ʊ��" + drawAmount);
    		try { // ִ���߳��л��Ĵ���
    			Thread.sleep(1000);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		// �޸����
    		account.setBalance(account.getBalance() - drawAmount);
    		System.out.println("\t���Ϊ��" + account.getBalance());
    	} else {
    		System.out.println(getName() + "ȡǮʧ�ܣ����㣡");
    	}
    }

}
