package com.example.demo.service.serciceimpl;

import com.example.demo.mapper.AccessMassageMapper;
import com.example.demo.mapper.CarAccessMassageMapper;
import com.example.demo.model.CarAccessAlarmBean;
import com.example.demo.model.CarAccessBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.model.RiskAlarmBean;
import com.example.demo.service.CarAccessMassageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
/* loaded from: CarAccessMassageServiceImpl.class */
public class CarAccessMassageServiceImpl implements CarAccessMassageService {
	@Autowired
	CarAccessMassageMapper carAccessMassageMapper;
	@Autowired
	AccessMassageMapper accessMassageMapper;
	@Value("${filePath}")
	private String takeDeliveryPicPath;
	@Value("${filePathVisit}")
	private String takeDeliveryPicPathVisit;

	@Override // com.example.demo.service.CarAccessMassageService
	public int getCarAlarmCount(RiskAlarmBean bean) {
		return this.carAccessMassageMapper.getCarAlarmCount(bean);
	}

	@Override // com.example.demo.service.CarAccessMassageService
	public CarAccessAlarmBean getCarAccessAlarmById(int id) {
		return this.carAccessMassageMapper.getCarAccessAlarmById(id);
	}

	@Override // com.example.demo.service.CarAccessMassageService
	public int getCount(CarAccessAlarmBean bean) {
		return this.carAccessMassageMapper.getCount(bean);
	}

	@Override // com.example.demo.service.CarAccessMassageService
	public List<CarAccessAlarmBean> getCarAccessAlarmList(CarAccessAlarmBean bean) {
		return this.carAccessMassageMapper.getCarAccessAlarmList(bean);
	}

	@Override // com.example.demo.service.CarAccessMassageService
	public synchronized ResultBeanRet insertCarAccessMessage(CarAccessBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		if (this.carAccessMassageMapper.checkRepeatRequest(bean) > 0) {
			result.setCode(600);
			result.setMessage("请求重复");
		} else if (this.carAccessMassageMapper.insertCarAccessMessage(bean) >= 1) {
			if (bean.getCar_attribution() == 2) {
			}
			if (bean.getCar_attribution() == 1) {
			}
			result.setCode(200);
			result.setMessage("新增成功");
		} else {
			result.setCode(500);
			result.setMessage("新增失败");
		}
		return result;
	}
}