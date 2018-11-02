package base.net.socketcommunication;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		// 创建一个ServerSocket，用于监听客户端Socket的链接请求
		ServerSocket ss = new ServerSocket(3000);
		// 采用循环不断的接收来自客户端的请求
		while(true) {
			// 每当接收到客户端Socket请求时，服务器也产生一个对应的Socket
			Socket s = ss.accept();
			// 将Socket对应的输出流包装成PrintStream
			PrintStream ps = new PrintStream(s.getOutputStream());
			try {
				// 进行普通IO操作
				ps.println("您好，你收到了服务器传来的消息");
			}
			finally {
				ps.close();
				s.close();
			}
		}
	}
}
