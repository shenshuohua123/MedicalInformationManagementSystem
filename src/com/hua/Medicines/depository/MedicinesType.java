package com.hua.Medicines.depository;
/**
 * ҩƷ���ࣺ��ҩ����ҩ
 * @author ��shuohua
 *
 */
public class MedicinesType {
	private int id;//���
	private String medicalType;//��ҩ���
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
