package com.example.demo.service.serciceimpl;

import com.example.demo.mapper.RistMassageMapper;
import com.example.demo.model.RiskAlarmBean;
import com.example.demo.service.RistMassageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/* loaded from: RistMassageServiceImpl.class */
public class RistMassageServiceImpl implements RistMassageService {
	@Autowired
	RistMassageMapper ristMassageMapper;

	@Override // com.example.demo.service.RistMassageService
	public int getCount(RiskAlarmBean bean) {
		return this.ristMassageMapper.getCount(bean);
	}

	@Override // com.example.demo.service.RistMassageService
	public List<RiskAlarmBean> getAlarmList(RiskAlarmBean bean) {
		return this.ristMassageMapper.getAlarmList(bean);
	}
}