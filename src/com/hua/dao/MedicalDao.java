package com.hua.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hua.Medicines.depository.MedicinesInformation;
import com.hua.Medicines.depository.MedicinesType;
import com.hua.Util.StringUtil;

/**
 * 系统主界面药品操作 表名：t_medicinesinformation
 * 
 * @author 沈shuohua
 *
 */
public class MedicalDao {

	public MedicalDao() {

	}
	/**
	 * 修改医药信息
	 */
	public int update(Connection con,MedicinesInformation medicinesInformation)throws Exception{
		String sql="update t_medicinesinformation where id="+medicinesInformation.getId();
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,String.valueOf(medicinesInformation.getId()));
		pstmt.setString(2,medicinesInformation.getName());
		pstmt.setString(3, String.valueOf(medicinesInformation.getStoreNumber()));
		pstmt.setString(4, String.valueOf(medicinesInformation.getPrice()));
		pstmt.setString(5, medicinesInformation.getProducedDate());
		pstmt.setString(6,String.valueOf(medicinesInformation.getExpirationData()));
		pstmt.setString(7, medicinesInformation.getAddress());
		pstmt.setString(8, medicinesInformation.getMedicinesDesc());
		pstmt.setString(9, medicinesInformation.getMedicalType());
		return pstmt.executeUpdate();
		
	}
	
	
	/**
	 * 删除药品信息
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		//预编译：安全
		String sql="delete from t_bookType where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}

	/**
	 * 	药品信息操作之药品添加
	 * 
	 * @throws Exception
	 */
	public int add(Connection con, MedicinesInformation medicinesInformation) throws Exception {
		String sql = "insert into t_medicinesinformation values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, medicinesInformation.getName());
		pstmt.setString(2, String.valueOf(medicinesInformation.getStoreNumber()));
		pstmt.setString(3, String.valueOf(medicinesInformation.getPrice()));
		pstmt.setString(4, medicinesInformation.getProducedDate());
		pstmt.setString(5, String.valueOf(medicinesInformation.getExpirationData()));
		pstmt.setString(6, medicinesInformation.getAddress());
		pstmt.setString(7, medicinesInformation.getMedicinesDesc());
		pstmt.setString(8,medicinesInformation.getMedicalType());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询药品信息
	 */
	public ResultSet list(Connection con,MedicinesInformation medicinesInformation)throws Exception {
		StringBuffer sb = new StringBuffer("select * from t_medicinesinformation where");
		int count=0;
		//查询药品名不为空、描述为空
		if(StringUtil.isNotEmpty(medicinesInformation.getName())) {
			sb.append(" name like '%"+medicinesInformation.getName()+"%'");
			count++;
		}
		if(StringUtil.isNotEmpty(medicinesInformation.getMedicinesDesc())) {
			if(count==0) {
				sb.append(" desc like '%"+medicinesInformation.getMedicinesDesc()+"%'");
				count++;
			}else {
				sb.append(" and desc like '%"+medicinesInformation.getMedicinesDesc()+"%'");
			}		
		}
		if(medicinesInformation.getMedicalType()!="请选择药品类型..."){
			if(count==0) {
				sb.append(" typeName='"+medicinesInformation.getMedicalType()+"'");
				count++;
			}else {
				sb.append(" and typeName='"+medicinesInformation.getMedicalType()+"'");
			}	
		}
		if(count==0) {
			return null;
		}
		System.out.println(sb.toString());
		PreparedStatement pstmt= con.prepareStatement(sb.toString());
		return pstmt.executeQuery();			
	}
	
	/**
	 * 查询药品类型信息
	 */
	public ResultSet list(Connection con,MedicinesType medicinesType)throws Exception{
		String sql =  new String("select * from t_medicineType"); 
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeQuery();		
	}	

}
