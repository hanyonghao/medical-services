package com.hyh.dao;

import com.hyh.common.BaseDao;
import com.hyh.entity.MonitorEntity;

public class MonitorDao extends BaseDao<MonitorEntity>{

    public static String[] TYPES = {"血糖","血压","体温","体重","血氧","血脂","肝功能","血尿常规","糖化血红蛋白","骨骼肌质量","机体营养"};

}
