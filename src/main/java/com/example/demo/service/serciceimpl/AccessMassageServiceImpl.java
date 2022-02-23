package com.example.demo.service.serciceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.AccessMassageMapper;
import com.example.demo.mapper.BaseMassageMapper;
import com.example.demo.mapper.SysGroupMapper;
import com.example.demo.mapper.SysRoleUserGroupMapper;
import com.example.demo.mapper.SysRoleUserMapper;
import com.example.demo.mapper.VisitorMassageMapper;
import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.AlarmBean;
import com.example.demo.model.ApplyMessageBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.model.RiskAlarmBean;
import com.example.demo.model.SysGroup;
import com.example.demo.model.SysRoleUser;
import com.example.demo.model.SysRoleUserGroup;
import com.example.demo.service.AccessMassageService;
import com.example.demo.util.Base64Utils;
import com.example.demo.util.HttpClient;
import com.example.demo.util.WebSocket;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

@Service
@Slf4j
/* loaded from: AccessMassageServiceImpl.class */
public class AccessMassageServiceImpl implements AccessMassageService {
	@Autowired
	AccessMassageMapper accessMassageMapper;
	@Autowired
	SysRoleUserMapper sysRoleUserMapper;
	@Autowired
	SysGroupMapper sysGroupMapper;
	@Autowired
	SysRoleUserGroupMapper sysRoleUserGroupMapper;
	@Autowired
	VisitorMassageMapper visitorMassageMapper;
	@Autowired
	BaseMassageMapper baseMassageMapper;
	@Value("${filePath}")
	private String takeDeliveryPicPath;
	@Value("${filePathVisit}")
	private String takeDeliveryPicPathVisit;

	@Override // com.example.demo.service.AccessMassageService
	public List<AccessMessageBean> getAccessMessage(AccessMessageBean bean) {
		log.info("===============getAccessMessage================================bean="+bean);
		bean.setAttribution_dept_list(getGroupIds(bean.getPerson_id()));
		return this.accessMassageMapper.getAccessMessage(bean);
	}

