package base.net;

import java.net.URLDecoder;

import java.net.URLEncoder;;

public class URLDecoderTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// ��MIME�ַ���ת��Ϊ��ͨ
		String keyWord = URLDecoder.decode("java%25E7%25BC%2596%25E7%25A8%258B", "utf-8");
		System.out.println(keyWord);
		// ����ͨ�ַ���ת��ΪMIME�ַ���
		String urlStr = URLEncoder.encode("java���", "gbk");
		System.out.println(urlStr);

	}

}
