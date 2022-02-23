package com.example.demo.service.serciceimpl;

import com.example.demo.mapper.BaseMassageMapper;
import com.example.demo.mapper.SysGroupMapper;
import com.example.demo.mapper.VisitorMassageMapper;
import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.model.RiskAlarmBean;
import com.example.demo.model.SysGroup;
import com.example.demo.model.VisitorAlarmBean;
import com.example.demo.model.VisitorMessageBean;
import com.example.demo.service.AccessMassageService;
import com.example.demo.service.VisitorMassageService;
import com.example.demo.util.Base64Utils;
import com.example.demo.util.FileSaveUtil;
import com.example.demo.util.GetuiUtil;
import com.example.demo.util.HttpClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import tk.mybatis.mapper.entity.Example;

@Service
@Slf4j
/* loaded from: VisitorMassageServiceImpl.class */
public class VisitorMassageServiceImpl implements VisitorMassageService {
	@Autowired
	VisitorMassageMapper visitorMassageMapper;
	@Autowired
	BaseMassageMapper baseMassageMapper;
	@Value("${filePath}")
	private String takeDeliveryPicPath;
	@Value("${filePathVisit}")
	private String takeDeliveryPicPathVisit;
	@Autowired
	SysGroupMapper sysGroupMapper;
	@Autowired
	AccessMassageService accessMassageService;

	@Override // com.example.demo.service.VisitorMassageService
	public List<VisitorMessageBean> getVisitorMessage(VisitorMessageBean bean) {

		bean.setAttribution_dept_list(this.accessMassageService.getGroupIds(bean.getPerson_id()));
		return this.visitorMassageMapper.getVisitorMessage(bean);
	}

	@Override // com.example.demo.service.VisitorMassageService
	public List<VisitorMessageBean> getVisitorMessageSx(VisitorMessageBean bean) {

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
		return this.visitorMassageMapper.getVisitorMessage(bean);
	}

	@Override // com.example.demo.service.VisitorMassageService
	public int getCount(VisitorMessageBean bean) {

		bean.setAttribution_dept_list(this.accessMassageService.getGroupIds(bean.getPerson_id()));
		return this.visitorMassageMapper.getCount(bean);
	}
	@Override // com.example.demo.service.VisitorMassageService
	public int getCountSx(VisitorMessageBean bean) {
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
		return this.visitorMassageMapper.getCount(bean);
	}

	@Override // com.example.demo.service.VisitorMassageService
	public VisitorMessageBean getVisitorById(Integer id) {
		return this.visitorMassageMapper.getVisitorById(id);
	}

