/**
 * ��������дJTree����������ϰ���Լ���Ȥ
 * ��չ:�����Ը���api�ṩ�Ľӿ��������������ȻҲ���Լ������ڵ㣬�ڴ˲���������ϰ
 */
package base;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeTest {
	JFrame jFrame = new JFrame("һ�ż򵥵���");
	JTree tree;
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode guangdong;
	DefaultMutableTreeNode guangxi;
	DefaultMutableTreeNode foshan;
	DefaultMutableTreeNode shantou;
	DefaultMutableTreeNode guilin;
	DefaultMutableTreeNode nanning;
	public void init() {
		// ���δ������е����нڵ�
		root = new DefaultMutableTreeNode("�й�");
		guangdong = new DefaultMutableTreeNode("�㶫");
		guangxi = new DefaultMutableTreeNode("����");
		foshan = new DefaultMutableTreeNode("��ɽ");
		shantou = new DefaultMutableTreeNode("��ͷ");
		guilin = new DefaultMutableTreeNode("����");
		nanning = new DefaultMutableTreeNode("����");
		// ͨ��add����������֮��ĸ��ӹ�ϵ
		guangdong.add(foshan);
		guangdong.add(shantou);
		guangxi.add(guilin);
		guangxi.add(nanning);
		root.add(guangdong);
		root.add(guangxi);
		// �Ը��ڵ㴴����
		tree = new JTree(root);
		jFrame.add(new JScrollPane(tree));
		jFrame.pack();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new JTreeTest().init();
	}

}
