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
	private String text = "您输入的URL不正确,请重新输入"; // 同下设置一个默认值
	private String tittle = "下载"; // 默认值，该类在其他用作提示框的地方可复用
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
		warningDialog.addWindowListener(new WindowAdapter() // 注册窗体事件
		{
			public void windowClosing(WindowEvent var1) {
				warningDialog.setVisible(false);
			}
		});
		warningDialog.setBounds(180, 180, 200, 150); // TODO 界面待美化
		warningDialog.setVisible(true);
		panel = new JPanel(new BorderLayout());
		imageButton = new JButton("提示");
		textLabel = new JLabel(this.text);
		okButton = new JButton("确定");
		Rectangle dialogBounds = warningDialog.getBounds();
		okButton.setBounds(dialogBounds.x + (dialogBounds.width) / 2, dialogBounds.y + (dialogBounds.height) , 5, 5);
		warningDialog.add(panel);
		panel.add(imageButton, BorderLayout.WEST);
		panel.add(textLabel, BorderLayout.EAST);
		panel.add(okButton, BorderLayout.SOUTH);
		
	}
}
