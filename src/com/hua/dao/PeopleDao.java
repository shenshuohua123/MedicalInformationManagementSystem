package com.hua.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.hua.People.People;
import com.hua.People.PeopleAbstractClass;
import com.hua.People.RecordHealthy;
import com.hua.Util.StringUtil;

public class PeopleDao {

	/**
	 * 获取病历号
	 */

	/**
	 * 判断是否有疾病
	 * 
	 * @throws Exception
	 */
	public boolean isHealthy(Connection con, int id) throws Exception {
		boolean flag = true;
		String sql = "select * from t_recordhealthy where identity=" + id;
		String sql2 = sql.replaceAll("t_recordhealthy", "t_people");
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet resultSet = pstmt.executeQuery();
		while (resultSet.next()) {
			if (resultSet.getString("symptomId") != "0") {
				flag = false;
			}
		}
		// 修改状态量
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(6, String.valueOf(flag));
		return flag;
	}

	/**
	 * 查看是否有该种类的病
	 * 
	 * @throws Exception
	 */
	public boolean isNotExistsType(Connection con, String symptom) throws Exception {
		boolean flag = true;
		String sql = "select * from t_symptom where symptom='" + symptom + "'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next()) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 添加病的种类
	 * 
	 * @throws Exception
	 */
	public int add(Connection con, String symptom, String desc) throws Exception {
		String sql = "insert into t_symptom values(null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, symptom);
		pstmt.setString(2, desc);
		return pstmt.executeUpdate();
	}

	/**
	 * 是否有该病
	 * 
	 * @throws Exception
	 */
	public boolean isNotExists(Connection con, int id, String symptom) throws Exception {
		boolean flag=true;
		String sql="select * from t_symptom where symptom='"+symptom+"'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet resultSet=pstmt.executeQuery(sql);
		int symptomId=-1;
		if(resultSet.next()) {
			symptomId=(int)Integer.valueOf(resultSet.getString(1));
		}
		if(symptomId!=-1) {
			String sql2 = "select * from t_recordhealthy where identityId=" + id + " and symptomId=" + symptomId;
			pstmt=con.prepareStatement(sql2);
			resultSet=pstmt.executeQuery(sql2);	
			if(resultSet.next()) {
				flag=false;
			}
		}
		
		return flag;
	}

	/**
	 * 添加病历操作
	 * 
	 * @throws Exception
	 */
	public int add(Connection con, int id, String symptom) throws Exception {
		String sql = "insert into t_recordhealthy values(null,?,?)";
		String sql2 = "select a.id from t_symptom a where symptom='" + symptom+"'";
		PreparedStatement pstmt = con.prepareStatement(sql2);
		ResultSet resultSet = pstmt.executeQuery();
		int symptomId ;
		if(resultSet.next()) {
			symptomId=(int) Integer.valueOf(resultSet.getString(1));
			pstmt=con.prepareStatement(sql);
			System.out.println("编号：");
			pstmt.setString(1, String.valueOf(id));
			pstmt.setString(2, String.valueOf(symptomId));
		}else {
			JOptionPane.showMessageDialog(null, "查不到");
			return -1;
		}
		
		return pstmt.executeUpdate();

	}

	/**
	 * 康复操作
	 * 
	 * @param con
	 * @param symptom
	 * @param id：用户id
	 * @return
	 * @throws Exception
	 */
	public int recovery(Connection con, String symptom, int id) throws Exception {
		String sql = "select * from t_symptom where symptom='" + symptom + "'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		int id2 = -1;
		System.out.println(sql);
		ResultSet resultSet = pstmt.executeQuery();
		while (resultSet.next()) {
			id2 = (int) Integer.valueOf(resultSet.getString(1));
			break;
		}
		if (id2 == -1) {
			JOptionPane.showMessageDialog(null, "档案不存在此病历，出错");
			return -1;
		}
		String sql2 = "delete from t_recordhealthy where identityId=" + id + " and symptomId=" + id2;
		pstmt = con.prepareStatement(sql2);
		return pstmt.executeUpdate();
	}

	/**
	 * 查询症状描述
	 * 
	 * @throws Exception
	 */
	public ResultSet query_symptom(Connection con, String symptom) throws Exception {
		String sql = "select a.desc from t_symptom a where symptom='" + symptom + "'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		System.out.println(sql);
		return pstmt.executeQuery();
	}

	/**
	 * 普通查询
	 * 
	 * @param con
	 * @param people
	 * @return
	 * @throws Exception
	 */
	public ResultSet query(Connection con, People people) throws Exception {
		StringBuffer sb = new StringBuffer("select * from t_people where");
		boolean flagId = false;
		boolean flagName = false;
		if (!(people.getId() == -1)) {
			sb.append(" id=" + people.getId());
			flagId = true;
		}
		if (StringUtil.isNotEmpty(people.getName())) {
			if (flagId == true) {
				sb.append(" and name like '%" + people.getName() + "%'");
			} else {
				sb.append(" name like '%" + people.getName() + "%'");
			}
		}
		System.out.println(sb.toString());
		PreparedStatement pstmt = con.prepareStatement(sb.toString());

		return pstmt.executeQuery();
	}

	/**
	 * 医护人员查询
	 * 
	 * @param con
	 * @param people
	 * @return
	 * @throws Exception
	 */
	public ResultSet query_medicalStaff(Connection con, People people, String symptom) throws Exception {
		StringBuffer sb = new StringBuffer("select a.id id,a.name name,a.age age,a.sex sex,c.symptom symptom "
				+ "from t_people a,t_recordhealthy b, t_symptom c where " + "a.id=b.identityId and b.symptomId=c.id");
		if (!(people.getId() == -1)) {
			sb.append(" and a.id=" + people.getId());
		}
		if (StringUtil.isNotEmpty(people.getName())) {
			sb.append(" and a.name like '%" + people.getName() + "%'");
		}
		if (!symptom.equals("null")) {
			sb.append(" and c.symptom like '%" + symptom + "%'");
		}
		System.out.println(sb.toString());
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

}
