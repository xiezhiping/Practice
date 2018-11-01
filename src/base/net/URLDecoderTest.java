package base.net;

import java.net.URLDecoder;

import java.net.URLEncoder;;

public class URLDecoderTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 将MIME字符串转换为普通
		String keyWord = URLDecoder.decode("java%25E7%25BC%2596%25E7%25A8%258B", "utf-8");
		System.out.println(keyWord);
		// 将普通字符串转换为MIME字符串
		String urlStr = URLEncoder.encode("java编程", "gbk");
		System.out.println(urlStr);

	}

}
