package com.hua.People;

import java.util.Date;
import java.util.HashMap;

/**
 * 人类抽象类
 * 
 * @author 沈shuohua
 *
 */
public abstract class PeopleAbstractClass implements People_Interface {
	private int id;
	private String name;
	private int age;
	private String sex;
	private String occupation;// 职业
	private String nationality = "China";// 国籍，默认为中国
	private boolean healthy_Status = true;// 默认为健康状态
	private String people_Desc;
	private int symptomId;
//	private int symptomId=0;//默认无症状
//	private HashMap<String, String> symptomlist = null;// 症状--》患病时间
	
	
	public PeopleAbstractClass(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public PeopleAbstractClass(int id, String name, int age, String sex, String occupation, String nationality,
		boolean healthy_Status, String people_Desc, int symptomId) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.sex = sex;
	this.occupation = occupation;
	this.nationality = nationality;
	this.healthy_Status = healthy_Status;
	this.people_Desc = people_Desc;
	this.symptomId = symptomId;
}
	/*
	 * 患病记录
	 */
//	protected void append_SymptomList(String symptom, Date data) {
//		this.symptomlist.put(symptom, data.toString());
//		if(this.healthy_Status==true) {
//			this.healthy_Status=false;
//		}
//		System.out.println("您好，很抱歉听到此消息，请配合医生进行治疗，祝您早日康复！");
//	}

	/*
	 * 病康复
	 */
//	protected void remove_append_SymptomList(String symptom) {
//		this.symptomlist.remove(symptom, this.symptomlist.get(symptom));
//		if(this.symptomlist.size()==0) {
//			this.healthy_Status=true;
//		}
//		System.out.println("恭喜您正式康复，今后请多注意身体，多喝水常运动");
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getHealthy_Status() {
		return healthy_Status;
	}

	public void setHealthy_Status(boolean healthy_Status) {
		this.healthy_Status = healthy_Status;
	}

	public String getPeople_Desc() {
		return people_Desc;
	}

	public void setPeople_Desc(String people_Desc) {
		this.people_Desc = people_Desc;
	}

	@Override
	public void say() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "我是" + this.name + "," + "目前是一名" + this.occupation;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}
