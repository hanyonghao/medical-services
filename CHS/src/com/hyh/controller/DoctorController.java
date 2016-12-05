package com.hyh.controller;

import com.hyh.annotation.Autowired;
import com.hyh.annotation.RequestMapping;
import com.hyh.common.BaseController;
import com.hyh.entity.DoctorEntity;
import com.hyh.entity.OrderEntity;
import com.hyh.entity.RecordEntity;
import com.hyh.service.DoctorService;
import com.hyh.util.TextUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("Doctor")
public class DoctorController extends BaseController {

	@Autowired
	private DoctorService doctorService;

    private String loginName;

    private String password;

    private String orderId;

    private String feedback;

    private String recordId;

    private String content;

    public void index() throws ServletException, IOException {
        if(hasLogin()){
            List<Map<String, Object>> orderCount = doctorService.getOrderCount();
            String dateList = null;
            for (int i = 0; i < orderCount.size(); i++) {
                Map<String, Object> item = orderCount.get(i);
                String orderDate = TextUtil.DateToString((Date) item.get("orderDate"),new SimpleDateFormat("yyyy-MM-dd"));
                if(i == 0){
                    dateList = orderDate;
                }else{
                    dateList += "," + orderDate;
                }
                item.put("orderDate",orderDate);
            }
            JSONArray jsonArray = JSONArray.fromObject(orderCount);
            request.setAttribute("dateJSON",jsonArray.toString().replace("\"","'"));
            request.setAttribute("dateList",dateList);
            display("Doctor/index.jsp");
        }else {
            redirect("Doctor/login");
        }
	}

	public void login() throws ServletException, IOException {
		display("Doctor/login.jsp");
	}

    public void checkLogin() throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if(!TextUtil.isEmpty(loginName) && !TextUtil.isEmpty(password)){
            DoctorEntity doctor = new DoctorEntity();
            doctor.setLoginName(loginName);
            doctor.setPassword(password);
            DoctorEntity relDoctor = doctorService.checkLogin(doctor);
            if(relDoctor != null){
                map.put("status", true);
                map.put("msg", "登录成功");
                session.setAttribute("doctor",relDoctor);
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

	public void order() throws ServletException, IOException {
        if(hasLogin()){
            DoctorEntity doctor = (DoctorEntity) session.getAttribute("doctor");
            List<OrderEntity> orders = doctorService.findOrderByDoctor(doctor.getId());
            request.setAttribute("orders",orders);
            display("Doctor/order.jsp");
        }else {
            redirect("Doctor/login");
        }
	}

    public void agreeOrder() throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if(hasLogin()){
            if(doctorService.agreeOrder(orderId,feedback)){
                map.put("status", true);
                map.put("msg", "操作成功");
            }else{
                map.put("status", false);
                map.put("msg", "操作失败");
            }
        }else {
            map.put("status", false);
            map.put("msg", "请先登录");
        }
        returnJSON(map);
    }

    public void disagreeOrder() throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if(hasLogin()){
            if(doctorService.disagreeOrder(orderId,feedback)){
                map.put("status", true);
                map.put("msg", "操作成功");
            }else{
                map.put("status", false);
                map.put("msg", "操作失败");
            }
        }else {
            map.put("status", false);
            map.put("msg", "请先登录");
        }
        returnJSON(map);
    }

    public void finishOrder() throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if(hasLogin()){
            if(doctorService.finishOrder(orderId)){
                map.put("status", true);
                map.put("msg", "操作成功");
            }else{
                map.put("status", false);
                map.put("msg", "操作失败");
            }
        }else {
            map.put("status", false);
            map.put("msg", "请先登录");
        }
        returnJSON(map);
    }

    public void cancelOrder() throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if(hasLogin()){
            if(doctorService.cancelOrder(orderId)){
                map.put("status", true);
                map.put("msg", "操作成功");
            }else{
                map.put("status", false);
                map.put("msg", "操作失败");
            }
        }else {
            map.put("status", false);
            map.put("msg", "请先登录");
        }
        returnJSON(map);
    }

	public void reportContent() throws ServletException, IOException {
        if(hasLogin()){
            RecordEntity record = doctorService.findRecordByOne(recordId);
            request.setAttribute("record",record);
            display("Doctor/reportContent.jsp");
        }else {
            redirect("Doctor/login");
        }
	}

	public void reportInput() throws ServletException, IOException {
        if(hasLogin()){
            request.setAttribute("recordId",recordId);
            display("Doctor/reportInput.jsp");
        }else {
            redirect("Doctor/login");
        }
	}

    public void updateReport() throws ServletException, IOException {
        if(hasLogin()){
            if(doctorService.updateReport(recordId,content)){
                RecordEntity record = doctorService.findRecordByOne(recordId);
                System.out.println(record.toString());
                request.setAttribute("record",record);
                display("Doctor/reportContent.jsp");
            }else{
                redirect("Doctor/reportList");
            }
        }else {
            redirect("Doctor/login");
        }
    }

    public void reportList() throws ServletException, IOException {
        if(hasLogin()){
            DoctorEntity doctor = (DoctorEntity) session.getAttribute("doctor");
            List<RecordEntity> records = doctorService.findAllRecordByDoctor(doctor.getId());
            request.setAttribute("records",records);
            display("Doctor/reportList.jsp");
        }else {
            redirect("Doctor/login");
        }
    }

    private boolean hasLogin(){
        Object user = session.getAttribute("doctor");
        if(user != null){
            return true;
        }
        return false;
    }
}
