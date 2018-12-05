package projects.DownUtil.Business;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import java.util.regex.*;;

public class URLTextFieldListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent var1) {
//		String fileName = this.getFileName(DownloadUtil.getMainUI().getUrlTextField().getText());
//		if ( fileName!=null) {
//			DownloadUtil.getMainUI().getFileTextField().setText(fileName);
//		}
	}

	@Override
	public void focusLost(FocusEvent var1) {
		Main.getInstance().getTarget().setUrl(Main.getMainUI().getUrlTextField().getText());
		// ʧȥ����ʱΪfileName�������ļ���  # TODO ����ʱ��Ҳ���ǵ��˸��Ż��Ľ��������������ʱ���Ϊ������ճ��ͬ��
		String fileName = this.getFileName(Main.getMainUI().getUrlTextField().getText());
		if ( fileName!=null) {
			Main.getMainUI().getFileTextField().setText(fileName);
		}
	}
	/**
	 * ��һ��URL�ַ�������ȡ���ļ���  # TODO ��ý���Щ���߷�����ȡ��������util��
	 * @param url 
	 * @return ����У������ҵ����ļ��������û���򷵻�null
	 */
	private String getFileName(String url) {
		// ������ʽregEx�ĺ����ǣ�
		// ��ƥ����ַ�����������ַ����п�ʼ����������ַ���/��
		// ����������ַ����н�β����()��������飬������ǽ��ļ�����Ϊ���飬ƥ����Ͽ���ͨ��
		// Matcher���group����ȡ�����Ƕ���ķ��飬���ҷ�������ֵ�Ǵ�1��ʼ�ģ����Է���m.group(0)
		String regEx = ".+/(.+)$";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(url);
		if (m.find()) {
			return m.group(1);
		}
		return null;
	}
}
