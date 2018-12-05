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
		// 验证下载信息是否正确
		// 如果下载信息符合要求，则为Target更新持有信息
		// 如果不正确则弹出提示框
		// 首先设置一下值
		Main.getInstance().getTarget().setSavePath(Main.getMainUI().getLocationBox().getSelectedItem().toString() + Main.getMainUI().getFileTextField().getText());
		System.out.println("path:::" + Main.getMainUI().getLocationBox().getSelectedItem().toString()  + Main.getMainUI().getFileTextField().getText());
		// 然后开始多线程下载
		try {
			new MultiThreadDownload(Main.getInstance().getTarget()).download();
		}
		catch(MalformedURLException urlException) { // 如果是URL无效，当用户点击下载时弹出提示框
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
