package projects.DownUtil.Business;

import base.net.download.DownUtil;
import projects.DownUtil.Presentation.UI;

public class DownloadUtil {
	public static DownloadUtil downloadUtil = null; // ȫ��Ψһ����
	private static UI mainUI = null;
	private static String url = "initUrl";
	private static String fileName = "initFileName";
	private String path = "";
	public DownloadUtil() {
		// ��ʼ��UI
		mainUI = new UI();
		// ִ��
	}
	public static void main(String[] args) {
		downloadUtil = new DownloadUtil();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String prth) {
		this.path = prth;
	}
	public static UI getMainUI() {
		return mainUI;
	}
	public static void setMainUI(UI mainUI) {
		DownloadUtil.mainUI = mainUI;
	}

}
