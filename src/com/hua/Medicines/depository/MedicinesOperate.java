package com.hua.Medicines.depository;

import java.util.HashMap;

import com.hua.People.MedicineAdministrator;
import com.hua.People.PeopleAbstractClass;

public class MedicinesOperate extends MedicinesInformation {
	private boolean flag = false;// 默认情况下无法操作此药品

	public MedicinesOperate(int id, String name, long storeNumber, double price, String producedDate,
			int expirationData, String address, String medicinesDesc, String medicalType) {
		super(id, name, storeNumber, price, producedDate, expirationData, address, medicinesDesc, medicalType);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
