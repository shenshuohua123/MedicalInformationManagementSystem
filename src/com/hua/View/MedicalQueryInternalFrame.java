package com.hua.View;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.hua.Medicines.depository.MedicinesInformation;
import com.hua.Medicines.depository.MedicinesType;
import com.hua.Util.DbUtil;
import com.hua.dao.MedicalDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 药品-->药物查询
 * @author 沈shuohua
 *
 */
public class MedicalQueryInternalFrame extends JInternalFrame {
	
	private JTextArea medicalDescArea;
	private JTable medicalInformationTable;
	private JTextField medicalNameTxt;
	private DbUtil dbUtil=new DbUtil();
	private MedicalDao medicalDao = new MedicalDao();
	private JComboBox medicalTypeBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicalQueryInternalFrame frame = new MedicalQueryInternalFrame();
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
	public MedicalQueryInternalFrame() {
		
		
		setTitle("\u836F\u54C1\u67E5\u8BE2");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 980, 556);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE))
					.addGap(37))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(107, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		medicalNameTxt = new JTextField();
		medicalNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u836F\u54C1\u63CF\u8FF0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		medicalDescArea = new JTextArea();
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 * 	查询操作：所有登录成员都可表单操作
			 */
			public void actionPerformed(ActionEvent e) {
				//查询函数
				queryActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		
		medicalTypeBox = new JComboBox();
		
		JLabel lblNewLabel_2 = new JLabel("\u836F\u54C1\u7C7B\u578B\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			/**
			 * 	重置事件处理
			 */
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(medicalNameTxt, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(medicalDescArea, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(medicalTypeBox, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(82)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(37))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(medicalDescArea, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(medicalNameTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(12)
							.addComponent(btnNewButton_1))
						.addComponent(lblNewLabel_2)
						.addComponent(medicalTypeBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		medicalInformationTable = new JTable();
		scrollPane.setViewportView(medicalInformationTable);
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
		medicalInformationTable.getColumnModel().getColumn(0).setPreferredWidth(41);
		medicalInformationTable.getColumnModel().getColumn(1).setPreferredWidth(64);
		medicalInformationTable.getColumnModel().getColumn(2).setPreferredWidth(54);
		medicalInformationTable.getColumnModel().getColumn(3).setPreferredWidth(48);
		medicalInformationTable.getColumnModel().getColumn(4).setPreferredWidth(101);
		medicalInformationTable.getColumnModel().getColumn(5).setPreferredWidth(52);
		medicalInformationTable.getColumnModel().getColumn(6).setPreferredWidth(78);
		medicalInformationTable.getColumnModel().getColumn(7).setPreferredWidth(129);
		getContentPane().setLayout(groupLayout);
		
		
		//初始化下拉框
		fillMedicinesType();
		
	}
	/**
	 * 	查询事件处理
	 * @param e
	 */
	protected void queryActionPerformed(ActionEvent e) {
		//获取输入值
		String medicalName=this.medicalNameTxt.getText();
		String medicalDesc=this.medicalDescArea.getText();
		MedicinesType medicinesType=(MedicinesType)this.medicalTypeBox.getSelectedItem();
		String medicalType=medicinesType.getMedicalType();
		Connection con =null;
		try {
			if(medicalDesc==null && medicalName==null && medicalType=="请选择药品类型...") {
				JOptionPane.showMessageDialog(null, "请输入查询条件");
				return ;
			}
			MedicinesInformation medicinesInformation=new MedicinesInformation(medicalName, medicalDesc,medicalType);
			//调用填充
			fillTable(medicinesInformation);
		}catch(Exception e1) {
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
	 * 	重置事件处理函数
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
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
				JOptionPane.showMessageDialog(null,"查询失败");
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
	/**
	 * 初始化图书类别下拉框
	 */
	private void fillMedicinesType() {
		Connection con = null;
		MedicinesType medicinesType = new MedicinesType();
		try {
			con = dbUtil.getCon();
			ResultSet rs = medicalDao.list(con, new MedicinesType());
			medicinesType.setId(0);
			medicinesType.setMedicalType("请选择药品类型...");
			this.medicalTypeBox.addItem(medicinesType);
			while (rs.next()) {
				medicinesType= new MedicinesType();
				medicinesType.setId(rs.getInt("id"));
				medicinesType.setMedicalType(rs.getString("typeName"));
				this.medicalTypeBox.addItem(medicinesType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * 重置表单函数
	 */
	private void resetValue() {
		this.medicalNameTxt.setText("");
		this.medicalDescArea.setText("");
		if(this.medicalTypeBox.getItemCount()>0) {
			this.medicalTypeBox.setSelectedIndex(0);
		}
	}
}
