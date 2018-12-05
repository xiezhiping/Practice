package projects.DownUtil.Business;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FileTextFieldListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent var1) { // �õ�����ʱ����
		System.out.println("focused");
		
	}

	@Override
	public void focusLost(FocusEvent var1) {
		Main.getInstance().getTarget().setName(Main.getMainUI().getFileTextField().getText());
	}
}
