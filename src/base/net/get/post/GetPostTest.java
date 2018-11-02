package base.net.get.post;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class GetPostTest {
	/**
	 * ��ָ��URL����GET��ʽ������
	 * @param url ���������URL
	 * @param param �����������ʽ����key1 = value1 & key2 = value2����ʽ
	 * @return URL ����Զ����Դ����Ӧ
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		String urlName = url + "?" + param;
		try {
			URL realUrl = new URL(urlName);
			// �򿪺�URL֮�������
			URLConnection conn = realUrl.openConnection();
			// ����ͨ�õ���������
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozililla/4.0 (compatible; MSIE 6.0; Windows 10)");
			// ����ʵ�ʵ�����
			conn.connect();
			// ��ȡ���е���Ӧͷ�ֶ�
			Map<String, List<String>> map = conn.getHeaderFields();
			// �������е���Ӧͷ�ֶ�
			for (String key: map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// ����BufferReader����������ȡURL��Ӧ
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line;
			while ((line = br.readLine()) != null) {
				result += "\n" + line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * ��ָ��URL����POST��ʽ������
	 * @param url ���������URL
	 * @param param �����������ʽӦ������key1 = value1 & key2 = value2
	 * @return URL ����Զ����Դ����Ӧ
	 */
	public static String sendPost(String url, String param) {
		String result = "";
		try {
			URL realUrl = new URL(url);
			// �򿪺�URL֮�������
			URLConnection conn = realUrl.openConnection();
			// ����ͨ�õ���������
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozililla/4.0 (compatible; MSIE 6.0; Windows 10)");
			// ����POST�������������������
			conn.setDoInput(true);
			conn.setDoOutput(true);
			// ��ȡURLConnection�����Ӧ��������
			PrintWriter out = new PrintWriter(conn.getOutputStream());
			// �����������
			out.print(param);
			// flush�������Ļ���
			out.flush();
			// ����BufferReader����������ȡURL����Ӧ
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line = "";
			while ((line = in.readLine()) != null) {
				result += "\n" +line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// ���Է���GET����ͷ���POST����
	public static void main(String[] args) {
		// ����GET����
		String s = GetPostTest.sendGet("http://www.zju.edu.cn/", null);
		System.out.println("GET���󷵻ص����ݣ�" + s);
		// ����POST����
		String string = GetPostTest.sendPost("https://baike.baidu.com/item/%E6%B5%99%E6%B1%9F%E5%A4%A7%E5%AD%A6/127901?fr=aladdin", null);
		System.out.println("POST���󷵻ص����ݣ�" + string);
	}
}
