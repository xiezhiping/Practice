package base.jvm;

import java.net.URL;

public class BootstrapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 获取根类加载器所加载的全部URL数组
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		// 遍历并输出
		for (URL url: urls) {
			System.out.println(url.toExternalForm());
		}
	}

}
