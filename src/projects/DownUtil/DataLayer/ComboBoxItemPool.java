package projects.DownUtil.DataLayer;

import java.awt.ItemSelectable;
import java.util.ArrayList;
import java.util.List;

/**
 * ���ڴ�ComboBoxѡ����е��û���������
 * @author XZP
 *���������
 * 1. ��Ĭ�ϱ���·��
 * 2. ���û�����ʷ����·�����ṩ��ʷ����·����չ���
 */
public class ComboBoxItemPool {
	private static List<String>  items = new ArrayList<>();
	private static String DEFAULT = "D:\\MyDownloadUtil\\";
	private ComboBoxItemPool() {  // һ�㲻����ʵ����
		// !!! ��ʼ����Ҫ����������������棬��Ϊ�������̲���Ҫ������ʵ�����಻�ᱻʵ������ȻҲ�����г�ʼ��
	}
	public static String[] getItems() {
		if (items.isEmpty()) {
			items.add(ComboBoxItemPool.DEFAULT); // Ϊ������Ĭ��ֵ
		}
		String[] paths = new String[items.size()];
		items.toArray(paths);
		return paths;
	}
	public static boolean add(String path) {
		return ComboBoxItemPool.items.add(path);
	}
	public static boolean remove(String path) {
		return items.remove(path);
	}
	public static boolean removeAll() {
		return items.removeAll(items);
	}
	/**
	 * ���һ���ļ�·���Ƿ��Ѿ������б���
	 * @param path ����ʱѡ����ļ�·��
	 * @return ���ڷ���true�����򷵻�false
	 */
	public static boolean isExisting(String path) {
		return items.contains(path);
	}
}
