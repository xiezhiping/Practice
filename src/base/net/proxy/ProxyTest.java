package base.net.proxy;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ProxyTest {
	// 代理服务器的地址和端口
	final String PROXY_ADD = "129.82.12.188";
	final int PROXY_PORT = 3124;
	// 定义要访问的网站地址
	String urlStr = "http://www.zju.edu.cn";
	public void init() throws IOException, MalformedURLException {
		URL url = new URL(urlStr);
		// 创建一个代理服务器对象
		java.net.Proxy proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADD, PROXY_PORT));
		// 使用指定的代理服务器打开连接
		URLConnection conn = url.openConnection(proxy);
		// 设置超时时间
		conn.setConnectTimeout(3000);
		try {
			// 通过代理服务器读取数据的Scanner
			Scanner scan = new Scanner(conn.getInputStream());
			PrintStream ps = new PrintStream("index.htm");
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				// 在控制台打印网页内容
				System.out.println(line);
				// 将网页资源内容输出到指定输出流
				ps.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException, MalformedURLException {
		// TODO Auto-generated method stub
		new ProxyTest().init();
	}

}
