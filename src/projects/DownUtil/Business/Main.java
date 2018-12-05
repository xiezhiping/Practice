package projects.DownUtil.Business;

import base.net.download.DownUtil;
import projects.DownUtil.DataLayer.DownloadTarget;
import projects.DownUtil.Presentation.UI;

public class Main {
	private static Main UTIL = null; // 全局唯一引用
	private static UI mainUI = null;
	private static DownloadTarget target = null;
	private Main() {
		// 初始化UI
		mainUI = new UI();
		// 初始化一个下载对象
		target = new DownloadTarget();
		// 执行
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