	@Override
	public List<AccessMessageBean> getAccessMessageSx(AccessMessageBean bean) {
		Example example = new Example(SysGroup.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("parentId",bean.getAttribution_dept());
		ArrayList list =  new ArrayList<Object>();
		list.add("6");
		list.add("11");
		criteria.andIn("grade",list);
		List<SysGroup> sysGroups = sysGroupMapper.selectByExample(example);
		sysGroups.add(sysGroupMapper.selectByPrimaryKey(bean.getAttribution_dept()));
		List<String> attribution_dept_list = new ArrayList<String>();
		for (SysGroup sysGroup : sysGroups) {
			attribution_dept_list.add(sysGroup.getId());
		}
		attribution_dept_list.add(bean.getAttribution_dept());
		bean.setAttribution_dept_list(attribution_dept_list);
		log.info("==================getAccessMessageSx========================="+bean);
		return accessMassageMapper.getAccessMessage(bean);
	}

	@Override // com.example.demo.service.AccessMassageService
	public List<String> getGroupIds(String userId) {
		Example example = new Example(SysRoleUser.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userId", userId);
		criteria.andEqualTo("roleId", 4000);
		SysRoleUser sysRoleUsers =  this.sysRoleUserMapper.selectOneByExample(example);
		if (Objects.isNull(sysRoleUsers)) {
			return null;
		}
		log.info("===============getAccessMessage================================sysRoleUsers="+sysRoleUsers);
		Example groupIds = new Example(SysRoleUserGroup.class);
		groupIds.createCriteria().andEqualTo("roleUserId", sysRoleUsers.getId());
		List<SysRoleUserGroup> sysRoleUserGroups = this.sysRoleUserGroupMapper.selectByExample(groupIds);
		if (CollectionUtils.isEmpty(sysRoleUserGroups)) {
			return null;
		}
		List<String> ids =  sysRoleUserGroups.stream().map(SysRoleUserGroup::getGroupId).collect(Collectors.toList());
		if (CollectionUtils.isEmpty(ids)) {
			return null;
		}
		log.info("===============getAccessMessage================================ids="+ids);
		return ids;
	}

	@Override // com.example.demo.service.AccessMassageService
	public int getCount(AccessMessageBean bean) {

		bean.setAttribution_dept_list(getGroupIds(bean.getPerson_id()));
		return this.accessMassageMapper.getCount(bean);
	}

	@Override
	public int getCountSx(AccessMessageBean bean) {
		Example example = new Example(SysGroup.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("parentId",bean.getAttribution_dept());
		ArrayList list =  new ArrayList<Object>();
		list.add("6");
		list.add("11");
		criteria.andIn("grade",list);
		List<SysGroup> sysGroups = sysGroupMapper.selectByExample(example);
		sysGroups.add(sysGroupMapper.selectByPrimaryKey(bean.getAttribution_dept()));
		List<String> attribution_dept_list = new ArrayList<String>();
		for (SysGroup sysGroup : sysGroups) {
			attribution_dept_list.add(sysGroup.getId());
		}
		attribution_dept_list.add(bean.getAttribution_dept());
		bean.setAttribution_dept_list(attribution_dept_list);
		log.info("==================getCountSx========================="+bean);
		return this.accessMassageMapper.getCount(bean);
	}

	@Override // com.example.demo.service.AccessMassageService
	public AccessMessageBean getAccessById(AccessMessageBean bean) {
		return this.accessMassageMapper.getAccessById(bean);
	}

	@Override // com.example.demo.service.AccessMassageService
	@Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public ResultBeanRet handleMessage(AccessMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		AccessMessageBean accessMessageBean = new AccessMessageBean();
		accessMessageBean.setPerson_id(bean.getPerson_id());
		if (bean.getHandle_result().contains("进入")) {
			bean.setAccess_type("1");
		}
		if (bean.getHandle_result().contains("外出")) {
			bean.setAccess_type("2");
		}
		ApplyMessageBean applyMessageBean = this.accessMassageMapper.getApplyNum(accessMessageBean);
		if (applyMessageBean != null) {
			bean.setHandle_result(bean.getHandle_result().replace("请假", applyMessageBean.getVacate_name()));
		}
		if (this.accessMassageMapper.handleMessage(bean) >= 1) {
			AccessMessageBean resultBean = this.accessMassageMapper.getAccessById(bean);
			Map<String, Object> requestMap = new HashMap<>();
			if (bean.getHandle_result().indexOf("进入") != -1) {
				requestMap.put("userId", resultBean.getPerson_id());
				try {
					System.out.println(HttpClient.post("http://shcloud.wmtechzone.club:12007/songjiangcheck/goHomeEndLocus", HttpClient.prepareParam(requestMap), 30000, 30000, "UTF-8"));
					System.out.println("-------------------------inininininininin-------------------------------------------");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (bean.getHandle_result().indexOf("外出") != -1) {
				try {
					requestMap.put("userId", resultBean.getPerson_id());
					try {
						System.out.println(HttpClient.post("http://shcloud.wmtechzone.club:12007/songjiangcheck/outDoorLocusNotice", HttpClient.prepareParam(requestMap), 30000, 30000, "UTF-8"));
						System.out.println("-------------------------outoutoutoutoutoutoutoutout-------------------------------------------");
						this.accessMassageMapper.updateApplyStatus(applyMessageBean)
						;
						Object user_id = this.accessMassageMapper.getDutyDynamics(accessMessageBean.getPerson_id());
						Map<String, Object> map = new HashMap<>();
						map.put("new_user_id", user_id);
						map.put("old_user_id", accessMessageBean.getPerson_id());
						this.accessMassageMapper.updateDutyDynamics(map);
					} catch (Exception e2) {
						e2.printStackTrace();
						this.accessMassageMapper.updateApplyStatus(applyMessageBean);
						Object user_id2 = this.accessMassageMapper.getDutyDynamics(accessMessageBean.getPerson_id());
						Map<String, Object> map2 = new HashMap<>();
						map2.put("new_user_id", user_id2);
						map2.put("old_user_id", accessMessageBean.getPerson_id());
						this.accessMassageMapper.updateDutyDynamics(map2);
					}
				} catch (Throwable th) {
					this.accessMassageMapper.updateApplyStatus(applyMessageBean);
					Object user_id3 = this.accessMassageMapper.getDutyDynamics(accessMessageBean.getPerson_id());
					Map<String, Object> map3 = new HashMap<>();
					map3.put("new_user_id", user_id3);
					map3.put("old_user_id", accessMessageBean.getPerson_id());
					this.accessMassageMapper.updateDutyDynamics(map3);
					throw th;
				}
			}
			result.setCode(200);
			result.setMessage("处置成功");
		} else {
			result.setCode(500);
			result.setMessage("处置失败");
		}
		return result;
	}

	@Override // com.example.demo.service.AccessMassageService
	public ResultBeanRet getAccessByPerson(AccessMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> personMessage = this.accessMassageMapper.getPersonMessage(bean);
		List<Map<String, Object>> accessLog = this.accessMassageMapper.getAccessLog(bean);
		resultMap.put("personMessage", personMessage);
		resultMap.put("accessLog", accessLog);
		if (personMessage != null && accessLog != null) {
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(resultMap);
		} else if (personMessage == null && accessLog != null) {
			result.setCode(200);
			result.setMessage("人员信息不存在");
		} else if (personMessage == null || accessLog != null) {
			result.setCode(500);
			result.setMessage("查询记录为0");
		} else {
			result.setCode(200);
			result.setMessage("暂无出入记录");
		}
		return result;
	}

	@Override // com.example.demo.service.AccessMassageService
	public ResultBeanRet getAccessByApparatus(AccessMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		List<AccessMessageBean> accessLog = this.accessMassageMapper.getAccessByApparatus(bean);
		if (accessLog == null || accessLog.size() <= 0) {
			result.setCode(900);
			result.setMessage("查询记录为0");
		} else {
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(accessLog);
		}
		return result;
	}

	@Override // com.example.demo.service.AccessMassageService
	@Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public ResultBeanRet insertAccessMessage(String data) {
		ResultBeanRet result = new ResultBeanRet();
		String file_name = String.valueOf(System.currentTimeMillis()) + ".jpg";
		String img_url = this.takeDeliveryPicPathVisit + file_name;
		String save_url = this.takeDeliveryPicPath + file_name;
		try {
			JSONObject jsonObject = JSON.parseObject(data);
			new HashMap();
			Map<String, Object> groupMap = this.accessMassageMapper.getGroupByPerson(jsonObject.getJSONObject("eventArgs").getJSONObject("faceRecognizeInfo").getJSONObject("personInfo").getString("id"));
			if (groupMap.isEmpty()) {
				result.setCode(700);
				result.setMessage("人员信息没有注册到数据库表中");
				return result;
			}
			new HashMap();
			Map<String, Object> apparatusMap = this.accessMassageMapper.getApparatusById(jsonObject.getString("serialNo"));
			if (apparatusMap.isEmpty()) {
				result.setCode(600);
				result.setMessage("设备信息没有注册到数据库表中");
				return result;
			}
			AccessMessageBean accessMessageBean = new AccessMessageBean();
			accessMessageBean.setApparatus_id(String.valueOf(apparatusMap.get("id")));
			accessMessageBean.setApparatus_name((String) apparatusMap.get("apparatus_name"));
			accessMessageBean.setAddress((String) apparatusMap.get("address"));
			accessMessageBean.setAttribution_dept((String) apparatusMap.get("competent_unit_id"));
			accessMessageBean.setEvent_type("1");
			accessMessageBean.setPerson_id((String) groupMap.get("user_id"));
			accessMessageBean.setPerson_name(jsonObject.getJSONObject("eventArgs").getJSONObject("faceRecognizeInfo").getJSONObject("personInfo").getString("name"));
			accessMessageBean.setGroup_id((String) groupMap.get("group_id"));
			accessMessageBean.setGroup_name((String) groupMap.get("group_name"));
			accessMessageBean.setCar_no("");
			accessMessageBean.setTemperature(jsonObject.getJSONObject("eventArgs").getJSONObject("faceInfo").getFloat("temperature").floatValue());
			accessMessageBean.setHandle_status("1");
			boolean flag = Base64Utils.Base64ToImage(jsonObject.getJSONObject("eventArgs").getJSONObject("faceInfo").getString("faceImage").replace(" ", "+"), save_url);
			accessMessageBean.setSave_img(img_url);
			ApplyMessageBean applyMessageBean = this.accessMassageMapper.getApplyNum(accessMessageBean);
			if (applyMessageBean != null) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if (((String) apparatusMap.get("apparatus_name")).indexOf("进") != -1) {
					accessMessageBean.setHandle_result(applyMessageBean.getVacate_name() + "正常进入");
					accessMessageBean.setHandle_status("2");
					accessMessageBean.setHandle_time(df.format(new Date()));
					accessMessageBean.setAccess_type("1");
				} else if (((String) apparatusMap.get("apparatus_name")).indexOf("出") != -1) {
					accessMessageBean.setHandle_result(applyMessageBean.getVacate_name() + "正常外出");
					accessMessageBean.setHandle_status("2");
					accessMessageBean.setHandle_time(df.format(new Date()));
					accessMessageBean.setAccess_type("2");
				}
				if (!flag) {
					result.setCode(800);
					result.setMessage("图片解析或上传失败");
					return result;
				} else if (this.accessMassageMapper.insertAccessMessage(accessMessageBean) > 0) {
					if (((String) apparatusMap.get("apparatus_name")).indexOf("出") == -1 || this.accessMassageMapper.updateApplyStatus(applyMessageBean) > 0) {
						try {
							Map<String, String> map = new HashMap<>();
							map.put("message", img_url);
							map.put("group_name", (String) groupMap.get("group_name"));
							map.put("person_name", jsonObject.getJSONObject("eventArgs").getJSONObject("faceRecognizeInfo").getJSONObject("personInfo").getString("name"));
							WebSocket.sendInfo(map, null);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						result.setCode(750);
						result.setMessage("更新请假信息失败");
						return result;
					}
				}
			} else {
				accessMessageBean.setApparatus_id(String.valueOf(apparatusMap.get("id")));
				accessMessageBean.setApparatus_name((String) apparatusMap.get("apparatus_name"));
				accessMessageBean.setAddress((String) apparatusMap.get("address"));
				accessMessageBean.setAttribution_dept((String) apparatusMap.get("competent_unit_id"));
				accessMessageBean.setEvent_type("4");
				accessMessageBean.setHandle_status("1");
				accessMessageBean.setPerson_id((String) groupMap.get("user_id"));
				accessMessageBean.setPerson_name(jsonObject.getJSONObject("eventArgs").getJSONObject("faceRecognizeInfo").getJSONObject("personInfo").getString("name"));
				accessMessageBean.setGroup_id((String) groupMap.get("group_id"));
				accessMessageBean.setGroup_name((String) groupMap.get("group_name"));
				accessMessageBean.setCar_no("");
				accessMessageBean.setTemperature(jsonObject.getJSONObject("eventArgs").getJSONObject("faceInfo").getFloat("temperature").floatValue());
				accessMessageBean.setHandle_status("1");
				boolean flagHigh = Base64Utils.Base64ToImage(jsonObject.getJSONObject("eventArgs").getJSONObject("faceInfo").getString("faceImage").replace(" ", "+"), save_url);
				accessMessageBean.setSave_img(img_url);
				SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if (((String) apparatusMap.get("apparatus_name")).indexOf("进") != -1) {
					accessMessageBean.setHandle_result("请假异常进入");
					accessMessageBean.setHandle_status("2");
					accessMessageBean.setHandle_time(df2.format(new Date()));
					accessMessageBean.setAccess_type("1");
				} else if (((String) apparatusMap.get("apparatus_name")).indexOf("出") != -1) {
					accessMessageBean.setHandle_result("请假异常外出");
					accessMessageBean.setHandle_status("2");
					accessMessageBean.setHandle_time(df2.format(new Date()));
					accessMessageBean.setAccess_type("2");
				}
				if (!flagHigh) {
					result.setCode(800);
					result.setMessage("图片解析或上传失败");
					return result;
				} else if (this.accessMassageMapper.insertAccessMessage(accessMessageBean) > 0) {
					AlarmBean accessAlarmBean = new AlarmBean();
					Map<String, Object> paramMap = new HashMap<>();
					paramMap.put("parentId", accessMessageBean.getAttribution_dept());
					int checkflag = 0;
					for (Map<String, Object> map2 : this.baseMassageMapper.checkDept(paramMap)) {
						if (accessMessageBean.getAttribution_dept().equals(map2.get("id_"))) {
							checkflag++;
						}
					}
					if (checkflag > 0) {
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
						Date now = null;
						Date beginTime = null;
						try {
							now = sdf.parse(sdf.format(new Date()));
							beginTime = sdf.parse("09:00");
							sdf.parse("17:00");
						} catch (ParseException e2) {
							e2.printStackTrace();
						}
						Calendar date = Calendar.getInstance();
						date.setTime(now);
						Calendar begin = Calendar.getInstance();
						begin.setTime(beginTime);
						Calendar end = Calendar.getInstance();
						if (!date.after(begin) || !date.before(end)) {
						}
					} else {
						accessAlarmBean.setApparatus_id(accessMessageBean.getApparatus_id());
						accessAlarmBean.setApparatus_name(accessMessageBean.getApparatus_name());
						accessAlarmBean.setAddress(accessMessageBean.getAddress());
						accessAlarmBean.setAlarm_type("进出异常");
						accessAlarmBean.setAlarm_message("未请假");
						accessAlarmBean.setAttribution_dept(accessMessageBean.getAttribution_dept());
						accessAlarmBean.setAccess_id(accessMessageBean.getId().intValue());
						accessAlarmBean.setHandle_status("0");
						this.accessMassageMapper.insertAccessAlarmMessage(accessAlarmBean);
						try {
							Map<String, String> map3 = new HashMap<>();
							map3.put("message", img_url);
							map3.put("group_name", (String) groupMap.get("group_name"));
							map3.put("person_name", jsonObject.getJSONObject("eventArgs").getJSONObject("faceRecognizeInfo").getJSONObject("personInfo").getString("name"));
							WebSocket.sendInfo(map3, null);
						} catch (IOException e3) {
							e3.printStackTrace();
						}
					}
				}
			}
			if (((double) jsonObject.getJSONObject("eventArgs").getJSONObject("faceInfo").getFloat("temperature").floatValue()) >= 37.3d) {
				accessMessageBean.setAttribution_dept((String) apparatusMap.get("competent_unit_id"));
				accessMessageBean.setEvent_type("2");
				accessMessageBean.setHandle_status("1");
				if (!Base64Utils.Base64ToImage(jsonObject.getJSONObject("eventArgs").getJSONObject("faceInfo").getString("faceImage").replace(" ", "+"), save_url)) {
					result.setCode(800);
					result.setMessage("图片解析或上传失败");
					return result;
				} else if (this.accessMassageMapper.insertAccessMessage(accessMessageBean) > 0) {
					AlarmBean accessAlarmBean2 = new AlarmBean();
					accessAlarmBean2.setApparatus_id(accessMessageBean.getApparatus_id());
					accessAlarmBean2.setApparatus_name(accessMessageBean.getApparatus_name());
					accessAlarmBean2.setAddress(accessMessageBean.getAddress());
					accessAlarmBean2.setAlarm_type("进出异常");
					accessAlarmBean2.setAlarm_message("体温过高");
					accessAlarmBean2.setAttribution_dept(accessMessageBean.getAttribution_dept());
					accessAlarmBean2.setAccess_id(accessMessageBean.getId().intValue());
					accessAlarmBean2.setHandle_status("0");
					this.accessMassageMapper.insertAccessAlarmMessage(accessAlarmBean2);
					try {
						Map<String, String> map4 = new HashMap<>();
						map4.put("message", img_url);
						map4.put("group_name", (String) groupMap.get("group_name"));
						map4.put("person_name", jsonObject.getJSONObject("eventArgs").getJSONObject("faceRecognizeInfo").getJSONObject("personInfo").getString("name"));
						WebSocket.sendInfo(map4, null);
					} catch (IOException e4) {
						e4.printStackTrace();
					}
				}
			}
			if ("2".equals(jsonObject.getJSONObject("eventArgs").getJSONObject("faceInfo").getString("mounthocc"))) {
				AlarmBean accessAlarmBean3 = new AlarmBean();
				accessAlarmBean3.setApparatus_id(accessMessageBean.getApparatus_id());
				accessAlarmBean3.setApparatus_name(accessMessageBean.getApparatus_name());
				accessAlarmBean3.setAddress(accessMessageBean.getAddress());
				accessAlarmBean3.setAlarm_type("进出异常");
				accessAlarmBean3.setAlarm_message("未带口罩");
				accessAlarmBean3.setAttribution_dept(accessMessageBean.getAttribution_dept());
				accessAlarmBean3.setAccess_id(accessMessageBean.getId().intValue());
				accessAlarmBean3.setHandle_status("0");
				this.accessMassageMapper.insertAccessAlarmMessage(accessAlarmBean3);
				try {
					Map<String, String> map5 = new HashMap<>();
					map5.put("message", img_url);
					map5.put("group_name", (String) groupMap.get("group_name"));
					map5.put("person_name", jsonObject.getJSONObject("eventArgs").getJSONObject("faceRecognizeInfo").getJSONObject("personInfo").getString("name"));
					WebSocket.sendInfo(map5, null);
				} catch (IOException e5) {
					e5.printStackTrace();
				}
			}
			result.setCode(200);
			result.setMessage("成功");
			return result;
		} catch (Exception e6) {
			result.setCode(720);
			result.setMessage("扫脸数据转换异常");
			return result;
		}
	}

	@Override // com.example.demo.service.AccessMassageService
	public ResultBeanRet getMessageCount(AccessMessageBean bean) {

		bean.setAttribution_dept_list(getGroupIds(bean.getPerson_id()));

		ResultBeanRet result = new ResultBeanRet();
		Map<String, Object> resultMap2 = new HashMap<>();
		int accessCount = this.accessMassageMapper.getAccessCount(bean);
		int visitCount = this.accessMassageMapper.getVisitCount(bean);
		int alarm = this.accessMassageMapper.getAlarmCount(bean);
		int handleCount = this.accessMassageMapper.getHandleCount(bean);
		int temperatureCount = this.accessMassageMapper.getTemperatureCount(bean);
		resultMap2.put("accessCount", Integer.valueOf(accessCount));
		resultMap2.put("visitCount", Integer.valueOf(visitCount));
		resultMap2.put("alarm", Integer.valueOf(alarm));
		resultMap2.put("handleCount", Integer.valueOf(handleCount));
		resultMap2.put("temperatureCount", Integer.valueOf(temperatureCount));
		resultMap2.put("accessUnusualCount", Integer.valueOf(this.accessMassageMapper.getAccessUnusualCount(bean) + this.accessMassageMapper.getAccessStrangerCount(bean)));
		result.setCode(200);
		result.setMessage("成功");
		result.setData(resultMap2);
		return result;
	}

	@Override // com.example.demo.service.AccessMassageService
	public List<AccessMessageBean> getAccessMessageMain(AccessMessageBean bean) {

		bean.setAttribution_dept_list(getGroupIds(bean.getPerson_id()));

		return this.accessMassageMapper.getAccessMessageMain(bean);
	}

	@Override // com.example.demo.service.AccessMassageService
	public ResultBeanRet getAccessMessageApp(AccessMessageBean bean) {
		List<String> attribution_dept_list = new ArrayList<>();

			attribution_dept_list = getGroupIds(bean.getPerson_id());

		bean.setAttribution_dept_list(attribution_dept_list);
		ResultBeanRet result = new ResultBeanRet();
		Map<String, Object> resultMap2 = new HashMap<>();
		int accessAlarmCount = this.accessMassageMapper.getAccessAlarmCount(bean);
		int visitAlarmCount = this.accessMassageMapper.getVisitAlarmCount(bean);
		int carAlarmCount = this.accessMassageMapper.getCarAlarmCount(bean);
		resultMap2.put("accessAlarmCount", Integer.valueOf(accessAlarmCount));
		resultMap2.put("visitAlarmCount", Integer.valueOf(visitAlarmCount));
		resultMap2.put("carAlarmCount", Integer.valueOf(carAlarmCount));
		result.setCode(200);
		result.setMessage("成功");
		result.setData(resultMap2);
		return result;
	}

	@Override // com.example.demo.service.AccessMassageService
	public int getAccessAlarmCount(RiskAlarmBean bean) {
		AccessMessageBean parambean = new AccessMessageBean();
		parambean.setAttribution_dept(bean.getAttribution_dept());
		parambean.setStart_time(bean.getStart_time());
		parambean.setEnd_time(bean.getEnd_time());
		return this.accessMassageMapper.getAccessAlarmCount(parambean);
	}

	@Override // com.example.demo.service.AccessMassageService
	public AlarmBean getAccessAlarmById(int id) {
		return this.accessMassageMapper.getAccessAlarmById(id);
	}
}