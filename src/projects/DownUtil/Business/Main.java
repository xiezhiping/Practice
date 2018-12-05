package projects.DownUtil.Business;

import base.net.download.DownUtil;
import projects.DownUtil.DataLayer.DownloadTarget;
import projects.DownUtil.Presentation.UI;

public class Main {
	private static Main UTIL = null; // ȫ��Ψһ����
	private static UI mainUI = null;
	private static DownloadTarget target = null;
	private Main() {
		// ��ʼ��UI
		mainUI = new UI();
		// ��ʼ��һ�����ض���
		target = new DownloadTarget();
		// ִ��
	}
	public static Main getInstance() {
		if (Main.UTIL == null) {
			Main.UTIL = new Main();
		}
		return Main.UTIL;
	}
	public static void main(String[] args) {
		Main.getInstance();
		
	}
	public static UI getMainUI() {
		return mainUI;
	}
	public static void setMainUI(UI mainUI) {
		Main.mainUI = mainUI;
	}
	public static DownloadTarget getTarget() {
		return target;
	}
	public static void setTarget(DownloadTarget target) {
		Main.target = target;
	}

}
