/**
 * java中事件相关基础知识的练习类
 * 特别说明：如果后期涉及类比较多，考虑重新涉及包结构，这里只用于某些不成体系的单个知识点细节练习
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


// 观察者模式最简单的应用
public class EventTest {
	private Frame frame = new Frame("测试窗口");
	private Button ok = new Button("确定");
	private TextField tField = new TextField(20);
	public void init() {
		// 注册监听器
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
    // 定义监听器内部类
	class OkListener implements ActionListener {
		// 定义事件处理器，用于响应特定事件
		public void actionPerformed(ActionEvent e) {
			System.out.println("你单击了ok按钮");
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
			System.out.println("窗口被关闭成功！");
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
