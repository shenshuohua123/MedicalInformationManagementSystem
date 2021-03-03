package com.hua.Medicines.depository;

import java.io.Serializable;

/**
 * 	开药日志记录文件
 * @author 沈shuohua
 *
 */
public class MedicalLog implements Serializable{
	int id;
	String name;
	String symptom;
	String medical;
	String desc;
	public MedicalLog(int id, String name, String symptom, String medical, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.symptom = symptom;
		this.medical = medical;
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "患者："+name+"	\r\n"
				+"id:"+id+"\r\n"
				+"症状："+symptom+"\r\n"
				+"药单："+medical+"\r\n"
				+"复用要求："+desc+"\r\n";
	}
	

}
