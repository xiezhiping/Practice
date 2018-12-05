package projects.DownUtil.Business;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projects.DownUtil.Presentation.UI;

public class BrowseButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent var1) {
		UI ui = Main.getMainUI();
		ui.setSaveDialog(new FileDialog(ui.getFrame(), "�������ݱ���λ��:", FileDialog.SAVE)); 
		ui.getSaveDialog().setBounds(180, 180, 400, 250);
		ui.getSaveDialog().setIconImage(UI.getImage(UI.getBROWSE_DIALOG_LOGO()));  // ����logo 
		ui.getSaveDialog().setFile(ui.getFileTextField().getText());
		ui.getSaveDialog().setVisible(true);
		// ��ȡ��ǰ�Ի����е��ļ���
		String nowFileName = ui.getSaveDialog().getFile();
		// �ж��û��Ƿ��޸����ļ���
		if (this.isModified(nowFileName)) {
			// ����ļ������޸ģ����Ÿ������ؿ��е�FileName
			ui.getFileTextField().setText(nowFileName);
		}
		ui.getLocationBox().setSelectedItem(ui.getSaveDialog().getDirectory()); // TODO ��������ټ���ItemPool
		System.out.println("��ȷ:" + ui.getSaveDialog().getDirectory()+ nowFileName);
		Main.getTarget().setSavePath(ui.getSaveDialog().getDirectory()+ ui.getSaveDialog().getFile()); // �رմ���ʱ���ñ���λ��
	}
	public boolean isModified(String name) {
		return Main.getMainUI().getFileTextField().getText() != name;
	}
}
