package com.hyh.controller;

import com.hyh.annotation.Autowired;
import com.hyh.annotation.RequestMapping;
import com.hyh.common.BaseController;
import com.hyh.entity.*;
import com.hyh.service.MonitorService;
import com.hyh.util.TextUtil;

import javax.servlet.ServletException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("Monitor")
public class MonitorController extends BaseController {

	@Autowired
	private MonitorService monitorService;

    private String ordId;

    private String hosId;

    private String doctorId;

    private String orderDate;

    private String remark;

    private String recordId;

    public void hospital() throws ServletException, IOException {
        List<HospitalEntity> hospitals = monitorService.findAllHospital();
        request.setAttribute("hospitals",hospitals);
        display("Monitor/hospital.jsp");
	}

    public void doctor() throws ServletException, IOException {
        List<DoctorEntity> doctors = monitorService.findDoctorByHospital(hosId);
        request.setAttribute("doctors",doctors);
        display("Monitor/doctor.jsp");
    }

    public void saveOrder() throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if(hasLogin()){
            if(!TextUtil.isEmpty(doctorId) && !TextUtil.isEmpty(remark) && !TextUtil.isEmpty(orderDate)){
                UserEntity user = (UserEntity) session.getAttribute("user");
                OrderEntity order = new OrderEntity();
                order.setUserId(user.getId());
                order.setDoctorId(doctorId);
                order.setRemark(remark);
                order.setOrderDate(TextUtil.StringToDate(orderDate,new SimpleDateFormat("yyyy-MM-dd")));
                if(monitorService.saveOrder(order)){
                    map.put("status", true);
                    map.put("msg", "预约成功");
                }else{
                    map.put("status", false);
                    map.put("msg", "预约失败");
                }
            }else{
                map.put("status", false);
                map.put("msg", "请填写完整信息");
            }
        }else {
            map.put("status", false);
            map.put("msg", "请先登录");
        }
        returnJSON(map);
    }

    public void order() throws ServletException, IOException {
        if(hasLogin()){
            UserEntity user = (UserEntity) session.getAttribute("user");
            List<OrderEntity> orders = monitorService.findAllOrderByUser(user.getId());
            request.setAttribute("orders",orders);
            display("Monitor/order.jsp");
        }else {
            redirect("User/login");
        }
    }

    public void deleteOrder() throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (hasLogin()) {
            if(monitorService.deleteOrder(ordId)){
                map.put("status", true);
                map.put("msg", "删除成功");
            }else{
                map.put("status", false);
                map.put("msg", "删除失败");
            }
        } else {
            map.put("status", false);
            map.put("msg", "请先登录");
        }
        returnJSON(map);
    }
    public void reportList() throws ServletException, IOException {
        if(hasLogin()){
            UserEntity user = (UserEntity) session.getAttribute("user");
            List<RecordEntity> records = monitorService.findAllRecordByUser(user.getId());
            request.setAttribute("records",records);
            display("Monitor/reportList.jsp");
        }else {
            redirect("User/login");
        }
    }

    public void reportContent() throws ServletException, IOException {
        if(hasLogin()){
            RecordEntity record = monitorService.findRecordByOne(recordId);
            request.setAttribute("record",record);
            display("Monitor/reportContent.jsp");
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
