/**
 * AWT相关基础练习测试类：用于查看一些底层实现
 */
package base;

import java.awt.Button;
import java.awt.Frame;

import javax.swing.text.Position.Bias;

public class AwtTest {

	public void init() {
		// 使用相对位置，使该GUI能跨平台
	Frame frame = new Frame("测试窗口");
	frame.setBounds(30,20,250,200);
	frame.setVisible(true);
	Button b1 = new Button("button1");
	Button b2 = new Button("button2");
	frame.setLayout(null); // 设置使用null布局管理器
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
