package com.hua.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hua.People.User;

/**操作数据库
 * 用户登录
 * @author 沈shuohua
 *
 */
public class UserDao {

	/**
	 * 登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user)throws Exception{
		User resultUser = null;
		String sql = "select * from t_user where userName=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		//设置第一个？为User里面的userName
		pstmt.setString(1, user.getUserName());
		//设置第二个？为User里面的password
		pstmt.setString(2, user.getPassword());
		//执行sql查询结果集
		ResultSet rs = pstmt.executeQuery();
		//查找结果集是否有下条记录,查找结果是否为空
		if(rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		//返回用户的所有实体信息
		return resultUser;
	}

}
