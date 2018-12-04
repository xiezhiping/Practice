package projects.DownUtil.Business;

import base.net.download.DownUtil;
import projects.DownUtil.DataLayer.DownloadTarget;
import projects.DownUtil.Presentation.UI;

public class DownloadUtil {
	private static DownloadUtil UTIL = null; // ȫ��Ψһ����
	private static UI mainUI = null;
	private static DownloadTarget target = null;
	private DownloadUtil() {
		// ��ʼ��UI
		mainUI = new UI();
		// ��ʼ��һ�����ض���
		target = new DownloadTarget();
		// ִ��
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
