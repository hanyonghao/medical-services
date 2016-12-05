package com.hyh.service;

import com.hyh.annotation.Autowired;
import com.hyh.common.BaseService;
import com.hyh.dao.DoctorDao;
import com.hyh.dao.OrderDao;
import com.hyh.dao.RecordDao;
import com.hyh.entity.DoctorEntity;
import com.hyh.entity.OrderEntity;
import com.hyh.entity.RecordEntity;
import com.hyh.util.AppUtil;

import java.util.List;
import java.util.Map;

public class DoctorService extends BaseService{

	@Autowired
	private DoctorDao doctorDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RecordDao recordDao;

    //验证登录
    public DoctorEntity checkLogin(DoctorEntity doctor){
        String sql = "select * from t_doctor where f_login_name = '" + doctor.getLoginName() + "'";
        List<DoctorEntity> doctorList = doctorDao.find(DoctorEntity.class, sql);
        if (doctorList.size() > 0){
            DoctorEntity relDoctor = doctorList.get(0);
            if(relDoctor.getPassword().equals(doctor.getPassword())){
                return relDoctor;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    //获取预约数
    public List<Map<String, Object>> getOrderCount(){
        String sql = "select count(f_order_date) as f_count,f_order_date from t_monitor_order where f_status = '预约中' and to_days(now()) <= to_days(`f_order_date`) GROUP BY f_order_date";
        List<Map<String, Object>> maps = orderDao.find(sql);
        return maps;
    }

    //获取医生预约记录
    public List<OrderEntity> findOrderByDoctor(String doctorId){
        String sql = "SELECT m.f_id AS f_id,m.f_user_id AS f_user_id,u.f_name AS f_user_name,u.f_head AS f_user_head,a.f_birthday AS f_user_birthday,a.f_sex AS f_user_sex,m.f_remark AS f_remark,m.f_order_date AS f_order_date,m.f_status AS f_status FROM t_user AS u INNER JOIN t_archives AS a ON a.f_user_id = u.f_id INNER JOIN t_monitor_order AS m ON m.f_user_id = u.f_id WHERE m.f_doctor_id = '"+doctorId+"' ORDER By m.f_create_at DESC";
        List<OrderEntity> orders = orderDao.find(OrderEntity.class, sql);
        updateOrderStatus(orders);
        return orders;
    }

    //同意预约
    public boolean agreeOrder(String orderId,String feedback){
        String sql = "update t_monitor_order set f_status = '预约确认' where f_id = '"+orderId+"' and f_status = '预约中'";
        int result = orderDao.executeBySql(sql);
        if(result > 0){
            sql = "select * from t_monitor_order where f_id = '"+orderId+"'";
            OrderEntity order = orderDao.findOne(OrderEntity.class, sql);
            String msg = "你在 "+order.getOrderDate()+" 的预约的申请已被通过，请在约定时间到达医院就诊，感谢支持。<br/>反馈："+feedback;
            sendMessage(order.getUserId(),order.getDoctorId(),msg);
            return true;
        }else{
            return false;
        }
    }

    //拒绝预约
    public boolean disagreeOrder(String orderId,String feedback){
        String sql = "update t_monitor_order set f_status = '已终止' where f_id = '"+orderId+"' and f_status = '预约中'";
        int result = orderDao.executeBySql(sql);
        if(result > 0){
            sql = "select * from t_monitor_order where f_id = '"+orderId+"'";
            OrderEntity order = orderDao.findOne(OrderEntity.class, sql);
            String msg = "你在 "+order.getOrderDate()+" 的预约的申请不能通过，理由："+feedback+"，十分抱歉。";
            sendMessage(order.getUserId(),order.getDoctorId(),msg);
            return true;
        }else{
            return false;
        }
    }

    //完成预约
    public boolean finishOrder(String orderId){
        String sql = "update t_monitor_order set f_status = '已完成' where f_id = '"+orderId+"' and f_status = '正在进行'";
        int result = orderDao.executeBySql(sql);
        if(result > 0){
            sql = "select * from t_monitor_order where f_id = '"+orderId+"'";
            OrderEntity order = orderDao.findOne(OrderEntity.class, sql);
            String msg = "你在 "+order.getOrderDate()+" 的诊疗已完成，请查收病历，感谢支持。";
            sendMessage(order.getUserId(),order.getDoctorId(),msg);
            createRecord(orderId);
            return true;
        }else{
            return false;
        }
    }

    //取消预约
    public boolean cancelOrder(String orderId){
        String sql = "update t_monitor_order set f_status = '已终止' where f_id = '"+orderId+"' and f_status = '正在进行'";
        int result = orderDao.executeBySql(sql);
        if(result > 0){
            sql = "select * from t_monitor_order where f_id = '"+orderId+"'";
            OrderEntity order = orderDao.findOne(OrderEntity.class, sql);
            String msg = "你在 "+order.getOrderDate()+" 的诊疗已被取消。";
            sendMessage(order.getUserId(),order.getDoctorId(),msg);
            return true;
        }else{
            return false;
        }
    }

    //查找所有电子病历
    public List<RecordEntity> findAllRecordByDoctor(String doctorId){
        String sql = "SELECT t_monitor_record.f_id,t_monitor_record.f_order_id,t_monitor_record.f_content,t_monitor_record.f_is_write,t_monitor_record.f_create_at,t_monitor_order.f_remark,t_monitor_order.f_order_date,t_monitor_order.f_user_id,t_user.f_name AS f_user_name,t_user.f_head AS f_user_head,t_archives.f_sex AS f_user_sex,t_archives.f_birthday AS f_user_birthday,t_monitor_order.f_doctor_id FROM t_monitor_record INNER JOIN t_monitor_order ON t_monitor_order.f_id = t_monitor_record.f_order_id INNER JOIN t_user ON t_monitor_order.f_user_id = t_user.f_id INNER JOIN t_archives ON t_user.f_id = t_archives.f_user_id  WHERE t_monitor_order.f_doctor_id = '"+doctorId+"' GROUP BY t_monitor_record.f_create_at DESC";
        List<RecordEntity> records = recordDao.find(RecordEntity.class, sql);
        for(RecordEntity item : records){
            item.setUserAge(AppUtil.getAge(item.getUserBirthday()));
        }
        return records;
    }

    //更新电子病历
    public boolean updateReport(String recordId, String content) {
        String sql = "update t_monitor_record set f_content = '"+content+"',f_is_write = '1' where f_id = '"+recordId+"'";
        int result = recordDao.executeBySql(sql);
        if(result > 0){
            sql = "SELECT t_monitor_record.f_id,t_monitor_record.f_order_id,t_monitor_record.f_content,t_monitor_record.f_is_write,t_monitor_record.f_create_at,t_monitor_order.f_remark,t_monitor_order.f_order_date,t_monitor_order.f_user_id,t_user.f_name AS f_user_name,t_user.f_head AS f_user_head,t_archives.f_sex AS f_user_sex,t_archives.f_birthday AS f_user_birthday,t_monitor_order.f_doctor_id FROM t_monitor_record INNER JOIN t_monitor_order ON t_monitor_order.f_id = t_monitor_record.f_order_id INNER JOIN t_user ON t_monitor_order.f_user_id = t_user.f_id INNER JOIN t_archives ON t_user.f_id = t_archives.f_user_id  WHERE t_monitor_record.f_id = '"+recordId+"'";
            RecordEntity record = recordDao.findOne(RecordEntity.class, sql);
            String msg = "你在 "+record.getOrderDate()+" 就诊的电子病历已更新，请核对信息。";
            sendMessage(record.getUserId(),record.getDoctorId(),msg);
            return true;
        }else{
            return false;
        }
    }

    //查看电子病历详情
    public RecordEntity findRecordByOne(String recordId){
        String sql = "SELECT t_monitor_record.f_id,t_monitor_record.f_order_id,t_monitor_record.f_content,t_monitor_record.f_is_write,t_monitor_record.f_create_at,t_monitor_order.f_user_id,t_monitor_order.f_doctor_id,t_monitor_order.f_order_date,t_doctor.f_name AS f_doctor_name,t_doctor.f_subject_type AS f_doctor_subject_type,t_hospital.f_name AS f_hospital_name FROM t_monitor_record INNER JOIN t_monitor_order ON t_monitor_record.f_order_id = t_monitor_order.f_id INNER JOIN t_doctor ON t_monitor_order.f_doctor_id = t_doctor.f_id INNER JOIN t_hospital ON t_doctor.f_hospital_id = t_hospital.f_id WHERE t_monitor_record.f_id = '"+recordId+"'";
        RecordEntity record = recordDao.findOne(RecordEntity.class, sql);
        return record;
    }
}
