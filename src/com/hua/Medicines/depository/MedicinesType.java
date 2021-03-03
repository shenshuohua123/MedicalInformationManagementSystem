package com.hua.Medicines.depository;
/**
 * 药品种类：中药、西药
 * @author 沈shuohua
 *
 */
public class MedicinesType {
	private int id;//编号
	private String medicalType;//中药类别
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMedicalType() {
		return medicalType;
	}
	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	}
	public MedicinesType() {
		
	}
	@Override
	public String toString() {
		return this.medicalType;
	}
	

}
