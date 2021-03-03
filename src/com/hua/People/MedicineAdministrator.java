package com.hua.People;

import java.util.HashMap;

/**
 * 药品管理员
 * 
 * @author 沈shuohua
 *
 */
public class MedicineAdministrator extends People {
	

	public MedicineAdministrator(int id, String name, int age, String sex, String occupation, String nationality,
			boolean healthy_Status, String people_Desc, int symptomId) {
		super(id, name, age, sex, occupation, nationality, healthy_Status, people_Desc, symptomId);
		// TODO Auto-generated constructor stub
	}

	public MedicineAdministrator(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	
}
