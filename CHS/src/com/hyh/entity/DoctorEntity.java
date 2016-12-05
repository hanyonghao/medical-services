package com.hyh.entity;

import com.hyh.annotation.EntityExcept;
import com.hyh.annotation.EntityTable;
import com.hyh.common.BaseEntity;

import java.util.Arrays;
import java.util.Date;

@EntityTable("t_doctor")
public class DoctorEntity extends BaseEntity<DoctorEntity>{

    private String id;

    private String hospitalId;

    private String num;

    private String loginName;

    private String password;

    private String name;

    private String tag;

    private String mobile;

    private String point;

    private String subjectType;

    private String head;

    private Date createAt;

    @EntityExcept
    private String[] tags;

    @EntityExcept
    private String hospitalName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @Override
    public String toString() {
        return "DoctorEntity{" +
                "id='" + id + '\'' +
                ", hospitalId='" + hospitalId + '\'' +
                ", num='" + num + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", mobile='" + mobile + '\'' +
                ", point='" + point + '\'' +
                ", subjectType='" + subjectType + '\'' +
                ", head='" + head + '\'' +
                ", createAt=" + createAt +
                ", tags=" + Arrays.toString(tags) +
                ", hospitalName='" + hospitalName + '\'' +
                '}';
    }
}
