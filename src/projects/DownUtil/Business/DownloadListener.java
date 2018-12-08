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
		// 然后开始多线程下载
		try {
			// 初始化一个进度条
			Timer timer = null;
			timer = new Timer(300, e -> {
				ProgressMonitor dialog = Main.getMainUI().getProgressMonitor();
				int completed = MultiThreadDownload.getCompleteRate();
				dialog.setProgress(completed);
				dialog.setNote("已完成: " + completed + " %");
				if (completed >= 99 && !dialog.isCanceled()) {
					System.out.println("下载完成，用时：" + (System.currentTimeMillis()-startTime) + "ms");
				}
				if (dialog.isCanceled()) {
					// 停止计数器
					System.exit(0);
				}
			});
			timer.start();
			new MultiThreadDownload(Main.getInstance().getTarget()).download();
		}
		catch(MalformedURLException urlException) { // 如果是URL无效，当用户点击下载时弹出提示框
			JOptionPane.showMessageDialog(Main.getMainUI().getFrame(), "您输入的URL不正确,请重新输入");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
