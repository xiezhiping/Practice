package projects.DownUtil.Business;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projects.DownUtil.Presentation.UI;

public class BrowseButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent var1) {
		UI ui = DownloadUtil.getMainUI();
		ui.setSaveDialog(new FileDialog(ui.getFrame(), "下载内容保存位置:", FileDialog.SAVE)); 
		ui.getSaveDialog().setBounds(180, 180, 400, 250);
		ui.getSaveDialog().setIconImage(UI.getImage(UI.getBROWSE_DIALOG_LOGO()));  // 设置logo 
		ui.getSaveDialog().setFile(ui.getFileTextField().getText());
		ui.getSaveDialog().setVisible(true);
		ui.getLocationBox().setSelectedItem(ui.getSaveDialog().getDirectory()); // TODO 点击下载再加入ItemPool
		System.out.println("正确:" + ui.getSaveDialog().getDirectory()+ ui.getSaveDialog().getFile());
		DownloadUtil.getTarget().setSavePath(ui.getSaveDialog().getDirectory()+ ui.getSaveDialog().getFile()); // 关闭窗口时设置保存位置
	}

}
