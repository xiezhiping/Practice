/**
 * AWT��ػ�����ϰ�����ࣺ���ڲ鿴һЩ�ײ�ʵ��
 */
package base;

import java.awt.Button;
import java.awt.Frame;

import javax.swing.text.Position.Bias;

public class AwtTest {

	public void init() {
		// ʹ�����λ�ã�ʹ��GUI�ܿ�ƽ̨
	Frame frame = new Frame("���Դ���");
	frame.setBounds(30,20,250,200);
	frame.setVisible(true);
	Button b1 = new Button("button1");
	Button b2 = new Button("button2");
	frame.setLayout(null); // ����ʹ��null���ֹ�����
	b1.setBounds(20, 30, 60, 30);
	frame.add(b1);
	
	b2.setBounds(50, 80, 40, 20);
	frame.add(b2);
	frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AwtTest().init();

	}

}
