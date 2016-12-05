package com.hyh.controller;

import com.hyh.annotation.Autowired;
import com.hyh.annotation.RequestMapping;
import com.hyh.common.BaseController;
import com.hyh.entity.MonitorEntity;
import com.hyh.entity.UserEntity;
import com.hyh.service.MedicalService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@RequestMapping("Medical")
public class MedicalController extends BaseController {

	@Autowired
	private MedicalService medicalService;

    private String monitorType;

	public void index() throws ServletException, IOException {
        if(hasLogin()){
            UserEntity user = (UserEntity) session.getAttribute("user");
            long viewCount = medicalService.getMessageViewCount(user.getId());
            List<MonitorEntity> monitors = medicalService.findTopNewMonitorByUser(user.getId());
            request.setAttribute("viewCount",viewCount);
            request.setAttribute("monitors",monitors);
        }
        display("Medical/index.jsp");
	}

    public void monitorContent() throws ServletException, IOException {
        if(hasLogin()){
            UserEntity user = (UserEntity) session.getAttribute("user");
            List<MonitorEntity> monitors = medicalService.findMonitorByType(monitorType, user.getId());
            request.setAttribute("monitors",monitors);
            request.setAttribute("monitorType",monitorType);
            display("Medical/monitorContent.jsp");
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
