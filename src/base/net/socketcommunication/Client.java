package base.net.socketcommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("127.0.0.1", 3000);
		// ��Socket��Ӧ����������װ��BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// ������ͨIO����
		String line = br.readLine();
		System.out.println("���Է����������ݣ�" + line);
		// �ر���������Socket
		br.close();
		socket.close();
	}

}
