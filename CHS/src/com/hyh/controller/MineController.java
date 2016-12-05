package com.hyh.controller;

import com.hyh.annotation.Autowired;
import com.hyh.annotation.RequestMapping;
import com.hyh.common.BaseController;
import com.hyh.entity.ArchivesEntity;
import com.hyh.entity.UserEntity;
import com.hyh.service.ArchivesService;
import com.hyh.util.TextUtil;

import javax.servlet.ServletException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("Mine")
public class MineController extends BaseController {

	@Autowired
	private ArchivesService archivesService;

    private String id;
    private String userId;
    private String sex;
    private String card;
    private String bloodType;
    private String birthday;
    private String high;
    private String origin;
    private String mobile;
    private String province;
    private String city;
    private String area;
    private String quarters;

    public void history() throws ServletException, IOException {
        if(hasLogin()){
            display("Mine/history.jsp");
        }else {
            redirect("User/login");
        }
    }

    public void archives() throws ServletException, IOException {
        if(hasLogin()){
            ArchivesEntity archives = archivesService.findUserArchives((UserEntity) session.getAttribute("user"));
            request.setAttribute("archives",archives);
            display("Mine/archives.jsp");
        }else {
            redirect("User/login");
        }
    }

    public void saveArchives() throws ServletException, IOException {
        if(hasLogin()){
            Map<String, Object> map = new HashMap<String, Object>();
            UserEntity user = (UserEntity) session.getAttribute("user");
            ArchivesEntity archives = new ArchivesEntity();
            archives.setId(id);
            archives.setUserId(user.getId());
            archives.setSex(sex);
            archives.setCard(card);
            archives.setBloodType(bloodType);
            archives.setBirthday(TextUtil.StringToDate(birthday, new SimpleDateFormat("yyyy-MM-dd")));
            archives.setHigh(high);
            archives.setOrigin(origin);
            archives.setMobile(mobile);
            archives.setProvince(province);
            archives.setCity(city);
            archives.setArea(area);
            archives.setQuarters(quarters);
            if(archivesService.saveArchives(archives)){
                map.put("status", true);
                map.put("msg", "保存成功");
            }else{
                map.put("status", false);
                map.put("msg", "保存失败");
            }
            returnJSON(map);
        }else {
            redirect("User/login");
        }
    }

    private boolean hasLogin(){
        Object user = session.getAttribute("user");
        if(user != null){
            return true;
        }
        return false;
    }

}
