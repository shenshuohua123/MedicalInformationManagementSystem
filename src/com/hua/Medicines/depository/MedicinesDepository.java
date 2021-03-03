package com.hua.Medicines.depository;

import java.util.HashMap;

import com.hua.People.MedicineAdministrator;
import com.hua.People.PeopleAbstractClass;

/**
 * ҩƷ�ֿ⣬ֻ��ҩƷ����Ա����Ȩ�޸Ĳ��� ��ҩƷ����Աֻ�ܲ鿴����
 * @author ��shuohua
 *
 */
public class MedicinesDepository {
	private boolean flag = false;// Ĭ��������޷�������ҩƷ
	private static long count = 0;// �ֿ�ҩƿ����
	private static HashMap<String, Integer> medicinesList = null;// ҩƷ�б�

	public MedicinesDepository(PeopleAbstractClass people) {
		// �������Ϊ���ݿ����Ա������Ի�ȡ����Ȩ��
		if (people instanceof MedicineAdministrator) {
			this.flag = true;
			//����ֿ�ҩƷ����Ϊ��
			if(this.medicinesList==null) {
				this.medicinesList=new HashMap<String, Integer>();
			}
		}
	}
	/**
	 * ����ҩƷ
	 * @param MedicinesName
	 * @param number
	 * @param people
	 * @return
	 */
	protected boolean subMedicineNumber(String MedicinesName, Integer number, PeopleAbstractClass people)throws Exception {
		if(people instanceof MedicineAdministrator) {
			//���ڴ�ҩƷ
			if(this.medicinesList.containsKey(MedicinesName)) {
				//����������
				if(this.medicinesList.get(MedicinesName)>=number) {
					this.medicinesList.put(MedicinesName, this.medicinesList.get(MedicinesName)-number);
					//ҩƷ����
					if(this.medicinesList.get(MedicinesName)==0) {
						this.medicinesList.remove(MedicinesName);
						this.count--;
						//�ֿ�ҩƷΪ��
						if(this.medicinesList.isEmpty()) {
							this.medicinesList=null;
						}
					}
					return true;
				}else {//����
					return false;
				}
			}else {//������
				return false;
			}	
		}else {
			return false;
		}
	}

	/**
	 * ����ҩƷ�����ҩƷ����
	 * @param MedicinesName
	 * @param number
	 * @param people
	 * @return
	 */
	protected boolean appendTypeOrCount(String MedicinesName, Integer number, PeopleAbstractClass people) {
		if (people instanceof MedicineAdministrator) {
			if (number > 0) {
				// �����Ƿ�ֿ���ڴ�ҩƷ
				// ���ڴ�ҩƷ
				if (this.medicinesList.containsKey(MedicinesName)) {
					this.medicinesList.put(MedicinesName, this.medicinesList.get(MedicinesName)+number);
				} else {// �����ڴ�ҩƷ
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
	 * ����ָ��ҩƷ����
	 * @param MedicineName
	 * @param people
	 * @return
	 */
	public Integer MedicinesNumber(String MedicineName, PeopleAbstractClass people)throws Exception {
		if (people instanceof MedicineAdministrator) {
			// ���ڴ�ҩƷ
			if (this.medicinesList.containsKey(MedicineName)) {
				if (this.medicinesList.get(MedicineName) >= 0 && this.medicinesList.get(MedicineName) < 10) {
					System.out.println("��ҩƷ��ʱ����ȱ�����⣬�뼰ʱ����");
				}
				return this.medicinesList.get(MedicineName);
			} else {// �����ڸ�ҩ
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
		// ����ҩƷ����Ա�ſ��޸�
		if (people instanceof MedicineAdministrator) {
			this.flag = flag;
		}else {
			System.out.println("�㲻��ҩƷ����Ա�޷�����");
		}
	}

	public static long getCount() {
		return count;
	}

	public static void setCount(long count, PeopleAbstractClass people) {
		// ����ҩƷ����Ա�ſ��޸�
		if (people instanceof MedicineAdministrator) {
			MedicinesDepository.count = count;
		}else {
			System.out.println("�㲻��ҩƷ����Ա�޷�����");
		}
	}

	public static HashMap<String, Integer> getMedicinesList() {
		return medicinesList;
	}

	public static void setMedicinesList(HashMap<String, Integer> medicinesList, PeopleAbstractClass people) {
		// ����ҩƷ����Ա�ſ��޸�
		if (people instanceof MedicineAdministrator) {
			MedicinesDepository.medicinesList = medicinesList;
		}else {
			System.out.println("�㲻��ҩƷ����Ա�޷�����");
		}
	}

}
