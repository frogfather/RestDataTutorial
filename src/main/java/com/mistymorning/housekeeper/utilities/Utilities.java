package com.mistymorning.housekeeper.utilities;

import java.sql.Date;
import java.util.Calendar;

public class Utilities {

	public static Date addOneDay(Date date, Integer days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, days);
		return new Date(cal.getTimeInMillis());
	}	
}
