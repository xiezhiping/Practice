package base.IO;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class CharsetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��ȡjava֧�ֵ�ȫ���ַ���
		SortedMap<String, Charset> map = Charset.availableCharsets();
		for (String alias: map.keySet()) {
			System.out.println(alias + "---->" + map.get(alias));
		}

	}

}
