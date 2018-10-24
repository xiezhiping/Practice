/**
 * Swing��̻���֪ʶ��ϰ
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
    private JFrame jFrame = new JFrame("���Խ�����");
    // ����һ����ֱ������
    private JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL);
    private JCheckBox jcBox = new JCheckBox("��ȷ������");
    private JCheckBox noBorder = new JCheckBox("�����Ʊ߿�");
    public void init() {
    	Box box = new Box(BoxLayout.Y_AXIS);
    	box.add(jcBox);
    	box.add(noBorder);
    	jFrame.setLayout(new FlowLayout());
    	jFrame.add(box);
    	// ���ý����������ֵ��Сֵ
    	bar.setMinimum(0);
    	bar.setMaximum(100);
    	// �����ڽ������л�����ɰٷֱ�
    	bar.setStringPainted(true);
    	noBorder.addActionListener(event -> {
    		bar.setBorderPainted(!noBorder.isSelected());
    		
    	});
    	jcBox.addActionListener(event -> {	
    		// ���øý������Ľ����Ƿ�ȷ��
    		bar.setIndeterminate(jcBox.isSelected());
    		bar.setStringPainted(!jcBox.isSelected());
    	});
    	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jFrame.pack();
    	jFrame.setVisible(true);
    	for (int i = 0; i <= 100; i++) {
    		// �ı�������Ľ���
    		bar.setValue(i);
    		try {
    			// ������ͣ0.1��
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
