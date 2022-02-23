package com.example.demo.service.serciceimpl;

import com.example.demo.mapper.ApparatusMassageMapper;
import com.example.demo.model.ApparatusCategoryBean;
import com.example.demo.model.ApparatusMessageBean;
import com.example.demo.service.ApparatusMassageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/* loaded from: ApparatusMassageServiceImpl.class */
public class ApparatusMassageServiceImpl implements ApparatusMassageService {
	@Autowired
	ApparatusMassageMapper apparatusMassageMapper;

	@Override // com.example.demo.service.ApparatusMassageService
	public List<ApparatusMessageBean> getApparatusMessage(ApparatusCategoryBean bean) {
		return this.apparatusMassageMapper.getApparatusMessage(bean);
	}

	@Override // com.example.demo.service.ApparatusMassageService
	public List<ApparatusCategoryBean> getApparatusCategory() {
		return this.apparatusMassageMapper.getApparatusCategory();
	}

	@Override // com.example.demo.service.ApparatusMassageService
	public List<ApparatusCategoryBean> getApparatusByGroup(ApparatusCategoryBean bean) {
		return this.apparatusMassageMapper.getApparatusByGroup(bean);
	}
}