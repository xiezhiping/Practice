package base.jvm.reflection;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;


public class ObjectPoolFactory {
	private java.util.Map<String, Object> objectPool = new HashMap();
	// 定义一个根据类名字符串创建对象的方法
	private Object createObject(String clazzName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName(clazzName);
		return clazz.newInstance();
	}
	public void initPool(String fileName) {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			Properties properties = new Properties();
			properties.load(fis);
			for (String name : properties.stringPropertyNames()) {
				objectPool.put(name, createObject(properties.getProperty(name)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Object getObject(String name) {
		return objectPool.get(name);
	}
	public static void main(String[] args) {
		ObjectPoolFactory pf = new ObjectPoolFactory();
		pf.initPool("F:\\java_workspace\\Practice\\src\\base\\jvm\\reflection\\obj.txt");
		System.out.println(pf.getObject("a"));
		System.out.println(pf.getObject("b"));
	}
}
