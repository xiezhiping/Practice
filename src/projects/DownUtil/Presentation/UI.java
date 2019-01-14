package projects.DownUtil.Presentation;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ProgressMonitor;

import projects.DownUtil.Business.BrowseButtonListener;
import projects.DownUtil.Business.CancelListener;
import projects.DownUtil.Business.ComboBoxListener;
import projects.DownUtil.Business.DownloadListener;
import projects.DownUtil.Business.Main;
import projects.DownUtil.Business.FileTextFieldListener;
import projects.DownUtil.Business.URLTextFieldListener;
import projects.DownUtil.DataLayer.ComboBoxItemPool;

public class UI {
	// ���峣��
	private static String FRAME_LOGO = "src\\projects\\DownUtil\\images\\zju.jpg"; // ����frame��logo
	private static String BROWSE_DIALOG_LOGO = "src\\projects\\DownUtil\\images\\browse.jpg";
	private JFrame frame = null; // ��������������Ϊ����������Panel
	private JPanel upPanel = null; // �ϰ벿�ֵ�Panel
	private JPanel downPanel = null; // �°벿�ֵ�Panel���š����ز��򿪡��������ء�����ȡ������ť
	
	private JPanel urlPanel = null;
	private JPanel filePanel = null;
	private JPanel locationPanel = null;
	
	private JLabel urlLabel = null; // ��ַ
	private JLabel fileLabel =null; // �ļ���
	private JLabel locationLabel =null; // ���ش�ŵ�ַ
	private JTextField urlTextField = null;
	private JTextField fileTextField = null;
	private JComboBox locationBox = null;
	private JButton browseButton = null;
	
	private JButton openButton = null;
	private JButton downloadButton = null;
	private JButton cancelButton = null;
	private Image frameIcon = null;
	private FileDialog saveDialog = null;
	private ProgressMonitor progressMonitor = null;
	public UI() {
		init(); // ��ʼ��UI
		bindEvents();
	}
	private void bindEvents() {
		cancelButton.addActionListener(new CancelListener());
		urlTextField.addFocusListener(new URLTextFieldListener());
		fileTextField.addFocusListener(new FileTextFieldListener());
		// Ϊ�������button�󶨵���¼��������ڲ�����Ҫ��Ϊ�˽���
		browseButton.addActionListener(new BrowseButtonListener());
		// ͨ�����е���������frameע�ᴰ�ڼ�����
		frame.addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(WindowEvent e) {
		        System.exit(0);// �ر��˳�ϵͳ
		    }
		});
	}
	/**
	 * UI�ĳ�ʼ������
	 */
	private void init() {
		// �ⲿ�߿�ĳ�ʼ��
		frame = new JFrame("���ع���");
		frame.setBounds(150, 150, 400, 200);
		frame.setLayout(new BorderLayout(30, 500));
		// ��ʼ������Χ��panel����
		upPanel = new JPanel();
		upPanel.setLayout(new BorderLayout());
		downPanel = new JPanel();
		// ��ʼ��������ǩ
		urlLabel = new JLabel("��ַ:");
		fileLabel = new JLabel("�ļ�����");
		locationLabel = new JLabel("���ص���");
		// ��ʼ�������ı��༭��
		urlTextField = new JTextField(20);
		fileTextField = new JTextField(20);
		locationBox = new JComboBox<>(ComboBoxItemPool.getItems());
		locationBox.setEditable(true);  //����ѡ���Ϊ�ɱ༭ģʽ
		locationBox.addItemListener(new ComboBoxListener());
		// ��ʼ��'����ļ�'��ť
		browseButton = new JButton("���");
		// ��ʼ������Χ��panel����
		urlPanel = new JPanel();
		filePanel = new JPanel();
		locationPanel = new JPanel();
		locationPanel.setLayout(new BorderLayout());
		urlPanel.add(urlLabel);
		urlPanel.add(urlTextField);
		filePanel.add(fileLabel);
		filePanel.add(fileTextField);
		locationPanel.add(locationLabel, BorderLayout.WEST);
		locationPanel.add(locationBox);
		locationPanel.add(browseButton, BorderLayout.EAST);
		// ΪlocationPanel���ñ߿򣬵���������һЩ
		this.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30), locationPanel);
		upPanel.add(urlPanel, BorderLayout.NORTH);
		upPanel.add(filePanel, BorderLayout.CENTER);
		upPanel.add(locationPanel, BorderLayout.SOUTH);
		// ��ʼ��downPanel���������button
		openButton = new JButton("���ز���");
		downloadButton = new JButton("����");
		downloadButton.addActionListener(new DownloadListener());
		cancelButton = new JButton("ȡ��");
		// ����ť��ӵ�downPanel
		downPanel.add(openButton);
		downPanel.add(downloadButton);
		downPanel.add(cancelButton);
		
		// Ϊ���ع����趨һ��logo�����������logo����ɾ��
		frameIcon = this.getImage(FRAME_LOGO);
		frame.add(upPanel, BorderLayout.NORTH);
		frame.add(downPanel, BorderLayout.SOUTH);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setIconImage(frameIcon);
		progressMonitor = new ProgressMonitor(frame, "�ȴ������������", "����ɣ�", 0, 100);
	}
	/**
	 * ͨ��ͼƬURL��ȡImage����
	 * @param url ͼƬRUL
	 * @return Image����
	 */
	public static Image getImage(String url) {
		Image image = null;
		try {
			image = ImageIO.read(new File(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	/**
	 * Ϊ�������Border
	 * @param b �߿�
	 * @param panel ���
	 */
	private void setBorder(javax.swing.border.Border b, JPanel panel) {
		panel.setBorder(b);
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JTextField getUrlTextField() {
		return urlTextField;
	}
	public void setUrlTextField(JTextField urlTextField) {
		this.urlTextField = urlTextField;
	}
	public JTextField getFileTextField() {
		return fileTextField;
	}
	public void setFileTextField(JTextField fileTextField) {
		this.fileTextField = fileTextField;
	}
	public JComboBox getLocationBox() {
		return locationBox;
	}
	public void setLocationBox(JComboBox locationBox) {
		this.locationBox = locationBox;
	}
	public JButton getBrowseButton() {
		return browseButton;
	}
	public void setBrowseButton(JButton browseButton) {
		this.browseButton = browseButton;
	}
	public JButton getOpenButton() {
		return openButton;
	}
	public void setOpenButton(JButton openButton) {
		this.openButton = openButton;
	}
	public JButton getDownloadButton() {
		return downloadButton;
	}
	public void setDownloadButton(JButton downloadButton) {
		this.downloadButton = downloadButton;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}
	public FileDialog getSaveDialog() {
		return saveDialog;
	}
	public void setSaveDialog(FileDialog saveDialog) {
		this.saveDialog = saveDialog;
	}
	public static String getBROWSE_DIALOG_LOGO() {
		return BROWSE_DIALOG_LOGO;
	}
	public ProgressMonitor getProgressMonitor() {
		return progressMonitor;
	}
	public void setProgressMonitor(ProgressMonitor progressMonitor) {
		this.progressMonitor = progressMonitor;
	}
}
