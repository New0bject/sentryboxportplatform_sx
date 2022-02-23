package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.RiskAlarmBean;
import com.example.demo.model.VisitorAlarmBean;
import com.example.demo.model.VisitorMessageBean;

@Repository
public interface VisitorMassageMapper {

	public List<VisitorMessageBean> getVisitorMessage(VisitorMessageBean bean);

	public int insertVisitorMessage(VisitorMessageBean visitorMessageBean);

	public List<Map<String, Object>> getdepart(Map<String, Object> map);

	public List<Map<String, Object>> getUserByDepart(String dept_id);

	public VisitorMessageBean getVisitorById(Integer id);

	public int getCount(VisitorMessageBean bean);

	public int getAccessVisiterAppCount(VisitorMessageBean bean);

	public List<AccessMessageBean> getAccessVisiterApp(VisitorMessageBean bean);

	public List<VisitorAlarmBean> getUnusualVisitor(VisitorMessageBean bean);

	public int getUnusualVisitorCount(VisitorMessageBean bean);

	public int getVisitCount(VisitorMessageBean visitorMessageBean);

	public int getTotalCount(VisitorMessageBean bean);

	public int getFrequentlyCount(VisitorMessageBean bean);

	public int getUnusualCount(VisitorMessageBean bean);

	public int getVisitorAlarmCount(RiskAlarmBean bean);

	public VisitorAlarmBean getVisitorAlarmById(int id);

	public List<Map<String, Object>> getUnusualByMonth(VisitorMessageBean bean);

	public int updateVisitStatus(VisitorMessageBean visitorMessageBean);

	public int updateLeaveTime(VisitorMessageBean visitorMessageBean);

}
