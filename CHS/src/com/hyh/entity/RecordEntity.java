package com.hyh.entity;

import com.hyh.annotation.EntityExcept;
import com.hyh.annotation.EntityTable;
import com.hyh.common.BaseEntity;

import java.util.Date;

@EntityTable("t_monitor_record")
public class RecordEntity extends BaseEntity<RecordEntity>{

    private String id;

    private String orderId;

    private String content;

    private int isWrite;

    private Date createAt;

    @EntityExcept
    private String remark;

    @EntityExcept
    private Date orderDate;

    @EntityExcept
    private String userId;

    @EntityExcept
    private String userName;

    @EntityExcept
    private String userHead;

    @EntityExcept
    private String userSex;

    @EntityExcept
    private Date userBirthday;

    @EntityExcept
    private String doctorId;

    @EntityExcept
    private int userAge;

    @EntityExcept
    private String doctorName;

    @EntityExcept
    private String doctorSubjectType;

    @EntityExcept
    private String hospitalName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsWrite() {
        return isWrite;
    }

    public void setIsWrite(int isWrite) {
        this.isWrite = isWrite;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSubjectType() {
        return doctorSubjectType;
    }

    public void setDoctorSubjectType(String doctorSubjectType) {
        this.doctorSubjectType = doctorSubjectType;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @Override
    public String toString() {
        return "RecordEntity{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", content='" + content + '\'' +
                ", isWrite=" + isWrite +
                ", createAt=" + createAt +
                ", remark='" + remark + '\'' +
                ", orderDate=" + orderDate +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userHead='" + userHead + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday=" + userBirthday +
                ", doctorId='" + doctorId + '\'' +
                ", userAge=" + userAge +
                ", doctorName='" + doctorName + '\'' +
                ", doctorSubjectType='" + doctorSubjectType + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                '}';
    }
}
