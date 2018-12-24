package base;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Hang extends JFrame {
	public Hang() {
		JButton b1 = new JButton("Sleep");
		JButton b2 = new JButton("Hello");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Thread.currentThread().sleep(5000);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Hello World");
			}
		});
		getContentPane().setBounds(150, 150, 300, 200);
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(b1);
		getContentPane().add(b2);
		getContentPane().setBackground(getBackground());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Hang();
	}

}
