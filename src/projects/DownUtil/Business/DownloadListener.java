package projects.DownUtil.Business;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;
import javax.swing.ProgressMonitor;
import javax.swing.Timer;

import projects.DownUtil.DataLayer.ComboBoxItemPool;

public class DownloadListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent var1) {
		long startTime = System.currentTimeMillis();
		Main.getInstance().getTarget().setSavePath(Main.getMainUI().getLocationBox().getSelectedItem().toString() + Main.getMainUI().getFileTextField().getText());
		System.out.println("path:::" + Main.getMainUI().getLocationBox().getSelectedItem().toString()  + Main.getMainUI().getFileTextField().getText());
		// Ȼ��ʼ���߳�����
		try {
			// ��ʼ��һ��������
			Timer timer = null;
			timer = new Timer(300, e -> {
				ProgressMonitor dialog = Main.getMainUI().getProgressMonitor();
				int completed = MultiThreadDownload.getCompleteRate();
				dialog.setProgress(completed);
				dialog.setNote("�����: " + completed + " %");
				if (completed >= 99 && !dialog.isCanceled()) {
					System.out.println("������ɣ���ʱ��" + (System.currentTimeMillis()-startTime) + "ms");
				}
				if (dialog.isCanceled()) {
					// ֹͣ������
					System.exit(0);
				}
			});
			timer.start();
			new MultiThreadDownload(Main.getInstance().getTarget()).download();
		}
		catch(MalformedURLException urlException) { // �����URL��Ч�����û��������ʱ������ʾ��
			JOptionPane.showMessageDialog(Main.getMainUI().getFrame(), "�������URL����ȷ,����������");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
