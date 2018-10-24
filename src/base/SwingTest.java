/**
 * Swing编程基础知识练习
 */
package base;

import java.awt.Event;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class SwingTest {
    private JFrame jFrame = new JFrame("测试进度条");
    // 创建一条垂直进度条
    private JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL);
    private JCheckBox jcBox = new JCheckBox("不确定进度");
    private JCheckBox noBorder = new JCheckBox("不绘制边框");
    public void init() {
    	Box box = new Box(BoxLayout.Y_AXIS);
    	box.add(jcBox);
    	box.add(noBorder);
    	jFrame.setLayout(new FlowLayout());
    	jFrame.add(box);
    	// 设置进度条的最大值最小值
    	bar.setMinimum(0);
    	bar.setMaximum(100);
    	// 设置在进度条中绘制完成百分比
    	bar.setStringPainted(true);
    	noBorder.addActionListener(event -> {
    		bar.setBorderPainted(!noBorder.isSelected());
    		
    	});
    	jcBox.addActionListener(event -> {	
    		// 设置该进度条的进度是否确定
    		bar.setIndeterminate(jcBox.isSelected());
    		bar.setStringPainted(!jcBox.isSelected());
    	});
    	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jFrame.pack();
    	jFrame.setVisible(true);
    	for (int i = 0; i <= 100; i++) {
    		// 改变进度条的进度
    		bar.setValue(i);
    		try {
    			// 程序暂停0.1秒
    			Thread.sleep(100);
    			System.out.println(i);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingTest().init();

	}

}
