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
	 * 向指定URL发送GET方式的请求
	 * @param url 发送请求的URL
	 * @param param 请求参数，格式满足key1 = value1 & key2 = value2的形式
	 * @return URL 代表远程资源的响应
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		String urlName = url + "?" + param;
		try {
			URL realUrl = new URL(urlName);
			// 打开和URL之间的链接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的属性请求
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozililla/4.0 (compatible; MSIE 6.0; Windows 10)");
			// 建立实际的链接
			conn.connect();
			// 获取所有的响应头字段
			Map<String, List<String>> map = conn.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key: map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义BufferReader输入流来读取URL响应
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
	 * 向指定URL发送POST方式的请求
	 * @param url 发送请求的URL
	 * @param param 请求参数，格式应该满足key1 = value1 & key2 = value2
	 * @return URL 代表远程资源的响应
	 */
	public static String sendPost(String url, String param) {
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的链接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozililla/4.0 (compatible; MSIE 6.0; Windows 10)");
			// 发送POST请求必须设置如下两行
			conn.setDoInput(true);
			conn.setDoOutput(true);
			// 获取URLConnection对象对应的输入流
			PrintWriter out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输入流的缓冲
			out.flush();
			// 定义BufferReader输入流来读取URL的响应
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
	// 测试发送GET请求和发送POST请求
	public static void main(String[] args) {
		// 发送GET请求
		String s = GetPostTest.sendGet("http://www.zju.edu.cn/", null);
		System.out.println("GET请求返回的数据：" + s);
		// 发送POST请求
		String string = GetPostTest.sendPost("https://baike.baidu.com/item/%E6%B5%99%E6%B1%9F%E5%A4%A7%E5%AD%A6/127901?fr=aladdin", null);
		System.out.println("POST请求返回的数据：" + string);
	}
}
