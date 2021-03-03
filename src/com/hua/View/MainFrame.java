package com.hua.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hua.People.RecordHealthy;
import com.hua.People.User;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLayeredPane;
/**
 * 此类加载必须是先经过用户登录才能进来
 * @author 沈shuohua
 *
 */
public class MainFrame extends JFrame {
	// 定义背景图
	BufferedImage background;
	private JPanel contentPane;

	private JDesktopPane table = null;// 主界面桌面
	public static User userIdentity;// 登录用户信息传入

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//登录界面进来后直接可视化主界面
					MainFrame mainFrame =new MainFrame();				
					mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("\u533B\u7597\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 510);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u4FE1\u606F\u67E5\u8BE2\u53CA\u7BA1\u7406");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_2 = new JMenu("\u836F\u54C1");
		mnNewMenu.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u836F\u54C1\u4FE1\u606F\u67E5\u8BE2");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			/**
			 * 	药品-->药品信息查询，不需要传登录用户信息
			 */
			public void actionPerformed(ActionEvent e) {
				MedicalQueryInternalFrame medicalQueryInternalFrame = new MedicalQueryInternalFrame();
				medicalQueryInternalFrame.setVisible(true);
				table.add(medicalQueryInternalFrame);		
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u836F\u54C1\u5E93\u5B58\u7BA1\u7406");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			/**
			 * 药品管理事件处理
			 */
			public void actionPerformed(ActionEvent e) {
				//药品管理
				MedicalOperateInternalFrame medicalOperateInternalFrame= new MedicalOperateInternalFrame();
				table.add(medicalOperateInternalFrame);
				MedicalOperateInternalFrame.user=MainFrame.userIdentity; 
				medicalOperateInternalFrame.setVisible(true);  
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_3 = new JMenu("\u5065\u5EB7\u72B6\u51B5");
		mnNewMenu.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5065\u5EB7\u72B6\u51B5\u67E5\u8BE2");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			/**
			 * 健康查询事件处理，查询自己的就行
			 */
			public void actionPerformed(ActionEvent e) {
				QueryStatusJInternalFrame queryStatusJInternalFrame=new QueryStatusJInternalFrame();
				table.add(queryStatusJInternalFrame);
				queryStatusJInternalFrame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u5065\u5EB7\u4FE1\u606F\u7BA1\u7406");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			/**
			 * 病历管理
			 */
			public void actionPerformed(ActionEvent e) {
				HealthyManageJInternalFrame healthyManageJInternalFrame=new HealthyManageJInternalFrame();
				table.add(healthyManageJInternalFrame);
				healthyManageJInternalFrame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			// 安全退出事件处理
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否安全退出");
				if (result == 0) {
					dispose();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenu mnNewMenu_1 = new JMenu("\u5173\u4E8E\u7528\u6237");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u7528\u6237\u4E2A\u4EBA\u4FE1\u606F");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			// 关于用户个人信息内部窗体
			public void actionPerformed(ActionEvent e) {
				AboutUserInternalFrame aboutUserInternalFrame= new AboutUserInternalFrame();
				// 内部窗体默认是不可见，这里设置为可见
				aboutUserInternalFrame.setVisible(true);
				//传递登录用户信息
				AboutUserInternalFrame.user=MainFrame.userIdentity;
				// 在主界面上添加窗体组件
				table.add(aboutUserInternalFrame);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		table = new JDesktopPane();
		table.setBackground(Color.LIGHT_GRAY);
		
		contentPane.add(table, BorderLayout.CENTER);
		// 设置界面最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//绘画背景图
		//background=getImg();
//		table.ima
		
	}
	//获取背景图
//	public BufferedImage getImg() {
//		try {			
//			BufferedImage img = ImageIO.read(new File("d://"));
//			return img;
//		}catch(IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	
}
