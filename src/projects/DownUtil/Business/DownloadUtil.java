package projects.DownUtil.Business;

import base.net.download.DownUtil;
import projects.DownUtil.DataLayer.DownloadTarget;
import projects.DownUtil.Presentation.UI;

public class DownloadUtil {
	private static DownloadUtil UTIL = null; // 全局唯一引用
	private static UI mainUI = null;
	private static DownloadTarget target = null;
	private DownloadUtil() {
		// 初始化UI
		mainUI = new UI();
		// 初始化一个下载对象
		target = new DownloadTarget();
		// 执行
	}
	public static DownloadUtil getInstance() {
		if (DownloadUtil.UTIL == null) {
			DownloadUtil.UTIL = new DownloadUtil();
		}
		return DownloadUtil.UTIL;
	}
	public static void main(String[] args) {
		DownloadUtil.getInstance();
		
	}
	public static UI getMainUI() {
		return mainUI;
	}
	public static void setMainUI(UI mainUI) {
		DownloadUtil.mainUI = mainUI;
	}
	public static DownloadTarget getTarget() {
		return target;
	}
	public static void setTarget(DownloadTarget target) {
		DownloadUtil.target = target;
	}

}
