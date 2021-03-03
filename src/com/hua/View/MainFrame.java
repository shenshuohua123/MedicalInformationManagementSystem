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
 * ������ر������Ⱦ����û���¼���ܽ���
 * @author ��shuohua
 *
 */
public class MainFrame extends JFrame {
	// ���屳��ͼ
	BufferedImage background;
	private JPanel contentPane;

	private JDesktopPane table = null;// ����������
	public static User userIdentity;// ��¼�û���Ϣ����

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//��¼���������ֱ�ӿ��ӻ�������
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
			 * 	ҩƷ-->ҩƷ��Ϣ��ѯ������Ҫ����¼�û���Ϣ
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
			 * ҩƷ�����¼�����
			 */
			public void actionPerformed(ActionEvent e) {
				//ҩƷ����
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
			 * ������ѯ�¼�������ѯ�Լ��ľ���
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
			 * ��������
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
			// ��ȫ�˳��¼�����
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ȫ�˳�");
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
			// �����û�������Ϣ�ڲ�����
			public void actionPerformed(ActionEvent e) {
				AboutUserInternalFrame aboutUserInternalFrame= new AboutUserInternalFrame();
				// �ڲ�����Ĭ���ǲ��ɼ�����������Ϊ�ɼ�
				aboutUserInternalFrame.setVisible(true);
				//���ݵ�¼�û���Ϣ
				AboutUserInternalFrame.user=MainFrame.userIdentity;
				// ������������Ӵ������
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
		// ���ý������
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//�滭����ͼ
		//background=getImg();
//		table.ima
		
	}
	//��ȡ����ͼ
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
