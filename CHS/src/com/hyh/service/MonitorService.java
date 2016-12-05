package com.hyh.service;

import com.hyh.annotation.Autowired;
import com.hyh.common.BaseService;
import com.hyh.dao.DoctorDao;
import com.hyh.dao.HospitalDao;
import com.hyh.dao.OrderDao;
import com.hyh.dao.RecordDao;
import com.hyh.entity.DoctorEntity;
import com.hyh.entity.HospitalEntity;
import com.hyh.entity.OrderEntity;
import com.hyh.entity.RecordEntity;
import com.hyh.util.GUIDUtil;

import java.util.Date;
import java.util.List;

public class MonitorService extends BaseService{

	@Autowired
	private HospitalDao hospitalDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RecordDao recordDao;

    //查找所有医院
    public List<HospitalEntity> findAllHospital(){
        String sql = "select * from t_hospital";
        List<HospitalEntity> hospitalList = hospitalDao.find(HospitalEntity.class, sql);
        return hospitalList;
    }

    //查找医院下的医生
    public List<DoctorEntity> findDoctorByHospital(String hospitalId){
        String sql = "select * from t_doctor where f_hospital_id ='"+hospitalId+"'";
        List<DoctorEntity> doctorList = doctorDao.find(DoctorEntity.class, sql);
        for (DoctorEntity doc : doctorList) {
            doc.setTags(doc.getTag().split(";"));
        }
        return doctorList;
    }

    //新增预约记录
    public boolean saveOrder(OrderEntity order) {
        order.setId(new GUIDUtil().getValueAfterMD5());
        order.setStatus("预约中");
        order.setCreateAt(new Date());
        int result = orderDao.insert(order);
        if(result > 0){
            return true;
        }else{
            return false;
        }
    }

    //查找所有预约记录
    public List<OrderEntity> findAllOrderByUser(String userId){
        String sql = "select m.f_id,t.f_doctor_head,t.f_doctor_num,t.f_doctor_name,t.f_hospital_name,m.f_order_date,m.f_status,m.f_user_id,m.f_doctor_id,m.f_remark,m.f_create_at from t_monitor_order as m INNER JOIN (select d.f_id as f_doctor_id,d.f_num as f_doctor_num,d.f_name as f_doctor_name,d.f_head as f_doctor_head,h.f_name as f_hospital_name from t_doctor as d inner join t_hospital as h on d.f_hospital_id = h.f_id) as t on m.f_doctor_id = t.f_doctor_id WHERE m.f_user_id = '"+userId+"' ORDER By m.f_create_at DESC";
        List<OrderEntity> orders = orderDao.find(OrderEntity.class, sql);
        updateOrderStatus(orders);
        return orders;
    }

    //删除预约记录
    public boolean deleteOrder(String ordId) {
        int result = orderDao.deleteByID(ordId);
        if(result > 0){
            return true;
        }else{
            return false;
        }
    }

    //查找所有电子病历
    public List<RecordEntity> findAllRecordByUser(String userId){
        String sql = "SELECT t_monitor_record.f_id,t_monitor_record.f_order_id,t_monitor_record.f_content,t_monitor_record.f_is_write,t_monitor_record.f_create_at,t_monitor_order.f_user_id,t_monitor_order.f_doctor_id,t_monitor_order.f_order_date,t_doctor.f_name AS f_doctor_name,t_doctor.f_subject_type AS f_doctor_subject_type,t_hospital.f_name AS f_hospital_name FROM t_monitor_record INNER JOIN t_monitor_order ON t_monitor_record.f_order_id = t_monitor_order.f_id INNER JOIN t_doctor ON t_monitor_order.f_doctor_id = t_doctor.f_id INNER JOIN t_hospital ON t_doctor.f_hospital_id = t_hospital.f_id WHERE t_monitor_order.f_user_id = '"+userId+"'";
        List<RecordEntity> records = recordDao.find(RecordEntity.class, sql);
        return records;
    }

    //显示电子病历内容
    public RecordEntity findRecordByOne(String recordId){
        String sql = "SELECT t_monitor_record.f_id,t_monitor_record.f_order_id,t_monitor_record.f_content,t_monitor_record.f_is_write,t_monitor_record.f_create_at,t_monitor_order.f_user_id,t_monitor_order.f_doctor_id,t_monitor_order.f_order_date,t_doctor.f_name AS f_doctor_name,t_doctor.f_subject_type AS f_doctor_subject_type,t_hospital.f_name AS f_hospital_name FROM t_monitor_record INNER JOIN t_monitor_order ON t_monitor_record.f_order_id = t_monitor_order.f_id INNER JOIN t_doctor ON t_monitor_order.f_doctor_id = t_doctor.f_id INNER JOIN t_hospital ON t_doctor.f_hospital_id = t_hospital.f_id WHERE t_monitor_record.f_id = '"+recordId+"'";
        RecordEntity record = recordDao.findOne(RecordEntity.class, sql);
        return record;
    }
}
