package base.net.proxy;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ProxyTest {
	// ����������ĵ�ַ�Ͷ˿�
	final String PROXY_ADD = "129.82.12.188";
	final int PROXY_PORT = 3124;
	// ����Ҫ���ʵ���վ��ַ
	String urlStr = "http://www.zju.edu.cn";
	public void init() throws IOException, MalformedURLException {
		URL url = new URL(urlStr);
		// ����һ���������������
		java.net.Proxy proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADD, PROXY_PORT));
		// ʹ��ָ���Ĵ��������������
		URLConnection conn = url.openConnection(proxy);
		// ���ó�ʱʱ��
		conn.setConnectTimeout(3000);
		try {
			// ͨ�������������ȡ���ݵ�Scanner
			Scanner scan = new Scanner(conn.getInputStream());
			PrintStream ps = new PrintStream("index.htm");
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				// �ڿ���̨��ӡ��ҳ����
				System.out.println(line);
				// ����ҳ��Դ���������ָ�������
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
