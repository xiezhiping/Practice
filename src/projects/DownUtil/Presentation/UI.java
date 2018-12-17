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
	// 定义常量
	private static String FRAME_LOGO = "src\\projects\\DownUtil\\images\\zju.jpg"; // 顶层frame的logo
	private static String BROWSE_DIALOG_LOGO = "src\\projects\\DownUtil\\images\\browse.jpg";
	private JFrame frame = null; // 最外层的容器：分为两个子容器Panel
	private JPanel upPanel = null; // 上半部分的Panel
	private JPanel downPanel = null; // 下半部分的Panel：放【下载并打开】、【下载】、【取消】按钮
	
	private JPanel urlPanel = null;
	private JPanel filePanel = null;
	private JPanel locationPanel = null;
	
	private JLabel urlLabel = null; // 网址
	private JLabel fileLabel =null; // 文件名
	private JLabel locationLabel =null; // 下载存放地址
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
		init(); // 初始化UI
		bindEvents();
	}
	private void bindEvents() {
		cancelButton.addActionListener(new CancelListener());
		urlTextField.addFocusListener(new URLTextFieldListener());
		fileTextField.addFocusListener(new FileTextFieldListener());
		// 为【浏览】button绑定点击事件，不用内部类主要是为了解耦
		browseButton.addActionListener(new BrowseButtonListener());
		// 通过已有的适配器给frame注册窗口监听器
		frame.addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(WindowEvent e) {
		        System.exit(0);// 关闭退出系统
		    }
		});
	}
	/**
	 * UI的初始化方法
	 */
	private void init() {
		// 外部边框的初始化
		frame = new JFrame("下载工具");
		frame.setBounds(150, 150, 400, 200);
		frame.setLayout(new BorderLayout(30, 500));
		// 初始化次外围的panel容器
		upPanel = new JPanel();
		upPanel.setLayout(new BorderLayout());
		downPanel = new JPanel();
		// 初始化三个标签
		urlLabel = new JLabel("网址:");
		fileLabel = new JLabel("文件名：");
		locationLabel = new JLabel("下载到：");
		// 初始化三个文本编辑域
		urlTextField = new JTextField(20);
		fileTextField = new JTextField(20);
		locationBox = new JComboBox<>(ComboBoxItemPool.getItems());
		locationBox.setEditable(true);  //设置选择框为可编辑模式
		locationBox.addItemListener(new ComboBoxListener());
		// 初始化'浏览文件'按钮
		browseButton = new JButton("浏览");
		// 初始化最外围的panel容器
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
		// 为locationPanel设置边框，调整的美观一些
		this.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30), locationPanel);
		upPanel.add(urlPanel, BorderLayout.NORTH);
		upPanel.add(filePanel, BorderLayout.CENTER);
		upPanel.add(locationPanel, BorderLayout.SOUTH);
		// 初始化downPanel下面的三个button
		openButton = new JButton("下载并打开");
		downloadButton = new JButton("下载");
		downloadButton.addActionListener(new DownloadListener());
		cancelButton = new JButton("取消");
		// 将按钮添加到downPanel
		downPanel.add(openButton);
		downPanel.add(downloadButton);
		downPanel.add(cancelButton);
		
		// 为下载工具设定一个logo（暂用我浙的logo，侵删）
		frameIcon = this.getImage(FRAME_LOGO);
		frame.add(upPanel, BorderLayout.NORTH);
		frame.add(downPanel, BorderLayout.SOUTH);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setIconImage(frameIcon);
		progressMonitor = new ProgressMonitor(frame, "等待下载任务完成", "已完成：", 0, 100);
	}
	/**
	 * 通过图片URL获取Image对象
	 * @param url 图片RUL
	 * @return Image对象
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
	 * 为组件设置Border
	 * @param b 边框
	 * @param panel 组件
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
