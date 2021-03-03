package com.hua.Medicines.depository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import com.hua.Util.TimeUtil;

/**
 * ҩƷ��Ϣ��
 * 
 * @author ��shuohua
 *
 */
public class MedicinesInformation {
	private int id;// ҩƷ���
	private String name;// ҩ��
	private long storeNumber;// �����
	private double price;// �۸�
	private String producedDate;// ��������yyyy-MM-dd
	private int expirationData;// �����ڣ�������
	private String address;// ������ַ
	private String medicinesDesc;//ҩƷ����
	private String medicalType;//ҩƷ����

	/**
	 * 
	 * @param name
	 * @param medicinesDesc
	 * @param medicalType
	 */
	public MedicinesInformation(String name, String medicinesDesc, String medicalType) {
		super();
		this.name = name;
		this.medicinesDesc = medicinesDesc;
		this.medicalType = medicalType;
	}
	/**
	 * 
	 * @param id
	 * @param name
	 * @param storeNumber
	 * @param price
	 * @param producedDate
	 * @param expirationData
	 * @param address
	 * @param medicinesDesc
	 * @param medicalType
	 */
	public MedicinesInformation(int id, String name, long storeNumber, double price, String producedDate,
			int expirationData, String address, String medicinesDesc, String medicalType) {
		super();
		this.id = id;
		this.name = name;
		this.storeNumber = storeNumber;
		this.price = price;
		this.producedDate = producedDate;
		this.expirationData = expirationData;
		this.address = address;
		this.medicinesDesc = medicinesDesc;
		this.medicalType = medicalType;
	}

	/**
	 * 
	 * @param name
	 * @param medicinesDesc
	 */
	public MedicinesInformation(String name, String medicinesDesc) {
		this.name = name;
		this.medicinesDesc = medicinesDesc;
	}
	public String getMedicinesDesc() {
		return medicinesDesc;
	}

	public void setMedicinesDesc(String medicinesDesc) {
		this.medicinesDesc = medicinesDesc;
	}

	public String getMedicalType() {
		return medicalType;
	}

	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	}

	/**
	 * �ж�ҩƷ�Ƿ�����
	 * 
	 * @param expirationData
	 * @throws Exception
	 */
	public boolean isFresh(int expirationData) throws Exception {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// ����һ��formate
		Date date = simpleDateFormat.parse(/* this.producedDate */"1998-08-13");// ��formate��ת����Date��������
		System.out.println(date);
		// �������
		LocalDate startDate = LocalDate.of(2017, 1, 5);
		LocalDate endDate = LocalDate.of(2017, 11, 20);
		System.out.println(TimeUtil.until(startDate, endDate));
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(long storeNumber) {
		this.storeNumber = storeNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProducedDate() {
		return producedDate;
	}

	public void setProducedDate(String producedDate) {
		this.producedDate = producedDate;
	}

	public int getExpirationData() {
		return expirationData;
	}

	public void setExpirationData(int expirationData) {
		this.expirationData = expirationData;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
