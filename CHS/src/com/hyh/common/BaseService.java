package com.hyh.common;

import com.hyh.dao.MessageDao;
import com.hyh.dao.OrderDao;
import com.hyh.dao.RecordDao;
import com.hyh.entity.MessageEntity;
import com.hyh.entity.OrderEntity;
import com.hyh.entity.RecordEntity;
import com.hyh.util.AppUtil;
import com.hyh.util.GUIDUtil;

import java.util.Date;
import java.util.List;

public class BaseService {

	//更新预约状态
    protected int updateOrderStatus(List<OrderEntity> orders){
        OrderDao orderDao = new OrderDao();
        int result = 0;
        for(OrderEntity item :orders){
            item.setUserAge(AppUtil.getAge(item.getUserBirthday()));
            if(AppUtil.compareDate(item.getOrderDate(),new Date()) == -1){
                if("预约确认".equals(item.getStatus())){
                    item.setStatus("正在进行");
                    result += orderDao.update(item);
                }else if("预约中".equals(item.getStatus())){
                    item.setStatus("已过期");
                    result += orderDao.update(item);
                }
            }
        }
        return result;
    }

    //发送反馈信息
    protected int sendMessage(String userId, String publisherId, String content){
        MessageDao messageDao = new MessageDao();
        MessageEntity message = new MessageEntity();
        message.setId(new GUIDUtil().getValueAfterMD5());
        message.setUserId(userId);
        message.setPublisherId(publisherId);
        message.setContent(content);
        message.setIsView(0);
        message.setCreateAt(new Date());
        return messageDao.insert(message);
    }

    //创建电子病历
    protected int createRecord(String orderId){
        RecordDao recordDao = new RecordDao();
        RecordEntity record = new RecordEntity();
        record.setId(new GUIDUtil().getValueAfterMD5());
        record.setOrderId(orderId);
        record.setContent("");
        record.setIsWrite(0);
        record.setCreateAt(new Date());
        return recordDao.insert(record);
    }
}
