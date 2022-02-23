package com.example.demo.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.example.demo.mapper.InspectMessageMapper;
import com.example.demo.model.InspectMessageBean;


@Configuration
@EnableScheduling
public class TaskSchedule {

	@Autowired
	InspectMessageMapper inspectMapper;

	private static Date lastSendTime = null;
	
	/**
	 * 
	 * <p>Title: anjianSendTask</p>  
	 * <p>Description: 安监及GPS监控员随机问题发送任务</p>
	 */
	
	@Scheduled(cron = "5 0 0/1 * * ?")
//	@Scheduled(cron = "0 0/2 * * * ?")
	@Async
	public void anjianSendTask() {
		
		ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(5);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH");
		SimpleDateFormat sdfs=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(lastSendTime != null){
			//判断是否再同一个小时
			Calendar now = Calendar.getInstance();
			Calendar last = Calendar.getInstance();
			if(now.get(Calendar.HOUR_OF_DAY) != last.get(Calendar.HOUR_OF_DAY)){
				Long delay = 0L;
				try {
					String day = sdf.format(new Date());
					String begin = day + ":00:00";
					String end = day + ":59:59";
					Date beginTime = sdfs.parse(begin);
					Date endTime = sdfs.parse(end);
				
					//获取所需的所有延迟时间（单位毫秒）
					delay = TimeUtil.getRandomSend( beginTime, endTime);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//创建线程池
				scheduled.schedule(new Runnable() {
		            @Override
		            public void run() {
		            	System.out.println("这个时间运行了一次任务:"+sdf.format(new Date()));
//		            	InspectMessageBean bean = new InspectMessageBean();
//		            	bean.setEvent_name("在岗巡查");
//		            	bean.setHandle_status("0");
//		            	inspectMapper.insertInspectMessage(bean);
		            	//websocket发送
		            	try {
//		            		WebSocket webSocket = new WebSocket();
		            		WebSocket.sendinspectInfo(null,"inspect",null);
						} catch (IOException e) {
							e.printStackTrace();
						}
		            	lastSendTime = new Date();
		            }
		        }, delay, TimeUnit.MILLISECONDS);
				//设置任务触发时间
				
			}
		}else{
			System.out.println("------------------------------begin---------------------------------------------");
			Long delay = 0L;
			try {
				String day = sdf.format(new Date());
				String begin = day + ":00:00";
				String end = day + ":59:59";
				Date beginTime = sdfs.parse(begin);
				Date endTime = sdfs.parse(end);
			
				//获取所需的所有延迟时间（单位毫秒）
				delay = TimeUtil.getRandomSend( beginTime, endTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//创建线程池
			scheduled.schedule(new Runnable() {
	            @Override
	            public void run() {
	            	System.out.println("这个时间运行了一次任务:"+sdf.format(new Date()));
	            	System.out.println("------------------------------task---------------------------------------------");
	            	//插入查岗数据
//	            	InspectMessageBean bean = new InspectMessageBean();
//	            	bean.setEvent_name("在岗巡查");
//	            	bean.setHandle_status("0");
//	            	inspectMapper.insertInspectMessage(bean);
	            	//websocket发送
	            	try {
	            		WebSocket.sendinspectInfo(null,"inspect",null);
					} catch (Exception e) {
						e.printStackTrace();
					}
	            	//设置任务触发时间
	    			lastSendTime = new Date();
	            }
	        }, delay, TimeUnit.MILLISECONDS);
			
		}
	}
}