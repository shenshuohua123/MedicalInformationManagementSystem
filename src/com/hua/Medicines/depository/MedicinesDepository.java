package com.hua.Medicines.depository;

import java.util.HashMap;

import com.hua.People.MedicineAdministrator;
import com.hua.People.PeopleAbstractClass;

/**
 * 药品仓库，只有药品管理员才有权修改操作 非药品管理员只能查看数据
 * @author 沈shuohua
 *
 */
public class MedicinesDepository {
	private boolean flag = false;// 默认情况下无法操作此药品
	private static long count = 0;// 仓库药瓶总量
	private static HashMap<String, Integer> medicinesList = null;// 药品列表

	public MedicinesDepository(PeopleAbstractClass people) {
		// 如果此人为数据库管理员，则可以获取操作权力
		if (people instanceof MedicineAdministrator) {
			this.flag = true;
			//如果仓库药品数量为空
			if(this.medicinesList==null) {
				this.medicinesList=new HashMap<String, Integer>();
			}
		}
	}
	/**
	 * 出售药品
	 * @param MedicinesName
	 * @param number
	 * @param people
	 * @return
	 */
	protected boolean subMedicineNumber(String MedicinesName, Integer number, PeopleAbstractClass people)throws Exception {
		if(people instanceof MedicineAdministrator) {
			//存在此药品
			if(this.medicinesList.containsKey(MedicinesName)) {
				//库存大于需求
				if(this.medicinesList.get(MedicinesName)>=number) {
					this.medicinesList.put(MedicinesName, this.medicinesList.get(MedicinesName)-number);
					//药品卖完
					if(this.medicinesList.get(MedicinesName)==0) {
						this.medicinesList.remove(MedicinesName);
						this.count--;
						//仓库药品为空
						if(this.medicinesList.isEmpty()) {
							this.medicinesList=null;
						}
					}
					return true;
				}else {//不够
					return false;
				}
			}else {//不存在
				return false;
			}	
		}else {
			return false;
		}
	}

	/**
	 * 增添药品种类或药品数量
	 * @param MedicinesName
	 * @param number
	 * @param people
	 * @return
	 */
	protected boolean appendTypeOrCount(String MedicinesName, Integer number, PeopleAbstractClass people) {
		if (people instanceof MedicineAdministrator) {
			if (number > 0) {
				// 查找是否仓库存在此药品
				// 存在此药品
				if (this.medicinesList.containsKey(MedicinesName)) {
					this.medicinesList.put(MedicinesName, this.medicinesList.get(MedicinesName)+number);
				} else {// 不存在此药品
					this.medicinesList.put(MedicinesName, number);
					this.count++;
				}
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}

	}

	/**
	 * 返回指定药品数量
	 * @param MedicineName
	 * @param people
	 * @return
	 */
	public Integer MedicinesNumber(String MedicineName, PeopleAbstractClass people)throws Exception {
		if (people instanceof MedicineAdministrator) {
			// 存在此药品
			if (this.medicinesList.containsKey(MedicineName)) {
				if (this.medicinesList.get(MedicineName) >= 0 && this.medicinesList.get(MedicineName) < 10) {
					System.out.println("该药品随时面临缺货问题，请及时补货");
				}
				return this.medicinesList.get(MedicineName);
			} else {// 不存在该药
				return -1;
			}
		} else {
			return -1;
		}
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag, PeopleAbstractClass people) {
		// 若是药品管理员才可修改
		if (people instanceof MedicineAdministrator) {
			this.flag = flag;
		}else {
			System.out.println("你不是药品管理员无法操作");
		}
	}

	public static long getCount() {
		return count;
	}

	public static void setCount(long count, PeopleAbstractClass people) {
		// 若是药品管理员才可修改
		if (people instanceof MedicineAdministrator) {
			MedicinesDepository.count = count;
		}else {
			System.out.println("你不是药品管理员无法操作");
		}
	}

	public static HashMap<String, Integer> getMedicinesList() {
		return medicinesList;
	}

	public static void setMedicinesList(HashMap<String, Integer> medicinesList, PeopleAbstractClass people) {
		// 若是药品管理员才可修改
		if (people instanceof MedicineAdministrator) {
			MedicinesDepository.medicinesList = medicinesList;
		}else {
			System.out.println("你不是药品管理员无法操作");
		}
	}

}
