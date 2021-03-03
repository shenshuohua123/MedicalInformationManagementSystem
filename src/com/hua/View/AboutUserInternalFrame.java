package com.hua.View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import com.hua.People.User;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 	设置系统主界面的关于用户--》用户个人信息的内部窗体
 * @author 沈shuohua
 *
 */
public class AboutUserInternalFrame extends JInternalFrame {
	
	public static User user;//用于传入登录用户信息用户
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUserInternalFrame aboutUserInternalFrame=new AboutUserInternalFrame();
					aboutUserInternalFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AboutUserInternalFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u7528\u6237\u4E2A\u4EBA\u4FE1\u606F");
		setBounds(100, 100, 832, 496);
		//设置该组件窗体界面在主界面的左上角
		this.setLocation(0,0);
		
		JLabel lblNewLabel = new JLabel("\u4F60\u4F1A\u4F5C\u4F55\u9009\u62E9\uFF1F");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\\u6C88shuohua\\Desktop\\logo\\\u5E7F\u5DDE\u6052\u5927.jpg"));
		
		JButton btnNewButton = new JButton("\u5973\u670B\u53CB");
		btnNewButton.addActionListener(new ActionListener() {
			//选择一
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "呵！为了女友放弃你的信仰，不告诉你管理员的信息！");
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u6052\u5927");
		btnNewButton_1.addActionListener(new ActionListener() {
			//选择2
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "不告诉你管理员的信息！");
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u4E24\u8005");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "回答正确：小学生才做选择，管理员两者都要！—_—");
				JOptionPane.showMessageDialog(null, "管理员是："+user.getUserName());
				if(user.getUserName().equals("hua")) {
					JOptionPane.showMessageDialog(null, "此登录用户为管理员");
				}else {
					JOptionPane.showMessageDialog(null, "用户"+user.getUserName()+"是普通会员");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
					.addContainerGap(160, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(87)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(57)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
	}
}
