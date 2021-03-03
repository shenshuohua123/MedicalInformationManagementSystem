package com.hua.Medicines.depository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import com.hua.Util.TimeUtil;

/**
 * 药品信息类
 * 
 * @author 沈shuohua
 *
 */
public class MedicinesInformation {
	private int id;// 药品编号
	private String name;// 药名
	private long storeNumber;// 库存量
	private double price;// 价格
	private String producedDate;// 生产日期yyyy-MM-dd
	private int expirationData;// 保质期（天数）
	private String address;// 生产地址
	private String medicinesDesc;//药品描述
	private String medicalType;//药品类型

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
	 * 判断药品是否新鲜
	 * 
	 * @param expirationData
	 * @throws Exception
	 */
	public boolean isFresh(int expirationData) throws Exception {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// 定义一个formate
		Date date = simpleDateFormat.parse(/* this.producedDate */"1998-08-13");// 将formate型转化成Date数据类型
		System.out.println(date);
		// 获得天数
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
