package projects.DownUtil.Business;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import projects.DownUtil.DataLayer.ComboBoxItemPool;
import projects.DownUtil.Presentation.URLExceptionWarning;

public class DownloadListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent var1) {
		// ��֤������Ϣ�Ƿ���ȷ
		// ���������Ϣ����Ҫ����ΪTarget���³�����Ϣ
		// �������ȷ�򵯳���ʾ��
		// ��������һ��ֵ
		Main.getInstance().getTarget().setSavePath(Main.getMainUI().getLocationBox().getSelectedItem().toString() + Main.getMainUI().getFileTextField().getText());
		System.out.println("path:::" + Main.getMainUI().getLocationBox().getSelectedItem().toString()  + Main.getMainUI().getFileTextField().getText());
		// Ȼ��ʼ���߳�����
		try {
			new MultiThreadDownload(Main.getInstance().getTarget()).download();
		}
		catch(MalformedURLException urlException) { // �����URL��Ч�����û��������ʱ������ʾ��
//			Dialog exceptionDialog = new Dialog(DownloadUtil.getMainUI().getFrame(), "test");
//			exceptionDialog.setBounds(180, 180, 150, 100);
//			exceptionDialog.
//			exceptionDialog.setVisible(true);
			new URLExceptionWarning(Main.getMainUI().getFrame());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
