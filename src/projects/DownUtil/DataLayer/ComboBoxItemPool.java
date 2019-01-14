package projects.DownUtil.DataLayer;

import java.awt.ItemSelectable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于存ComboBox选择框中的用户缓存数据
 * @author XZP
 *解决的需求：
 * 1. 有默认保存路径
 * 2. 当用户有历史保存路径后，提供历史保存路径清空功能
 */
public class ComboBoxItemPool {
	private static List<String>  items = new ArrayList<>();
	private static String DEFAULT = "D:\\MyDownloadUtil\\";
	private ComboBoxItemPool() {  // 一般不允许实例化
		// !!! 初始化不要放在这个构造器里面，因为整个过程不需要这个类的实例，类不会被实例化自然也不会有初始化
	}
	public static String[] getItems() {
		if (items.isEmpty()) {
			items.add(ComboBoxItemPool.DEFAULT); // 为其设置默认值
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
	 * 检查一个文件路径是否已经存在列表当中
	 * @param path 保存时选择的文件路径
	 * @return 存在返回true，否则返回false
	 */
	public static boolean isExisting(String path) {
		return items.contains(path);
	}
}
