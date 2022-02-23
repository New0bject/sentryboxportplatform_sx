package com.example.demo.util;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;

public class GetuiUtil {

	// 首先定义一些常量, 修改成开发者平台获得的值
	private static String appId = "xnf7LrjzgL8kxeWVvsxEY6";
	private static String appKey = "EZal3nLIGN8hWC0mR7HgF2";
	private static String masterSecret = "KtsB8DvTqm5ZcGkMDLp7BA";
	private static String host = "http://sdk.open.api.igexin.com/apiex.htm";

	public static Boolean Push(String cid, Map<String, Object> map) {
		// String status = "发送成功";
		IGtPush push = new IGtPush(host, appKey, masterSecret);
		TransmissionTemplate template = new TransmissionTemplate();

		SingleMessage message = new SingleMessage();
		Boolean check = true;

		String str = "";
		try {
			str = new ObjectMapper().writeValueAsString(map);
			template.setAppId(appId);
			template.setAppkey(appKey);
			template.setTransmissionType(2);
			template.setTransmissionContent(str);
			message.setData(template);
		} catch (JsonGenerationException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		message.setOffline(true);
		// // 离线有效时间，单位为毫秒，可选
		message.setOfflineExpireTime(24 * 3600 * 1000);
		message.setPushNetWorkType(0); // 可选。判断是否客户端是否wifi环境下推送，1为在WIFI环境下，0为不限制网络环境。
		Target target = new Target();
		target.setAppId(appId);
		target.setClientId(cid);
		@SuppressWarnings("unused")
		IPushResult ret;
		try {
			// 推送信息
			ret = push.pushMessageToSingle(message, target);
		} catch (RequestException e) {

			check = false;
			e.printStackTrace();
			ret = push.pushMessageToSingle(message, target, e.getRequestId());
		}

		return check;
	}

}
