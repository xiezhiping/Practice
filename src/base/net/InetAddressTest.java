package base.net;

import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// ������������ȡ��Ӧ��InetAddressʵ��
		InetAddress ip = InetAddress.getByName("www.zju.edu.cn");
		// �ж��Ƿ�ɴ�
		System.out.println("��ip�Ƿ�ɴ�:" + ip.isReachable(2000));
		// ��ȡ��ʵ����IP�ַ���
		System.out.println(ip.getHostAddress());
		// ����ԭʼIP��ȡ��Ӧ��InetAddressʵ��
		InetAddress local = InetAddress.getByAddress(new byte[] {127,0,0,1});
		System.out.println("�����Ƿ�ɴ" + local.isReachable(5000));
		// ��ȡ��ʵ����Ӧ��ȫ�޶�����
		System.out.println(local.getCanonicalHostName());

	}

}
