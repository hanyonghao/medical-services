package com.hyh.service;

import com.hyh.annotation.Autowired;
import com.hyh.common.BaseService;
import com.hyh.dao.UserDao;
import com.hyh.entity.UserEntity;
import com.hyh.util.GUIDUtil;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class IndexService extends BaseService{

	@Autowired
	private UserDao daoUser;

    public void test(){
//        List<Map<String, Object>> maps = daoUser.find("select count(f_order_date) as count,f_order_date from t_monitor_order GROUP BY f_order_date");
//        for (Map<String, Object> item: maps) {
//            System.out.println(item.toString());
//        }
    }

}
