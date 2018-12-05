package projects.DownUtil.Business;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projects.DownUtil.Presentation.UI;

public class BrowseButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent var1) {
		UI ui = Main.getMainUI();
		ui.setSaveDialog(new FileDialog(ui.getFrame(), "下载内容保存位置:", FileDialog.SAVE)); 
		ui.getSaveDialog().setBounds(180, 180, 400, 250);
		ui.getSaveDialog().setIconImage(UI.getImage(UI.getBROWSE_DIALOG_LOGO()));  // 设置logo 
		ui.getSaveDialog().setFile(ui.getFileTextField().getText());
		ui.getSaveDialog().setVisible(true);
		// 获取当前对话框中的文件名
		String nowFileName = ui.getSaveDialog().getFile();
		// 判断用户是否修改了文件名
		if (this.isModified(nowFileName)) {
			// 如果文件名被修改，跟着更改下载框中的FileName
			ui.getFileTextField().setText(nowFileName);
		}
		ui.getLocationBox().setSelectedItem(ui.getSaveDialog().getDirectory()); // TODO 点击下载再加入ItemPool
		System.out.println("正确:" + ui.getSaveDialog().getDirectory()+ nowFileName);
		Main.getTarget().setSavePath(ui.getSaveDialog().getDirectory()+ ui.getSaveDialog().getFile()); // 关闭窗口时设置保存位置
	}
	public boolean isModified(String name) {
		return Main.getMainUI().getFileTextField().getText() != name;
	}
}
