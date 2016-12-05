package com.hyh.service;

import com.hyh.annotation.Autowired;
import com.hyh.common.BaseService;
import com.hyh.dao.*;
import com.hyh.entity.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class BackstageService extends BaseService{

	@Autowired
	private AdminDao adminDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ArchivesDao archivesDao;

    @Autowired
    private MonitorDao monitorDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private OrderDao orderDao;

    public AdminEntity checkLogin(AdminEntity admin) {
        String sql = "select * from t_admin where f_login_name = '" + admin.getLoginName() + "'";
        List<AdminEntity> userList = adminDao.find(AdminEntity.class, sql);
        if (userList.size() > 0){
            AdminEntity relUser = userList.get(0);
            if(relUser.getPassword().equals(admin.getPassword())){
                return relUser;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    public long getSumSize(String table,String where){
        String sql = "select count(*) as f_count from "+table+" "+where;
        Map<String, Object> one = adminDao.findOne(sql);
        return (long)one.get("count");
    }

    public List<UserEntity> findUserByPage(int now,int step) {
        int start = now * step;
        String sql = "select * from t_user" + " order by f_create_at desc limit "+start+","+step;
        List<UserEntity> users = userDao.find(UserEntity.class, sql);
        return users;
    }

    public ArchivesEntity findArchivesByPage(String userId) {
        String sql = "select * from t_archives where f_user_id = '"+userId+"'" + " order by f_create_at desc";
        ArchivesEntity archive = archivesDao.findOne(ArchivesEntity.class, sql);
        return archive;
    }

    public List<MonitorEntity> findMonitorByPage(String userId,int now,int step) {
        int start = now * step;
        String sql = "select * from t_monitor where f_user_id = '"+userId + "' order by f_create_at desc"+" limit "+start+","+step;
        List<MonitorEntity> monitors = monitorDao.find(MonitorEntity.class, sql);
        return monitors;
    }

    public List<DoctorEntity> findDoctorByPage(int now,int step) {
        int start = now * step;
        String sql = "SELECT t_doctor.f_id,t_doctor.f_hospital_id,t_doctor.f_num,t_doctor.f_login_name,t_doctor.f_password,t_doctor.f_name,t_doctor.f_tag,t_doctor.f_mobile,t_doctor.f_point,t_doctor.f_subject_type,t_doctor.f_head,t_doctor.f_create_at,t_hospital.f_name AS f_hospital_name FROM t_doctor INNER JOIN t_hospital ON t_doctor.f_hospital_id = t_hospital.f_id order by t_doctor.f_create_at desc limit "+start+","+step;
        List<DoctorEntity> doctors = doctorDao.find(DoctorEntity.class, sql);
        return doctors;
    }

    public List<OrderEntity> findOrderByPage(String doctorId,int now,int step) {
        int start = now * step;
        String sql = "SELECT t_monitor_order.f_id,t_monitor_order.f_user_id,t_monitor_order.f_doctor_id,t_monitor_order.f_remark,t_monitor_order.f_order_date,t_monitor_order.f_status,t_monitor_order.f_create_at,t_user.f_name as f_user_name FROM t_monitor_order INNER JOIN t_user ON t_monitor_order.f_user_id = t_user.f_id where t_monitor_order.f_doctor_id = '"+doctorId + "' order by t_monitor_order.f_create_at desc"+" limit "+start+","+step;
        List<OrderEntity> orders = orderDao.find(OrderEntity.class, sql);
        return orders;
    }

    public String[] getMonitorType() {
        return MonitorDao.TYPES;
    }

    public List<UserEntity> findAllUser() {
        String sql = "select * from t_user";
        List<UserEntity> users = userDao.find(UserEntity.class, sql);
        return users;
    }

    public boolean saveMonitor(MonitorEntity monitor) {
        int result = monitorDao.insert(monitor);
        if(result > 0){
            return true;
        }else{
            return false;
        }
    }

    public List<MonitorEntity> findMonitor(String userId, String monitorType) {
        String sql = "select * from t_monitor where f_user_id = '"+userId+"'";
        if(!"all".equals(monitorType)){
            sql += " and f_type = '"+monitorType+"'";
        }
        List<MonitorEntity> monitors = monitorDao.find(MonitorEntity.class, sql);
        return monitors;
    }

    public List<ArchivesEntity> findArchives(String userId) {
        String sql = "SELECT t_archives.f_id,t_archives.f_user_id,t_archives.f_sex,t_archives.f_card,t_archives.f_blood_type,t_archives.f_birthday,t_archives.f_high,t_archives.f_origin,t_archives.f_mobile,t_archives.f_province,t_archives.f_city,t_archives.f_area,t_archives.f_quarters,t_archives.f_community,t_archives.f_create_at,t_user.f_name AS f_user_name,t_user.f_head AS f_user_head FROM t_archives ,t_user WHERE t_user.f_id = '"+userId+"'";
        List<ArchivesEntity> archives = archivesDao.find(ArchivesEntity.class, sql);
        for(ArchivesEntity archive : archives){
            archive.setBirthday(new Date());
        }
        return archives;
    }
}
