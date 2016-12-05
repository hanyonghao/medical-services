package com.hyh.service;

import com.hyh.annotation.Autowired;
import com.hyh.common.BaseService;
import com.hyh.dao.ArchivesDao;
import com.hyh.entity.ArchivesEntity;
import com.hyh.entity.UserEntity;
import com.hyh.util.GUIDUtil;
import com.hyh.util.TextUtil;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ArchivesService extends BaseService{

	@Autowired
	private ArchivesDao archivesDao;

    //查看用户健康档案
    public ArchivesEntity findUserArchives(UserEntity user){
        String sql = "select * from t_archives where f_user_id = '" + user.getId() + "'";
        List<ArchivesEntity> archivesList = archivesDao.find(ArchivesEntity.class, sql);
        if (archivesList.size() > 0){
            ArchivesEntity archives = archivesList.get(0);
            return archives;
        }else {
            return null;
        }
    }

    //保存健康档案
    public boolean saveArchives(ArchivesEntity archives) {
        archives.setCommunity("无");
        archives.setCreateAt(new Date());
        int result = 0;
        System.out.println(archives.toString());
        if (!TextUtil.isEmpty(archives.getId())){
            result = archivesDao.update(archives);
        }else {
            archives.setId(new GUIDUtil().getValueAfterMD5());
            result = archivesDao.insert(archives);
        }
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }
}
