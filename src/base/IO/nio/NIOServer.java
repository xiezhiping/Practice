package base.IO.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIOʵ�ֵ�Server�˴���
 * @author XZP
 *
 */
public class NIOServer {
	// selector
	private Selector selector;
	/**
	 * ��ȡһ��ServerSocketͨ��������ʼ��
	 * @port �˿ں�
	 */
	public void initServer(int port) throws IOException {
		// ���һ��ServerSocketͨ��  
        ServerSocketChannel serverChannel = ServerSocketChannel.open();  
        // ����ͨ��Ϊ������  
        serverChannel.configureBlocking(false);  
        // ����ͨ����Ӧ��ServerSocket�󶨵�port�˿�  
        serverChannel.socket().bind(new InetSocketAddress(port));  
        // ���һ��ͨ��������  
        this.selector = Selector.open();  
        //��ͨ���������͸�ͨ���󶨣���Ϊ��ͨ��ע��SelectionKey.OP_ACCEPT�¼�,ע����¼���  
        //�����¼�����ʱ��selector.select()�᷵�أ�������¼�û����selector.select()��һֱ������  
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);  
	}
	/** 
     * ������ѯ�ķ�ʽ����selector���Ƿ�����Ҫ������¼�������У�����д��� 
     * @throws IOException 
     */  
    @SuppressWarnings("unchecked")  
    public void listen() throws IOException {  
        System.out.println("����������ɹ���");  
        // ��ѯ����selector  
        while (true) {  
            //��ע����¼�����ʱ���������أ�����,�÷�����һֱ����  
            selector.select();  
            // ���selector��ѡ�е���ĵ�������ѡ�е���Ϊע����¼�  
            Iterator ite = this.selector.selectedKeys().iterator();  
            while (ite.hasNext()) {  
                SelectionKey key = (SelectionKey) ite.next();  
                // ɾ����ѡ��key,�Է��ظ�����  
                ite.remove();  
                // �ͻ������������¼�  
                if (key.isAcceptable()) {  
                    ServerSocketChannel server = (ServerSocketChannel) key  
                            .channel();  
                    // ��úͿͻ������ӵ�ͨ��  
                    SocketChannel channel = server.accept();  
                    // ���óɷ�����  
                    channel.configureBlocking(false);  
  
                    //��������Ը��ͻ��˷�����ϢŶ  
                    channel.write(ByteBuffer.wrap(new String("��ͻ��˷�����һ����Ϣ").getBytes()));  
                    //�ںͿͻ������ӳɹ�֮��Ϊ�˿��Խ��յ��ͻ��˵���Ϣ����Ҫ��ͨ�����ö���Ȩ�ޡ�  
                    channel.register(this.selector, SelectionKey.OP_READ);  
                      
                    // ����˿ɶ����¼�  
                } else if (key.isReadable()) {  
                        read(key);  
                }  
  
            }  
  
        }  
    } 
    /** 
     * �����ȡ�ͻ��˷�������Ϣ ���¼� 
     * @param key 
     * @throws IOException  
     */  
    public void read(SelectionKey key) throws IOException{  
        // �������ɶ�ȡ��Ϣ:�õ��¼�������Socketͨ��  
        SocketChannel channel = (SocketChannel) key.channel();  
        // ������ȡ�Ļ�����  
        ByteBuffer buffer = ByteBuffer.allocate(10);  
        channel.read(buffer);  
        byte[] data = buffer.array();  
        String msg = new String(data).trim();  
        System.out.println("������յ���Ϣ��"+msg);  
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());  
        channel.write(outBuffer);// ����Ϣ���͸��ͻ���  
    }  
    /** 
     * ��������˲��� 
     * @throws IOException  
     */  
    public static void main(String[] args) throws IOException {  
        NIOServer server = new NIOServer();  
        server.initServer(8000);  
        server.listen();  
    } 
}
