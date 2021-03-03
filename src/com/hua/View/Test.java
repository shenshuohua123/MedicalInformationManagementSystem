package com.hua.View;

import java.time.LocalDate;
import java.time.Month;

import com.hua.Medicines.depository.MedicinesInformation;
import com.hua.Util.TimeUtil;

public class Test {
	public static void main(String[] args) throws Exception {
		//≤‚ ‘ ±º‰
		LocalDate startDate = LocalDate.of(2017, 1, 5);
		LocalDate endDate = LocalDate.of(2017, 11, 20);

//		System.out.println(TimeUtil.until(startDate));
		System.out.println(TimeUtil.until(startDate,endDate));
		System.out.println("where name like '%"+"A"+"%"+" or desc %"+"B"
		+"%"+" or typeName='"+"C"+"'");
		
	}

}
