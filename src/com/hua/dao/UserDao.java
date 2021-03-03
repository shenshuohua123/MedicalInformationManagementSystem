package com.hua.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hua.People.User;

/**�������ݿ�
 * �û���¼
 * @author ��shuohua
 *
 */
public class UserDao {

	/**
	 * ��¼��֤
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user)throws Exception{
		User resultUser = null;
		String sql = "select * from t_user where userName=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		//���õ�һ����ΪUser�����userName
		pstmt.setString(1, user.getUserName());
		//���õڶ�����ΪUser�����password
		pstmt.setString(2, user.getPassword());
		//ִ��sql��ѯ�����
		ResultSet rs = pstmt.executeQuery();
		//���ҽ�����Ƿ���������¼,���ҽ���Ƿ�Ϊ��
		if(rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		//�����û�������ʵ����Ϣ
		return resultUser;
	}

}
