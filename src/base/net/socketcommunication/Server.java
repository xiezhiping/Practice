package base.net.socketcommunication;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		// ����һ��ServerSocket�����ڼ����ͻ���Socket����������
		ServerSocket ss = new ServerSocket(3000);
		// ����ѭ�����ϵĽ������Կͻ��˵�����
		while(true) {
			// ÿ�����յ��ͻ���Socket����ʱ��������Ҳ����һ����Ӧ��Socket
			Socket s = ss.accept();
			// ��Socket��Ӧ���������װ��PrintStream
			PrintStream ps = new PrintStream(s.getOutputStream());
			try {
				// ������ͨIO����
				ps.println("���ã����յ��˷�������������Ϣ");
			}
			finally {
				ps.close();
				s.close();
			}
		}
	}
}
