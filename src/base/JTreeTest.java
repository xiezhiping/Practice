/**
 * 该类用于写JTree创建树的练习，自己兴趣
 * 扩展:还可以根据api提供的接口做更多操作，当然也可以监听树节点，在此不作过多练习
 */
package base;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeTest {
	JFrame jFrame = new JFrame("一颗简单的树");
	JTree tree;
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode guangdong;
	DefaultMutableTreeNode guangxi;
	DefaultMutableTreeNode foshan;
	DefaultMutableTreeNode shantou;
	DefaultMutableTreeNode guilin;
	DefaultMutableTreeNode nanning;
	public void init() {
		// 依次创建树中的所有节点
		root = new DefaultMutableTreeNode("中国");
		guangdong = new DefaultMutableTreeNode("广东");
		guangxi = new DefaultMutableTreeNode("广西");
		foshan = new DefaultMutableTreeNode("佛山");
		shantou = new DefaultMutableTreeNode("汕头");
		guilin = new DefaultMutableTreeNode("桂林");
		nanning = new DefaultMutableTreeNode("南宁");
		// 通过add方法建立树之间的父子关系
		guangdong.add(foshan);
		guangdong.add(shantou);
		guangxi.add(guilin);
		guangxi.add(nanning);
		root.add(guangdong);
		root.add(guangxi);
		// 以根节点创建树
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
