package projects.DownUtil.Presentation;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.layout.Border;

public class URLExceptionWarning {
	private Dialog warningDialog = null;
	private JFrame parentFrame = null;
	private JButton imageButton = null;
	private JButton okButton = null;
	private String text = "�������URL����ȷ,����������"; // ͬ������һ��Ĭ��ֵ
	private String tittle = "����"; // Ĭ��ֵ������������������ʾ��ĵط��ɸ���
	private JPanel panel = null;
	private JLabel textLabel = null;
	public URLExceptionWarning(JFrame frame) {
		this.parentFrame = frame;
		init();
	}
	public URLExceptionWarning(JFrame frame, String tittle) {
		this.parentFrame = frame;
		this.tittle = tittle;
		init();
	}
	public URLExceptionWarning(JFrame frame, String tittle, String text) {
		this.parentFrame = frame;
		this.tittle = tittle;
		this.text = text;
		init();
	}
	private void init() {
		warningDialog = new Dialog(parentFrame, tittle);
		warningDialog.addWindowListener(new WindowAdapter() // ע�ᴰ���¼�
		{
			public void windowClosing(WindowEvent var1) {
				warningDialog.setVisible(false);
			}
		});
		warningDialog.setBounds(180, 180, 200, 150); // TODO ���������
		warningDialog.setVisible(true);
		panel = new JPanel(new BorderLayout());
		imageButton = new JButton("��ʾ");
		textLabel = new JLabel(this.text);
		okButton = new JButton("ȷ��");
		Rectangle dialogBounds = warningDialog.getBounds();
		okButton.setBounds(dialogBounds.x + (dialogBounds.width) / 2, dialogBounds.y + (dialogBounds.height) , 5, 5);
		warningDialog.add(panel);
		panel.add(imageButton, BorderLayout.WEST);
		panel.add(textLabel, BorderLayout.EAST);
		panel.add(okButton, BorderLayout.SOUTH);
		
	}
}
