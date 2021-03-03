package com.hua.View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.hua.People.OtherPeople;
import com.hua.People.People;
import com.hua.People.PeopleAbstractClass;
import com.hua.Util.DbUtil;
import com.hua.dao.PeopleDao;

public class QueryStatusJInternalFrame extends JInternalFrame {
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTable resultTable;
	private DbUtil dbUtil = new DbUtil();
	private PeopleDao peopleDao = new PeopleDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryStatusJInternalFrame frame = new QueryStatusJInternalFrame();
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
	public QueryStatusJInternalFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5065\u5EB7\u72B6\u51B5\u67E5\u8BE2");
		setBounds(100, 100, 835, 582);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING,
										groupLayout.createSequentialGroup().addContainerGap().addComponent(scrollPane,
												GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING,
										groupLayout.createSequentialGroup().addGap(4).addComponent(panel,
												GroupLayout.PREFERRED_SIZE, 816, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE).addGap(32)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(55, Short.MAX_VALUE)));

		resultTable = new JTable();
		resultTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u7F16\u53F7", "\u59D3\u540D", "\u5E74\u9F84", "\u6027\u522B", "\u804C\u4E1A",
						"\u56FD\u7C4D", "\u5065\u5EB7\u72B6\u51B5", "\u5BF9\u8C61\u63CF\u8FF0" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		resultTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		resultTable.getColumnModel().getColumn(1).setPreferredWidth(39);
		resultTable.getColumnModel().getColumn(2).setPreferredWidth(41);
		resultTable.getColumnModel().getColumn(3).setPreferredWidth(34);
		resultTable.getColumnModel().getColumn(4).setPreferredWidth(60);
		resultTable.getColumnModel().getColumn(5).setPreferredWidth(41);
		resultTable.getColumnModel().getColumn(6).setPreferredWidth(58);
		resultTable.getColumnModel().getColumn(7).setPreferredWidth(117);
		scrollPane.setViewportView(resultTable);

		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u5BF9\u8C61\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));

		idTxt = new JTextField();
		idTxt.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u5BF9\u8C61\u59D3\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));

		nameTxt = new JTextField();
		nameTxt.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 * 查询病历信息
			 */
			public void actionPerformed(ActionEvent e) {
				queryActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(41).addComponent(lblNewLabel)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(39).addComponent(lblNewLabel_1).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE).addGap(44)
				.addComponent(btnNewButton).addContainerGap(129, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(29).addGroup(gl_panel
						.createParallelGroup(Alignment.TRAILING, false).addComponent(nameTxt, Alignment.LEADING)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(idTxt, Alignment.LEADING)).addContainerGap(48, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 查询病历信息,查自己的
	 * 
	 * @param e
	 */
	private void queryActionPerformed(ActionEvent e) {
		int id;
		if(this.idTxt.getText().equals("")) {
			id=-1;
		}else {
			id=(int)Integer.valueOf(this.idTxt.getText());
		}
		String name = this.nameTxt.getText();
		Connection con = null;
		try {
			con = dbUtil.getCon();
			People people = new People(id, name);
			fillTable(people);
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * 填充表单
	 * @param people
	 */
	private void fillTable(People people) {
		
		DefaultTableModel defaultTableModel = (DefaultTableModel)resultTable.getModel();
		defaultTableModel.setRowCount(0);
		Connection con = null;
		try {
			con=dbUtil.getCon();
			ResultSet resultSet = peopleDao.query(con, people);		
			while (resultSet.next()) {
				Vector v= new Vector();
				v.add(resultSet.getString("id"));
				v.add(resultSet.getString("name"));
				v.add(resultSet.getString("age"));
				v.add(resultSet.getString("sex"));
				v.add(resultSet.getString("occupation"));
				v.add(resultSet.getString("nationality"));
				v.add(resultSet.getString("healthy_Status"));
				v.add(resultSet.getString("people_Desc"));
				defaultTableModel.addRow(v);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "菜鸡，填充表单时出现bug");
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "菜鸡，数据库连接关闭失败");
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
