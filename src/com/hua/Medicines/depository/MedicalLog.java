package com.hua.Medicines.depository;

import java.io.Serializable;

/**
 * 	��ҩ��־��¼�ļ�
 * @author ��shuohua
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
		return "���ߣ�"+name+"	\r\n"
				+"id:"+id+"\r\n"
				+"֢״��"+symptom+"\r\n"
				+"ҩ����"+medical+"\r\n"
				+"����Ҫ��"+desc+"\r\n";
	}
	

}
