package projects.DownUtil.Business;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBoxListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		String path = e.getItem().toString();
	}

}
