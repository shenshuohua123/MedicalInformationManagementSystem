package com.hua.Util;

public class StringUtil {
	/**
	 * 	�ж��Ƿ�Ϊ��
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 	�ж��Ƿ�Ϊ��
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if(str != null && !"".contentEquals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
}
