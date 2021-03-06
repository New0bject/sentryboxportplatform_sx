package com.example.demo.util;

import java.util.Calendar;
import java.util.Date;

public class AgeUtil {
	public static int getAgeByBirthday(Date birthday) {
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthday)) {
		throw new IllegalArgumentException(
		"The birthDay is before Now.It's unbelievable!");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		if (monthNow <= monthBirth) {
		if (monthNow == monthBirth) {
		// monthNow==monthBirthÂ 
		if (dayOfMonthNow < dayOfMonthBirth) {
		age--;
		}
		} else {
		// monthNow>monthBirthÂ 
		age--;
		}
		}
		return age;
		}
}
