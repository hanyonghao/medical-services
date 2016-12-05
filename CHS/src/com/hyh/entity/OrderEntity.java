package com.hyh.entity;

import com.hyh.annotation.EntityExcept;
import com.hyh.annotation.EntityTable;
import com.hyh.common.BaseEntity;

import java.util.Arrays;
import java.util.Date;

@EntityTable("t_monitor_order")
public class OrderEntity extends BaseEntity<OrderEntity>{

    private String id;

    private String userId;

    private String doctorId;

    private String remark;

    private Date orderDate;

    private String status;

    private Date createAt;

    @EntityExcept
    private String doctorName;

    @EntityExcept
    private String doctorNum;

    @EntityExcept
    private String doctorHead;

    @EntityExcept
    private String hospitalName;

    @EntityExcept
    private String userName;

    @EntityExcept
    private String userHead;

    @EntityExcept
    private Date userBirthday;

    @EntityExcept
    private String userSex;

    @EntityExcept
    private int userAge;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorNum() {
        return doctorNum;
    }

    public void setDoctorNum(String doctorNum) {
        this.doctorNum = doctorNum;
    }

    public String getDoctorHead() {
        return doctorHead;
    }

    public void setDoctorHead(String doctorHead) {
        this.doctorHead = doctorHead;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", remark='" + remark + '\'' +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", createAt=" + createAt +
                ", doctorName='" + doctorName + '\'' +
                ", doctorNum='" + doctorNum + '\'' +
                ", doctorHead='" + doctorHead + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", userName='" + userName + '\'' +
                ", userHead='" + userHead + '\'' +
                ", userBirthday=" + userBirthday +
                ", userSex='" + userSex + '\'' +
                ", userAge='" + userAge + '\'' +
                '}';
    }
}
