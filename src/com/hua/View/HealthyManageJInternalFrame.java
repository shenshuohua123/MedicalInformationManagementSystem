package com.hua.View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
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

import com.hua.Medicines.depository.MedicalLog;
import com.hua.People.People;
import com.hua.Util.DbUtil;
import com.hua.dao.PeopleDao;

/**
 * 医护人员对病历管理
 * 
 * @author 沈shuohua
 *
 */
public class HealthyManageJInternalFrame extends JInternalFrame {
	private JTextField queryIdTxt;
	private JTextField queryNameTxt;
	private JTable resultTable;
	private JTextField querySymptomTxt;
	private JTextField symptomTxt1;
	private PeopleDao peopleDao = new PeopleDao();
	private DbUtil dbUtil = new DbUtil();
	private JTextArea symptomArea;
	private JTextArea needMedicalArea;
	private JTextArea explainArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthyManageJInternalFrame frame = new HealthyManageJInternalFrame();
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
	public HealthyManageJInternalFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u75C5\u5386\u7BA1\u7406\r\n");
		setBounds(100, 100, 991, 572);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JScrollPane scrollPane_1 = new JScrollPane();

		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();

		JLabel lblNewLabel_2 = new JLabel("\u75C7\u72B6\uFF1A");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));

		symptomTxt1 = new JTextField();
		symptomTxt1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u75C7\u72B6\u63CF\u8FF0\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));

		symptomArea = new JTextArea();
		
		JButton btnNewButton_3 = new JButton("\u5EB7\u590D");
		btnNewButton_3.addActionListener(new ActionListener() {
			/**
			 * 	康复
			 */
			public void actionPerformed(ActionEvent e) {
				recoveryActionPerformed(e);
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnNewButton_4 = new JButton("\u786E\u8BCA");
		btnNewButton_4.addActionListener(new ActionListener() {
			/**
			 *	 患病
			 */
			public void actionPerformed(ActionEvent e) {
				addActionPerformed(e);
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(symptomTxt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(lblNewLabel_3)
					.addGap(11)
					.addComponent(symptomArea, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(149)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_4))
					.addGap(225))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(22)
							.addComponent(lblNewLabel_3))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(symptomArea, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(26)
							.addComponent(symptomTxt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(22)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(32)
							.addComponent(btnNewButton_3)
							.addGap(30)
							.addComponent(btnNewButton_4)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		resultTable = new JTable();
		resultTable.addMouseListener(new MouseAdapter() {
			/**
			 * 点击感应事件处理函数
			 */
			@Override
			public void mousePressed(MouseEvent e) {
				tableClickMousePressed(e);
			}
		});
		resultTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u7F16\u53F7", "\u59D3\u540D", "\u5E74\u9F84", "\u6027\u522B", "\u75C7\u72B6" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(resultTable);

		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));

		queryIdTxt = new JTextField();
		queryIdTxt.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));

		queryNameTxt = new JTextField();
		queryNameTxt.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 * 查询条件
			 */
			public void actionPerformed(ActionEvent e) {
				queryActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));

		JLabel lblNewLabel_4 = new JLabel("\u75C7\u72B6\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 20));

		querySymptomTxt = new JTextField();
		querySymptomTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			//重置事件
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(queryNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(queryIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(querySymptomTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(85)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(queryIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(queryNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(14)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(querySymptomTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnNewButton_1)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 904, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_5 = new JLabel("\u5F00\u836F\u65B9\uFF1A");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 20));
		
		needMedicalArea = new JTextArea();
		
		JLabel lblNewLabel_6 = new JLabel("\u836F\u91CF\u8BF4\u660E\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 20));
		
		explainArea = new JTextArea();
		
		JButton btnNewButton_2 = new JButton("\u5F00\u5355");
		btnNewButton_2.addActionListener(new ActionListener() {
			/**
			 * 	开单
			 */
			public void actionPerformed(ActionEvent e) {
				logActionPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(needMedicalArea, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(explainArea, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_2.createSequentialGroup()
								.addComponent(lblNewLabel_5)
								.addGap(52))
							.addGroup(gl_panel_2.createSequentialGroup()
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
									.addComponent(needMedicalArea, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addComponent(explainArea, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
								.addContainerGap()))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_6)
							.addGap(53))))
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addGap(46)
					.addComponent(btnNewButton_2)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		getContentPane().setLayout(groupLayout);
	}
	
	/**
	 * 	开单写入日志文件
	 * @param e
	 */
	private void logActionPerformed(ActionEvent e) {
		String id=this.queryIdTxt.getText();
		String name=this.queryNameTxt.getText();
		String symptom=this.querySymptomTxt.getText();
		String medical= this.needMedicalArea.getText();
		String desc=this.explainArea.getText();
		MedicalLog medicalLog=new MedicalLog(Integer.valueOf(id), name, symptom, medical, desc);
		FileOutputStream fos=null;
		ObjectOutputStream out=null;
		try {//序列化写入文件
			fos=new FileOutputStream("D:/Java日志文件/医药信息管理系统开药日志文件/test.txt");
			out=new ObjectOutputStream(fos);
			out.writeObject(medicalLog);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			try {
				out.close();
				fos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
//		try {反序列化
//			FileInputStream fis=new FileInputStream("");
//			ObjectInputStream in =new ObjectInputStream(fis);
//			MedicalLog medicalLogReade=null;
//			medicalLogReade=(MedicalLog)in.readObject();
//			in.close();
//			fis.close();
//		}catch(Exception e3) {
//			e3.printStackTrace();
//		}
		
	}

	/**
	 * 	患病事件处理函数
	 * @param e
	 */
	private void addActionPerformed(ActionEvent e) {
		int id=(int)Integer.valueOf(this.queryIdTxt.getText());
		String symptom=this.symptomTxt1.getText();
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			//不存在该病种类
			if(peopleDao.isNotExistsType(con, symptom)) {
				String desc=this.symptomArea.getText();
				//添加病种
				System.out.println("出错");
				peopleDao.add(con, symptom, desc);
			}
			if(peopleDao.isNotExists(con, id, symptom)) {
				//添加病历
				peopleDao.add(con, id, symptom);
			}else {
				JOptionPane.showMessageDialog(null, "该病人已经患该病了");
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
	 * 	康复函数事件处理
	 * @param e
	 */
	private void recoveryActionPerformed(ActionEvent e) {
		String id=String.valueOf(this.queryIdTxt.getText());
		String symptom=this.querySymptomTxt.getText(); 
		Connection con=null;
		try {
			con=dbUtil.getCon();
			//康复删除成功
			if(peopleDao.recovery(con,symptom,Integer.valueOf(id))>0) {
				JOptionPane.showMessageDialog(null, "恭喜您成功康复");
			}else {
				JOptionPane.showMessageDialog(null, "系统出错，请查明原因并手动删除");
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
	 * 点击感应事件函数
	 * @param e
	 */
	private void tableClickMousePressed(MouseEvent e) {
		int row=this.resultTable.getSelectedRow();
		this.symptomTxt1.setText((String)this.resultTable.getValueAt(row, 4));
		this.querySymptomTxt.setText((String)this.resultTable.getValueAt(row, 4));
		this.queryIdTxt.setText((String)this.resultTable.getValueAt(row, 0));
		this.queryNameTxt.setText((String)this.resultTable.getValueAt(row, 1));
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet resultSet=peopleDao.query_symptom(con, this.symptomTxt1.getText());
			while(resultSet.next()) {
				this.symptomArea.setText(resultSet.getString("desc"));
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
	 * 	查询事件处理
	 * @param e
	 */
	private void queryActionPerformed(ActionEvent e) {
		int id;
		if(this.queryIdTxt.getText().equals("")) {
			id=-1;
		}else {
			id=(int)Integer.valueOf(this.queryIdTxt.getText());
		}
		
		System.out.println("id");
		String name = this.queryNameTxt.getText();
		String symptom = this.querySymptomTxt.getText();
		People people = new People(id, name);
		fileQueryTable(people,symptom);
	}

	/**
	 * 	查询表单填充事件函数
	 */
	private void fileQueryTable(People people, String symptom) {
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet resultSet = peopleDao.query_medicalStaff(con, people, symptom);
			DefaultTableModel defaultTableModel=(DefaultTableModel)resultTable.getModel();
			defaultTableModel.setRowCount(0);
			while(resultSet.next()) {
				Vector v = new Vector();
				v.add(resultSet.getString("id"));
				v.add(resultSet.getString("name"));
				v.add(resultSet.getString("age"));
				v.add(resultSet.getString("sex"));
				v.add(resultSet.getString("symptom"));
				defaultTableModel.addRow(v);
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
	 * 	重置事件的处理
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		this.queryIdTxt.setText("");
		this.queryNameTxt.setText("");
		this.querySymptomTxt.setText("");
	}
	
}
