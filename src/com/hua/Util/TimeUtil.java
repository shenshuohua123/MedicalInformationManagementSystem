package com.hua.Util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * ����ʱ��Ĺ�������
 * 
 * @author ��shuohua
 *
 */
public interface TimeUtil {
	/**
	 * ���㵱ǰ������{@code endDate}�ļ������
	 *
	 * @param endDate
	 * @return �������
	 */
	static long until(LocalDate endDate) {
		return LocalDate.now().until(endDate, ChronoUnit.DAYS);
	}

	/**
	 * ��������{@code startDate}��{@code endDate}�ļ������
	 *
	 * @param startDate
	 * @param endDate
	 * @return �������
	 */
	static long until(LocalDate startDate, LocalDate endDate) {
		return startDate.until(endDate, ChronoUnit.DAYS);
	}
}
