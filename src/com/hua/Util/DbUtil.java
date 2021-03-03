package com.hua.Util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ⹤����
 * 
 * @author ��shuohua
 *
 */
public class DbUtil {
	//�������ݿ��ַ
	private String dbUril = "jdbc:mysql://localhost:3306/db_medical?useSSL=false&serverTimezone=UTC";
	private String dbUserName = "root";// �û���
	private String dbPassword = "root";// ����
	private String jdbcName = "com.mysql.cj.jdbc.Driver";// ��������
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception {
		//���������
		Class.forName(jdbcName);
		//�������
		Connection conn = DriverManager.getConnection(dbUril, dbUserName, dbPassword);
		return conn;
	}
	/**
	 * �ر����ݿ�����
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}
	public static void main(String[] args)  {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
	}
}
