package com.hyh.service;

import com.hyh.annotation.Autowired;
import com.hyh.common.BaseService;
import com.hyh.dao.UserDao;
import com.hyh.entity.UserEntity;
import com.hyh.util.GUIDUtil;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserService extends BaseService{

	@Autowired
	private UserDao userDao;

    //注册
    public boolean saveRegister(UserEntity user){
        user.setId(new GUIDUtil().getValueAfterMD5());
        user.setHead("/Public/User/img/default_head.png");
        user.setCreateAt(new Date());
        int result = userDao.insert(user);
        if (result > 0) {
            return true;
        }else {
            return false;
        }
    }

    //验证登录
    public UserEntity checkLogin(UserEntity user){
        String sql = "select * from t_user where f_login_name = '" + user.getLoginName() + "'";
        List<UserEntity> userList = userDao.find(UserEntity.class, sql);
        if (userList.size() > 0){
            UserEntity relUser = userList.get(0);
            if(relUser.getPassword().equals(user.getPassword())){
                return relUser;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    //修改账号
    public boolean updateUser(UserEntity user) {
        int result = userDao.update(user);
        if (result > 0) {
            return true;
        }else {
            return false;
        }
    }
}