	@Override // com.example.demo.service.VisitorMassageService
	@Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public ResultBeanRet insertVisitorMessage(VisitorMessageBean visitorMessageBean) {
		ResultBeanRet result = new ResultBeanRet();
		visitorMessageBean.setEvent_type("访客登记");
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("parentId", visitorMessageBean.getAttribution_dept());
		int flag = 0;
		for (Map<String, Object> map : this.baseMassageMapper.checkDept(paramMap)) {
			if (visitorMessageBean.getAttribution_dept().equals(map.get("id_"))) {
				flag++;
			}
		}
		if (flag > 0) {
			String faceImages = "";
			visitorMessageBean.setVisit_status("0");
			Map<String, Object> requestMap = new HashMap<>();
			requestMap.put("entryDeviceCodes", "5L06X070007");
			requestMap.put("exitDeviceCodes", "5L06X070029");
			requestMap.put("personCode", visitorMessageBean.getId_card());
			requestMap.put("name", visitorMessageBean.getName());
			Iterator it = Arrays.asList(visitorMessageBean.getImg_picture().split(",")).iterator();
			while (it.hasNext()) {
				faceImages = faceImages + Base64Utils.ImageToBase64ByOnline((String) it.next()) + "@_@";
			}
			System.out.println(faceImages.subSequence(0, faceImages.length() - 3));
			requestMap.put("faceImages", faceImages.subSequence(0, faceImages.length() - 3));
			try {
				System.out.println(HttpClient.post("https://shcloud2.wmtechzone.club:50105/fd/apis/controlcommands/enrollvisitorinfo", HttpClient.prepareParam(requestMap), 30000, 30000, "UTF-8"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (this.visitorMassageMapper.insertVisitorMessage(visitorMessageBean) > 0) {
			if (flag > 0) {
				String cid = this.baseMassageMapper.getCidByPerson(visitorMessageBean.getVisit_person_id());
				Map<String, Object> map2 = new HashMap<>();
				map2.put("msgFlg", "25");
				map2.put("reportId", visitorMessageBean.getId());
				GetuiUtil.Push(cid, map2);
			}
			result.setCode(200);
			result.setMessage("登记成功");
		} else {
			result.setCode(500);
			result.setMessage("登记失败");
		}
		return result;
	}

	@Override // com.example.demo.service.VisitorMassageService
	public List<Map<String, Object>> getdepart(String parentId) {
		Map<String, Object> map = new HashMap<>();
		map.put("parentId", parentId);
		return this.visitorMassageMapper.getdepart(map);
	}

	@Override // com.example.demo.service.VisitorMassageService
	public List<Map<String, Object>> getUserByDepart(String dept_id) {
		return this.visitorMassageMapper.getUserByDepart(dept_id);
	}

	/* JADX WARN: Multi-variable type inference failed */
	@Override // com.example.demo.service.VisitorMassageService
	public String uploadImg(HttpServletRequest request) {
		List<MultipartFile> fileList = new ArrayList<>();
		if (request instanceof MultipartHttpServletRequest) {
			fileList = ((MultipartHttpServletRequest) request).getFiles("updatefile");
		}
		String picPath = "";
		if (fileList != null && fileList.size() > 0) {
			for (MultipartFile file : fileList) {
				try {
					String fileName = "fangke_" + String.valueOf(System.currentTimeMillis());
					Thread.sleep(2000);
					picPath = picPath + FileSaveUtil.saveSignPic(this.takeDeliveryPicPath, this.takeDeliveryPicPathVisit, fileName, file) + ",";
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		return picPath.substring(0, picPath.length() - 1);
	}

	@Override // com.example.demo.service.VisitorMassageService
	public int getAccessVisiterAppCount(VisitorMessageBean bean) {
		return this.visitorMassageMapper.getAccessVisiterAppCount(bean);
	}

	@Override // com.example.demo.service.VisitorMassageService
	public List<AccessMessageBean> getAccessVisiterApp(VisitorMessageBean bean) {
		return this.visitorMassageMapper.getAccessVisiterApp(bean);
	}

	@Override // com.example.demo.service.VisitorMassageService
	public List<VisitorAlarmBean> getUnusualVisitor(VisitorMessageBean bean) {
		return this.visitorMassageMapper.getUnusualVisitor(bean);
	}

	@Override // com.example.demo.service.VisitorMassageService
	public int getUnusualVisitorCount(VisitorMessageBean bean) {
		return this.visitorMassageMapper.getUnusualVisitorCount(bean);
	}

	@Override // com.example.demo.service.VisitorMassageService
	public int getVisitCount(VisitorMessageBean visitorMessageBean) {
		return this.visitorMassageMapper.getVisitCount(visitorMessageBean);
	}

	@Override // com.example.demo.service.VisitorMassageService
	public ResultBeanRet getCountMessage(VisitorMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		Map<String, Object> resultMap = new HashMap<>();
		int totalCount = this.visitorMassageMapper.getTotalCount(bean);
		int frequentlyCount = this.visitorMassageMapper.getFrequentlyCount(bean);
		int unusualCount = this.visitorMassageMapper.getUnusualCount(bean);
		resultMap.put("totalCount", Integer.valueOf(totalCount));
		resultMap.put("frequentlyCount", Integer.valueOf(frequentlyCount));
		resultMap.put("unusualCount", Integer.valueOf(unusualCount));
		result.setCode(200);
		result.setMessage("成功");
		result.setData(resultMap);
		return result;
	}

	@Override // com.example.demo.service.VisitorMassageService
	public int getVisitorAlarmCount(RiskAlarmBean bean) {
		VisitorMessageBean parambean = new VisitorMessageBean();
		parambean.setAttribution_dept(bean.getAttribution_dept());
		parambean.setStart_time(bean.getStart_time());
		parambean.setEnd_time(bean.getEnd_time());
		return this.visitorMassageMapper.getUnusualCount(parambean);
	}

	@Override // com.example.demo.service.VisitorMassageService
	public VisitorAlarmBean getVisitorAlarmById(int id) {
		return this.visitorMassageMapper.getVisitorAlarmById(id);
	}

	@Override // com.example.demo.service.VisitorMassageService
	public ResultBeanRet getUnusualByMonth(VisitorMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();

		bean.setAttribution_dept_list(this.accessMassageService.getGroupIds(bean.getPerson_id()));
		new ArrayList();
		List<Map<String, Object>> list = this.visitorMassageMapper.getUnusualByMonth(bean);
		if (list.size() <= 0) {
			result.setCode(900);
			result.setMessage("查询数据为空");
		} else {
			result.setCode(200);
			result.setMessage("成功");
			result.setData(list);
		}
		return result;
	}

	@Override // com.example.demo.service.VisitorMassageService
	public ResultBeanRet updateVisitStatus(VisitorMessageBean visitorMessageBean) {
		ResultBeanRet result = new ResultBeanRet();
		if (this.visitorMassageMapper.updateVisitStatus(visitorMessageBean) > 0) {
			result.setCode(200);
			result.setMessage("确认成功");
		} else {
			result.setCode(500);
			result.setMessage("确认失败");
		}
		return result;
	}

	@Override // com.example.demo.service.VisitorMassageService
	public ResultBeanRet updateLeaveTime(VisitorMessageBean visitorMessageBean) {
		ResultBeanRet result = new ResultBeanRet();
		if (this.visitorMassageMapper.updateLeaveTime(visitorMessageBean) > 0) {
			result.setCode(200);
			result.setMessage("确认成功");
		} else {
			result.setCode(500);
			result.setMessage("确认失败");
		}
		return result;
	}
}