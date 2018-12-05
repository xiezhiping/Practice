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
		// 失去焦点时为fileName框设置文件名  # TODO 做的时候也考虑到了更优化的解决方案，后面有时间改为跟复制粘贴同步
		String fileName = this.getFileName(Main.getMainUI().getUrlTextField().getText());
		if ( fileName!=null) {
			Main.getMainUI().getFileTextField().setText(fileName);
		}
	}
	/**
	 * 从一个URL字符串中提取出文件名  # TODO 最好将这些工具方法提取到单独的util类
	 * @param url 
	 * @return 如果有，返回找到的文件名，如果没有则返回null
	 */
	private String getFileName(String url) {
		// 正则表达式regEx的含义是：
		// 被匹配的字符串以任意的字符序列开始，后面紧跟字符“/”
		// 最后以任意字符序列结尾，“()”代表分组，这里就是将文件名作为分组，匹配完毕可以通过
		// Matcher类的group方法取到我们定义的分组，而且分组索引值是从1开始的，所以返回m.group(0)
		String regEx = ".+/(.+)$";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(url);
		if (m.find()) {
			return m.group(1);
		}
		return null;
	}
}
