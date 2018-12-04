package projects.DownUtil.Business;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class URLTextFieldListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent var1) {
		
	}

	@Override
	public void focusLost(FocusEvent var1) {
		DownloadUtil.getInstance().getTarget().setUrl(DownloadUtil.getMainUI().getUrlTextField().getText());	
	}
}
