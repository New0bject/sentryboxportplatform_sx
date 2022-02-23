package com.example.demo.service.serciceimpl;

import com.example.demo.mapper.InspectMessageMapper;
import com.example.demo.model.InspectMessageBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.service.InspectMassageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/* loaded from: InspectMassageServiceImpl.class */
public class InspectMassageServiceImpl implements InspectMassageService {
	@Autowired
	InspectMessageMapper inspectMessageMapper;

	@Override // com.example.demo.service.InspectMassageService
	public int getCount(InspectMessageBean bean) {
		return this.inspectMessageMapper.getCount(bean);
	}

	@Override // com.example.demo.service.InspectMassageService
	public List<InspectMessageBean> getInspectMessage(InspectMessageBean bean) {
		return this.inspectMessageMapper.getInspectMessage(bean);
	}

	@Override // com.example.demo.service.InspectMassageService
	public ResultBeanRet updateInspectMessage(InspectMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		if (this.inspectMessageMapper.updateInspectMessage(bean) >= 0) {
			result.setCode(200);
			result.setMessage("成功");
		} else {
			result.setCode(500);
			result.setMessage("失败");
		}
		return result;
	}

	@Override // com.example.demo.service.InspectMassageService
	public void insertInspectMessage(InspectMessageBean bean) {
		this.inspectMessageMapper.insertInspectMessage(bean);
	}
}