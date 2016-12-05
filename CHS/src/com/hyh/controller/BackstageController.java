package com.hyh.controller;

import com.hyh.annotation.Autowired;
import com.hyh.annotation.RequestMapping;
import com.hyh.common.BaseController;
import com.hyh.entity.*;
import com.hyh.service.BackstageService;
import com.hyh.util.GUIDUtil;
import com.hyh.util.TextUtil;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("Backstage")
public class BackstageController extends BaseController {

	@Autowired
	private BackstageService backstageService;

    private String loginName;

    private String password;

    private String userId;

    private String userName;

    private String doctorId;

    private String doctorName;

    private String monitorValues;

    private String monitorType;

    private String page;

    public void index() throws ServletException, IOException {
        redirect("Backstage/login");
    }

	public void user() throws ServletException, IOException {
        if(hasLogin()){
            int step = 5;
            if(TextUtil.isEmpty(page)){
                page = "0";
            }
            List<UserEntity> users = backstageService.findUserByPage(Integer.parseInt(page),step);
            long size = backstageService.getSumSize("t_user","");
            request.setAttribute("users",users);
            request.setAttribute("size",Math.ceil(size/step));
            request.setAttribute("page",page);
            display("Backstage/user.jsp");
        }else {
            redirect("Backstage/login");
        }
	}

    public void doctor() throws ServletException, IOException {
        if(hasLogin()){
            int step = 5;
            if(TextUtil.isEmpty(page)){
                page = "0";
            }
            List<DoctorEntity> doctors = backstageService.findDoctorByPage(Integer.parseInt(page),step);
            long size = backstageService.getSumSize("t_doctor","");
            request.setAttribute("doctors",doctors);
            request.setAttribute("size",Math.ceil(size/step));
            request.setAttribute("page",page);
            display("Backstage/doctor.jsp");
        }else {
            redirect("Backstage/login");
        }
    }

    public void monitor() throws ServletException, IOException {
        if(hasLogin()){
            int step = 10;
            if(TextUtil.isEmpty(page)){
                page = "0";
            }
            List<MonitorEntity> monitors = backstageService.findMonitorByPage(userId,Integer.parseInt(page),step);
            long size = backstageService.getSumSize("t_monitor","where f_user_id = '"+userId+"'");
            request.setAttribute("monitors",monitors);
            request.setAttribute("userName",userName);
            request.setAttribute("userId",userId);
            request.setAttribute("size",Math.ceil(size/step));
            request.setAttribute("page",page);
            display("Backstage/monitor.jsp");
        }else {
            redirect("Backstage/login");
        }
    }


    public void order() throws ServletException, IOException {
        if(hasLogin()){
            int step = 10;
            if(TextUtil.isEmpty(page)){
                page = "0";
            }
            List<OrderEntity> orders = backstageService.findOrderByPage(doctorId,Integer.parseInt(page),step);
            long size = backstageService.getSumSize("t_monitor_order","where f_doctor_id = '"+doctorId+"'");
            request.setAttribute("orders",orders);
            request.setAttribute("doctorName",doctorName);
            request.setAttribute("doctorId",doctorId);
            request.setAttribute("size",Math.ceil(size/step));
            request.setAttribute("page",page);
            display("Backstage/order.jsp");
        }else {
            redirect("Backstage/login");
        }
    }

    public void archives() throws ServletException, IOException {
        if(hasLogin()){
            ArchivesEntity archive = backstageService.findArchivesByPage(userId);
            request.setAttribute("archive",archive);
            request.setAttribute("userName",userName);
            display("Backstage/archives.jsp");
        }else {
            redirect("Backstage/login");
        }
    }

    public void interfaces() throws ServletException, IOException {
        if(hasLogin()){
            String[] monitorType = backstageService.getMonitorType();
            List<UserEntity> users = backstageService.findAllUser();
            request.setAttribute("users",users);
            request.setAttribute("monitorType",monitorType);
            display("Backstage/interfaces.jsp");
        }else {
            redirect("Backstage/login");
        }
    }

    public void addMonitor() throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if(hasLogin()){
            MonitorEntity monitor = new MonitorEntity();
            monitor.setId(new GUIDUtil().getValueAfterMD5());
            monitor.setUserId(userId);
            monitor.setType(monitorType);
            monitor.setValues(monitorValues);
            monitor.setName(monitorType+"监测");
            monitor.setCreateAt(new Date());
            if(backstageService.saveMonitor(monitor)){
                map.put("status", true);
                map.put("msg", "提交成功");
            }else{
                map.put("status", false);
                map.put("msg", "提交失败");
            }
        }else{
            map.put("status", false);
            map.put("msg", "请先登录");
        }
        returnJSON(map);
    }

    public void getMonitor() throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if(hasLogin()){
            List<MonitorEntity> monitors = backstageService.findMonitor(userId, monitorType);
            if(monitors.size() > 0){
                map.put("status", true);
                map.put("msg", "请求成功");
                map.put("data", monitors);
            }else{
                map.put("status", true);
                map.put("msg", "暂无记录");
            }
        }else{
            map.put("status", false);
            map.put("msg", "请先登录");
        }
        returnJSON(map);
    }

    public void getArchives() throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if(hasLogin()){
            List<ArchivesEntity> archives = backstageService.findArchives(userId);
            if(archives.size() > 0){
                System.out.println(archives.toString());
                map.put("status", true);
                map.put("msg", "请求成功");
                map.put("data", archives);
            }else{
                map.put("status", true);
                map.put("msg", "暂无记录");
            }
        }else{
            map.put("status", false);
            map.put("msg", "请先登录");
        }
        returnJSON(map);
    }

    public void login() throws ServletException, IOException {
        display("Backstage/login.jsp");
    }

    public void checkLogin() throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if(!TextUtil.isEmpty(loginName) && !TextUtil.isEmpty(password)){
            AdminEntity admin = new AdminEntity();
            admin.setLoginName(loginName);
            admin.setPassword(password);
            AdminEntity relAdmin = backstageService.checkLogin(admin);
            if(relAdmin != null){
                map.put("status", true);
                map.put("msg", "登录成功");
                session.setAttribute("admin",relAdmin);
            }else{
                map.put("status", false);
                map.put("msg", "登录失败");
            }
        }else{
            map.put("status", false);
            map.put("msg", "填写信息不能为空！");
        }

        returnJSON(map);
    }

    private boolean hasLogin(){
        Object user = session.getAttribute("admin");
        if(user != null){
            return true;
        }
        return false;
    }

    public void exit() throws ServletException, IOException {
        session.setAttribute("admin",null);
        display("Backstage/login.jsp");
    }
}
