package com.hua.View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.hua.Medicines.depository.MedicinesInformation;
import com.hua.Medicines.depository.MedicinesType;
import com.hua.People.User;
import com.hua.Util.DbUtil;
import com.hua.dao.MedicalDao;

/**
 * 	药品-->药品管理操作：管理员添加、删除、修改
 * @author 沈shuohua
 *
 */
public class MedicalOperateInternalFrame extends JInternalFrame {
	private JTextField queryMedicalNameTxt;
	private JTable medicalInformationTable;
	private JTextField idTxt;
	private JTextField medicalNameTxt;
	private JTextField storeNumberTxt;
	private JTextField priceTxt;
	private JTextField producedDateTxt;
	private JTextField expirationTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	public static User user;
	private MedicalDao medicalDao =new MedicalDao();
	private DbUtil dbUtil = new DbUtil();
	private JTextArea queryMedicalDescArea;
	private JRadioButton ChineseMedicalTypeRadioButton;
	private JRadioButton WesternMedicalTypeRadioButton;
	private JRadioButton ChineseRadioButton;
	private JRadioButton WesternRadioButton;
	private JTextArea producedAddressArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicalOperateInternalFrame frame = new MedicalOperateInternalFrame();
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
	public MedicalOperateInternalFrame() {
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 912, 607);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u6DFB\u52A0\u3001\u4FEE\u6539\u3001\u5220\u9664", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_2 = new JLabel("\u7F16    \u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u836F\u54C1\u540D\u79F0\uFF1A");
		
		medicalNameTxt = new JTextField();
		medicalNameTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u5E93 \u5B58 \u91CF\uFF1A");
		
		storeNumberTxt = new JTextField();
		storeNumberTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u4EF7    \u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u751F\u4EA7\u65E5\u671F\uFF1A");
		
		producedDateTxt = new JTextField();
		producedDateTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u4FDD \u8D28 \u671F\uFF1A");
		
		expirationTxt = new JTextField();
		expirationTxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u751F\u4EA7\u5730\u5740\uFF1A");
		
		producedAddressArea = new JTextArea();
		
		JLabel lblNewLabel_9 = new JLabel("\u836F\u54C1\u63CF\u8FF0\uFF1A");
		
