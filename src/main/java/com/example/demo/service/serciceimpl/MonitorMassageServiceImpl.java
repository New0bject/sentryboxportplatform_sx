package com.example.demo.service.serciceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.MonitorMassageMapper;
import com.example.demo.model.MonitorMessageBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.service.MonitorMassageService;
import com.example.demo.util.AgeUtil;
import com.example.demo.util.Base64Utils;
import com.example.demo.util.WebSocket;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
/* loaded from: MonitorMassageServiceImpl.class */
public class MonitorMassageServiceImpl implements MonitorMassageService {
	@Autowired
	MonitorMassageMapper monitorMassageMapper;
	@Value("${filePath}")
	private String takeDeliveryPicPath;
	@Value("${filePathVisit}")
	private String takeDeliveryPicPathVisit;

	@Override // com.example.demo.service.MonitorMassageService
	public List<MonitorMessageBean> getMonitorMessage(MonitorMessageBean bean) {
		return this.monitorMassageMapper.getMonitorMessage(bean);
	}

	@Override // com.example.demo.service.MonitorMassageService
	public int getCount(MonitorMessageBean bean) {
		return this.monitorMassageMapper.getCount(bean);
	}

	@Override // com.example.demo.service.MonitorMassageService
	public MonitorMessageBean getMonitorById(MonitorMessageBean bean) {
		return this.monitorMassageMapper.getMonitorById(bean);
	}

	@Override // com.example.demo.service.MonitorMassageService
	@Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public ResultBeanRet insertMonitorMessage(String data) {
		ResultBeanRet result = new ResultBeanRet();
		String file_name = String.valueOf(System.currentTimeMillis()) + ".jpg";
		String img_url = this.takeDeliveryPicPathVisit + file_name;
		String save_url = this.takeDeliveryPicPath + file_name;
		new JSONObject();
		try {
			JSONObject jsonObject = JSON.parseObject(data);
			MonitorMessageBean monitorMessageBean = new MonitorMessageBean();
			Map<String, Object> groupMap = new HashMap<>();
			new HashMap();
			Map<String, Object> apparatusMap = this.monitorMassageMapper.getApparatusById(jsonObject.getString("serialNo"));
			if (apparatusMap.isEmpty()) {
				result.setCode(600);
				result.setMessage("设备信息没有注册到数据库表中");
				return result;
			}
			monitorMessageBean.setApparatus_id(String.valueOf(apparatusMap.get("id")));
			monitorMessageBean.setApparatus_name((String) apparatusMap.get("apparatus_name"));
			monitorMessageBean.setAddress((String) apparatusMap.get("address"));
			monitorMessageBean.setAttribution_dept((String) apparatusMap.get("competent_unit_id"));
			if ("1".equals(jsonObject.getJSONObject("eventArgs").getJSONObject("faceRecognizeInfo").getJSONObject("personInfo").getString("personType"))) {
				groupMap = this.monitorMassageMapper.getGroupByPerson(jsonObject.getJSONObject("eventArgs").getJSONObject("faceRecognizeInfo").getJSONObject("personInfo").getString("id"));
				if (groupMap.isEmpty()) {
					result.setCode(700);
					result.setMessage("人员信息没有注册到数据库表中");
					return result;
				}
				monitorMessageBean.setPerson_id((String) groupMap.get("user_id"));
				monitorMessageBean.setPerson_name(jsonObject.getJSONObject("eventArgs").getJSONObject("faceRecognizeInfo").getJSONObject("personInfo").getString("name"));
				monitorMessageBean.setGroup_id((String) groupMap.get("group_id"));
				monitorMessageBean.setGroup_name((String) groupMap.get("group_name"));
				if ("1".equals(jsonObject.getJSONObject("eventArgs").getJSONObject("faceRecognizeInfo").getJSONObject("personInfo").getString("sex"))) {
					monitorMessageBean.setSex("男");
				} else {
					monitorMessageBean.setSex("女");
				}
				try {
					monitorMessageBean.setAge(String.valueOf(AgeUtil.getAgeByBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.getJSONObject("eventArgs").getJSONObject("faceRecognizeInfo").getJSONObject("personInfo").getString("birthday")))));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				monitorMessageBean.setPerson_name("陌生人");
			}
			monitorMessageBean.setTemperature(jsonObject.getJSONObject("eventArgs").getJSONObject("faceInfo").getFloat("temperature"));
			boolean flag = Base64Utils.Base64ToImage(jsonObject.getJSONObject("eventArgs").getJSONObject("faceInfo").getString("faceImage").replace(" ", "+"), save_url);
			monitorMessageBean.setSave_img(img_url);
			if (flag) {
				if (this.monitorMassageMapper.insertMonitorMessage(monitorMessageBean) > 0) {
					try {
						Map<String, String> map = new HashMap<>();
						map.put("message", img_url);
						map.put("group_name", (String) groupMap.get("group_name"));
						map.put("person_name", monitorMessageBean.getPerson_name());
						WebSocket.sendInfo(map, null);
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				}
				result.setCode(200);
				result.setMessage("成功");
				return result;
			}
			result.setCode(800);
			result.setMessage("图片解析或上传失败");
			return result;
		} catch (Exception e3) {
			result.setCode(500);
			result.setMessage("参数错误");
			return result;
		}
	}
}