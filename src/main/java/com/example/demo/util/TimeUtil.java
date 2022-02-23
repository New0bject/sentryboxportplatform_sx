package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeUtil {

	public static Long getRandomSend(Date beginTime,Date endTime){
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//获取开始时间和结束时间
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        long beginLong = begin.getTimeInMillis();
        long endLong = end.getTimeInMillis();
        
        //获取所需个数的延迟时间Long
		Long delay = 0L;
		long rtn = beginLong + (long) (Math.random() * (endLong - beginLong));
		System.out.println("触发时间为："+sdf.format(new Date(rtn)));
		if (rtn == beginLong || rtn == endLong) {
			delay = beginLong + (long) (Math.random() * (endLong - beginLong)) - beginLong;
		}else{
			delay = rtn-beginLong;
		}
		
		return delay;
	}
	
	
}
