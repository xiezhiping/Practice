package projects.DownUtil.Business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projects.DownUtil.DataLayer.ComboBoxItemPool;

public class DownloadListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent var1) {
		// 首先校验
		// 然后开始多线程下载
		try {
			new MultiThreadDownload(DownloadUtil.getInstance().getTarget()).download();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
