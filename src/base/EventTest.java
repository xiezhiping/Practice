/**
 * java���¼���ػ���֪ʶ����ϰ��
 * �ر�˵������������漰��Ƚ϶࣬���������漰���ṹ������ֻ����ĳЩ������ϵ�ĵ���֪ʶ��ϸ����ϰ
 */
package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


// �۲���ģʽ��򵥵�Ӧ��
public class EventTest {
	private Frame frame = new Frame("���Դ���");
	private Button ok = new Button("ȷ��");
	private TextField tField = new TextField(20);
	public void init() {
		// ע�������
		ok.addActionListener(new OkListener());
		frame.addWindowListener(new WinListener());
		frame.add(tField);
		frame.add(ok,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EventTest().init();
	}
    // ����������ڲ���
	class OkListener implements ActionListener {
		// �����¼���������������Ӧ�ض��¼�
		public void actionPerformed(ActionEvent e) {
			System.out.println("�㵥����ok��ť");
			tField.setText("Hello World");
		}
	}
	class WinListener implements WindowListener {
		public void windowClosed(WindowEvent e) {
		}

		@Override
		public void windowActivated(java.awt.event.WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(java.awt.event.WindowEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("���ڱ��رճɹ���");
			System.exit(0);
			
		}

		@Override
		public void windowDeactivated(java.awt.event.WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(java.awt.event.WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(java.awt.event.WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(java.awt.event.WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}

}
