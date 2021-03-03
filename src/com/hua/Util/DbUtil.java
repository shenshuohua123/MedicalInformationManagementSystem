package com.hua.Util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 * 
 * @author 沈shuohua
 *
 */
public class DbUtil {
	//连接数据库地址
	private String dbUril = "jdbc:mysql://localhost:3306/db_medical?useSSL=false&serverTimezone=UTC";
	private String dbUserName = "root";// 用户名
	private String dbPassword = "root";// 密码
	private String jdbcName = "com.mysql.cj.jdbc.Driver";// 驱动名称
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception {
		//反射加载类
		Class.forName(jdbcName);
		//获得连接
		Connection conn = DriverManager.getConnection(dbUril, dbUserName, dbPassword);
		return conn;
	}
	/**
	 * 关闭数据库连接
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
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}