		JTextArea meidcalDescArea = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			/**
			 * 	添加事件处理
			 */
			public void actionPerformed(ActionEvent e) {
				addActionPerformed(e);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539");
		btnNewButton_2.addActionListener(new ActionListener() {
			/**
			 * 修改事件处理
			 */
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e);
			}
		});
		
		JButton btnNewButton_3 = new JButton("\u5220\u9664");
		btnNewButton_3.addActionListener(new ActionListener() {
			/**
			 * 删除事件处理
			 */
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}
		});
		
		ChineseRadioButton = new JRadioButton("\u4E2D\u836F");
		buttonGroup_1.add(ChineseRadioButton);
		ChineseRadioButton.setSelected(true);
		
		WesternRadioButton = new JRadioButton("\u897F\u836F");
		buttonGroup_1.add(WesternRadioButton);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(18)
											.addComponent(lblNewLabel_2)
											.addGap(12)
											.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(19)
											.addComponent(lblNewLabel_3)
											.addGap(11)
											.addComponent(medicalNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(93)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(1)
											.addComponent(lblNewLabel_7)
											.addGap(9)
											.addComponent(expirationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNewLabel_6)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(producedDateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(94)
											.addComponent(lblNewLabel_9))))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(19)
											.addComponent(lblNewLabel_4)
											.addGap(10)
											.addComponent(storeNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(93)
											.addComponent(lblNewLabel_8))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(22)
											.addComponent(lblNewLabel_5)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(12)
									.addComponent(producedAddressArea, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
							.addGap(10)
							.addComponent(meidcalDescArea, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(WesternRadioButton)
								.addComponent(ChineseRadioButton)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(111)
							.addComponent(btnNewButton_1)
							.addGap(77)
							.addComponent(btnNewButton_2)
							.addGap(70)
							.addComponent(btnNewButton_3)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel_2))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(4)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_6)
										.addComponent(producedDateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(13)
											.addComponent(lblNewLabel_3))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(7)
											.addComponent(medicalNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(20)
											.addComponent(lblNewLabel_4))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(15)
											.addComponent(storeNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(21)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_5)
										.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(14)
									.addComponent(lblNewLabel_7)
									.addGap(26)
									.addComponent(lblNewLabel_8))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(11)
									.addComponent(expirationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(19)
									.addComponent(producedAddressArea, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(13)
							.addComponent(lblNewLabel_9))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(meidcalDescArea, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(14))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton_2)
							.addGap(17))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton_3)
							.addGap(13))))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(26)
					.addComponent(ChineseRadioButton)
					.addGap(18)
					.addComponent(WesternRadioButton)
					.addContainerGap(109, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		medicalInformationTable = new JTable();
		medicalInformationTable.addMouseListener(new MouseAdapter() {
			/**
			 * 鼠标点击事件
			 * @Override
			 */
			public void mousePressed(MouseEvent e) {
				medicalInformationTableMousePressed(e);
			}
		});
		medicalInformationTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u836F\u54C1\u540D\u79F0", "\u5E93\u5B58\u91CF", "\u4EF7\u683C", "\u751F\u4EA7\u65E5\u671F", "\u4FDD\u8D28\u671F", "\u751F\u4EA7\u5730\u5740", "\u836F\u54C1\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(medicalInformationTable);
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("\u836F\u54C1\u63CF\u8FF0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		queryMedicalNameTxt = new JTextField();
		queryMedicalNameTxt.setColumns(10);
		
		queryMedicalDescArea = new JTextArea();
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 * 	管理搜索事件处理
			 */
			public void actionPerformed(ActionEvent e) {
				queryActionPerfromed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 33));
		
		JLabel lblNewLabel_10 = new JLabel("\u836F\u54C1\u7C7B\u578B\uFF1A");
		lblNewLabel_10.setFont(new Font("宋体", Font.BOLD, 20));
		
		ChineseMedicalTypeRadioButton = new JRadioButton("\u4E2D\u836F");
		buttonGroup.add(ChineseMedicalTypeRadioButton);
		ChineseMedicalTypeRadioButton.setSelected(true);
		ChineseMedicalTypeRadioButton.setFont(new Font("宋体", Font.BOLD, 20));
		
		WesternMedicalTypeRadioButton = new JRadioButton("\u897F\u836F");
		buttonGroup.add(WesternMedicalTypeRadioButton);
		WesternMedicalTypeRadioButton.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(queryMedicalNameTxt, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(queryMedicalDescArea, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(101)
							.addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(41)
							.addComponent(lblNewLabel_10)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ChineseMedicalTypeRadioButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(WesternMedicalTypeRadioButton)))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(queryMedicalNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addContainerGap(95, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(queryMedicalDescArea, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_10)
								.addComponent(lblNewLabel_1)
								.addComponent(ChineseMedicalTypeRadioButton)
								.addComponent(WesternMedicalTypeRadioButton))
							.addContainerGap(33, Short.MAX_VALUE))))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);		
	}
	/**
	 * 	删除事件
	 * @param e
	 */
	private void deleteActionPerformed(ActionEvent e) {
		Connection con=null;
		String id=this.idTxt.getText();
		try {
			con=dbUtil.getCon();
			medicalDao.delete(con, id);
			JOptionPane.showMessageDialog(null, "删除成功");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "删除失败");
			e1.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
	}

	/**
	 *	 修改事件处理
	 * @param e
	 */
	private void updateActionPerformed(ActionEvent e) {
		Connection con=null;
		String id=this.idTxt.getText();
		String name=this.medicalNameTxt.getText();
		String number=this.storeNumberTxt.getText();
		String price=this.priceTxt.getText();
		String pDate=this.producedDateTxt.getText();
		String eDate=this.expirationTxt.getText();
		String address=this.producedAddressArea.getText();
		String desc=this.queryMedicalDescArea.getText();
		String type="中药";
		if(this.WesternRadioButton.isSelected()) {
			type="西药";
		}
		try {
			con=dbUtil.getCon();
			medicalDao.update(con, new MedicinesInformation(Integer.parseInt(id), name, Long.parseLong(number), Double.valueOf(price), pDate, Integer.parseInt(eDate), address, desc, type));
			JOptionPane.showMessageDialog(null, "修改成功");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "修改失败");
			e1.printStackTrace();	
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
	}

	/**
	 * 	添加事件处理
	 * @param e
	 */
	private void addActionPerformed(ActionEvent e) {
		Connection con=null;
		String id=this.idTxt.getText();
		String name=this.medicalNameTxt.getText();
		String number=this.storeNumberTxt.getText();
		String price=this.priceTxt.getText();
		String pDate=this.producedDateTxt.getText();
		String eDate=this.expirationTxt.getText();
		String address=this.producedAddressArea.getText();
		String desc=this.queryMedicalDescArea.getText();
		String type="中药";
		if(this.WesternRadioButton.isSelected()) {
			type="西药";
		}
		try {
			con=dbUtil.getCon();
			medicalDao.add(con, new MedicinesInformation(Integer.parseInt(id), name, Long.parseLong(number), Double.valueOf(price), pDate, Integer.parseInt(eDate), address, desc, type));
			JOptionPane.showMessageDialog(null, "添加成功");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "菜鸡，又出bug了。。。");
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
	 * 	搜索事件处理
	 * @param e
	 */
	private void queryActionPerfromed(ActionEvent e) {
		//获取输入值
				String medicalName=this.medicalNameTxt.getText();
				String medicalDesc=this.queryMedicalDescArea.getText();
				String medicalType;
				//如果学的是中药
				if(this.ChineseMedicalTypeRadioButton.isSelected()) {
					medicalType="中药";
				}else {
					medicalType="西药";
				}
				Connection con =null;
				try {
					MedicinesInformation medicinesInformation=new MedicinesInformation(medicalName, medicalDesc,medicalType);
					//调用填充
					fillTable(medicinesInformation);					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "菜鸡，又出bug了。。。");
					e1.printStackTrace();
				}finally {
					try {
						dbUtil.closeCon(con);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "菜鸡，又出bug了。。。");
						e1.printStackTrace();
					}
				}		
	}

	/**
	 * 表行点击事件
	 * @param e
	 */
	private void medicalInformationTableMousePressed(MouseEvent e) {
		int row = this.medicalInformationTable.getSelectedRow();
		this.idTxt.setText((String)medicalInformationTable.getValueAt(row, 0));
		this.medicalNameTxt.setText((String)medicalInformationTable.getValueAt(row, 1));
		this.storeNumberTxt.setText((String)medicalInformationTable.getValueAt(row, 2));
		this.priceTxt.setText((String)medicalInformationTable.getValueAt(row, 3)+"");
		this.producedDateTxt.setText((String)medicalInformationTable.getValueAt(row, 4));
		this.expirationTxt.setText((String)medicalInformationTable.getValueAt(row, 5));
		this.producedAddressArea.setText((String)medicalInformationTable.getValueAt(row, 6));
		this.queryMedicalDescArea.setText((String)medicalInformationTable.getValueAt(row, 7));
		String medicalType ;
		if(this.ChineseMedicalTypeRadioButton.isSelected()) {
			this.ChineseRadioButton.setSelected(true);
		}else {
			this.WesternRadioButton.setSelected(true);
		}
		
	}
	/**
	 * 	查询之后填充表单
	 */
	private void fillTable(MedicinesInformation medicinesInformation) {
		//获取表单模板
		DefaultTableModel defaultTableModel = (DefaultTableModel) medicalInformationTable.getModel();
		//每次查询前把表格清空，重新查询显示
		defaultTableModel.setRowCount(0);
		Connection con = null; 
		try {
			//获取连接
			con = dbUtil.getCon();
			//返回查询结果
			ResultSet resultSet = medicalDao.list(con, medicinesInformation);
			if(resultSet==null) {
				JOptionPane.showMessageDialog(null,"很抱歉，仓库没有此药品");
			}
			//是否有查询结果
			while(resultSet.next()) {
				Vector v = new Vector();
				v.add(resultSet.getString("id"));
				v.add(resultSet.getString("name"));
				v.add(resultSet.getString("storeNumber"));
				v.add(resultSet.getString("price"));
				v.add(resultSet.getString("producedDate"));
				v.add(resultSet.getString("expirationData"));
				v.add(resultSet.getString("address"));
				v.add(resultSet.getString("desc"));
				defaultTableModel.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
