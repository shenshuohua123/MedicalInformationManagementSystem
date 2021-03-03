package com.hua.View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.hua.People.User;
import com.hua.Util.DbUtil;
import com.hua.Util.StringUtil;
import com.hua.dao.UserDao;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LogOnFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;

	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();
	//进入主界面的实例对象
	private MainFrame mainFrame ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrame frame = new LogOnFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogOnFrame() {
		// 改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		setResizable(false);
		setTitle("\u533B\u7597\u7BA1\u7406\u7CFB\u7EDF\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u533B\u7597\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(LogOnFrame.class.getResource("/images/hospital.png")));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 33));

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));

		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));

		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);

		passwordTxt = new JPasswordField();

		JButton btnNewButton = new JButton("\u767B\u5F55");
		/**
		 * 	回车键进入
		 */
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
					if((char)e.getKeyChar()==KeyEvent.VK_ENTER) {
						System.out.println("hh");
						enterKeyPressed(e);
						
					}
			}
		});
		/**
		 * 用户登录事件处理
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));

		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		/**
		 * 登录界面重置事件
		 */
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(292, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_1)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
								.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)
							.addGap(46)))
					.addGap(260))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(314, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
					.addGap(217))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		//设置登录界面居中
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * 	回车键登录
	 * @param e
	 */
	private void enterKeyPressed(KeyEvent e) {
			String userName = this.userNameTxt.getText();
			String password = new String(this.passwordTxt.getPassword());
			if (StringUtil.isEmpty(userName)) {
				JOptionPane.showMessageDialog(null, "用户名不能为空");
				return;
			}
			if (StringUtil.isEmpty(password)) {
				JOptionPane.showMessageDialog(null, "密码不能为空");
				return;
			}
			// 数据库连接
			User user = new User(userName, password);
			Connection con = null;
			try {
				con = dbUtil.getCon();
				// 若找不到则返回空
				User currentUser = userDao.login(con, user);
				if (currentUser != null) {
					JOptionPane.showMessageDialog(null, "用户登录成功");
					dispose();//销毁当前窗体
					mainFrame=new MainFrame();
					mainFrame.setVisible(true);
					MainFrame.userIdentity=currentUser;
				} else {
					JOptionPane.showMessageDialog(null, "用户名或者密码错误");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
		
	}

	/**
	 * 用户登录事件处理函数
	 * 
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent e) {
		String userName = this.userNameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		// 数据库连接
		User user = new User(userName, password);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			// 若找不到则返回空
			User currentUser = userDao.login(con, user);
			if (currentUser != null) {
				JOptionPane.showMessageDialog(null, "用户登录成功");
				dispose();//销毁当前窗体
				//传递登录用户信息
//				mainFrame = new MainFrame();
//				//登录成功转入管理系统主界面
//				mainFrame.setVisible(true);
//				//运行用户主界面
//				mainFrame.Run(null);
				mainFrame=new MainFrame();
				mainFrame.setVisible(true);
				MainFrame.userIdentity=currentUser;
			} else {
				JOptionPane.showMessageDialog(null, "用户名或者密码错误");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	/**
	 * 重置事件处理函数
	 * 
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
