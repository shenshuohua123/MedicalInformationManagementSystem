package com.hua.Util;

public class StringUtil {
	/**
	 * 	判断是否为空
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
	 * 	判断是否不为空
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
