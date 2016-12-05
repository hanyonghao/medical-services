package com.hyh.service;

import com.hyh.annotation.Autowired;
import com.hyh.common.BaseService;
import com.hyh.dao.MessageDao;
import com.hyh.entity.MessageEntity;

import java.util.List;

public class MessageService extends BaseService{

	@Autowired
	private MessageDao messageDao;

    //查找所有消息记录
    public List<MessageEntity> findAllMessageByUser(String userId){
        String sql = "SELECT m.f_id,d.f_head AS f_publisher_head,d.f_name AS f_publisher_name,m.f_user_id,m.f_publisher_id,m.f_content,m.f_is_view,m.f_create_at FROM t_message AS m INNER JOIN t_doctor AS d ON m.f_publisher_id = d.f_id WHERE m.f_user_id = '"+userId+"' ORDER BY m.f_create_at DESC";
        List<MessageEntity> messages = messageDao.find(MessageEntity.class, sql);
        return messages;
    }

    //清楚消息提示
    public boolean clearViewTips(String userId){
        String sql = "update t_message set f_is_view = '1' where f_user_id = '"+userId+"' and f_is_view = '0'";
        int result = messageDao.executeBySql(sql);
        if(result > 0){
            return true;
        }else{
            return false;
        }
    }

}
