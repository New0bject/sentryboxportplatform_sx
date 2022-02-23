package com.example.demo.service.serciceimpl;

import com.example.demo.mapper.AlarmMassageMapper;
import com.example.demo.model.AlarmBean;
import com.example.demo.service.AlarmMassageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/* loaded from: AlarmMassageServiceImpl.class */
public class AlarmMassageServiceImpl implements AlarmMassageService {
	@Autowired
	AlarmMassageMapper alarmMassageMapper;

	@Override // com.example.demo.service.AlarmMassageService
	public List<AlarmBean> getAlarmMessage(AlarmBean bean) {
		return this.alarmMassageMapper.getAlarmMessage(bean);
	}

	@Override // com.example.demo.service.AlarmMassageService
	public int getCount(AlarmBean bean) {
		return this.alarmMassageMapper.getCount(bean);
	}

	@Override // com.example.demo.service.AlarmMassageService
	public AlarmBean getAlarmById(AlarmBean bean) {
		return this.alarmMassageMapper.getAlarmById(bean);
	}
}