package com.hyh.service;

import com.hyh.annotation.Autowired;
import com.hyh.common.BaseService;
import com.hyh.dao.MessageDao;
import com.hyh.dao.MonitorDao;
import com.hyh.entity.MonitorEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MedicalService extends BaseService{

	@Autowired
	private MessageDao messageDao;

    @Autowired
    private MonitorDao monitorDao;

    //获取消息提示数
    public long getMessageViewCount(String userId){
        String sql = "select count(*) as f_view_count from t_message where f_user_id = '"+userId+"' and f_is_view = '0'";
        Map<String, Object> result = messageDao.findOne(sql);
        long count = (Long) result.get("viewCount");
        return count;
    }

    //获取最新的监测记录
    public List<MonitorEntity> findTopNewMonitorByUser(String userId){
        List<MonitorEntity> monitors = new ArrayList<MonitorEntity>();
        String[] types = MonitorDao.TYPES;
        for (int i = 0; i < types.length; i++) {
            String sql = "select * from t_monitor where f_user_id = '"+userId+"' and f_type = '"+types[i]+"' order by f_create_at desc";
            MonitorEntity monitor = monitorDao.findOne(MonitorEntity.class, sql);
            monitors.add(monitor);
        }
        return monitors;
    }

    //获取单类型监测记录
    public List<MonitorEntity> findMonitorByType(String monitorType, String userId){
        String sql = "select * from t_monitor where f_user_id = '"+userId+"' and f_type = '"+monitorType+"' order by f_create_at desc";
        List<MonitorEntity> monitors = monitorDao.find(MonitorEntity.class, sql);
        return monitors;
    }

}
