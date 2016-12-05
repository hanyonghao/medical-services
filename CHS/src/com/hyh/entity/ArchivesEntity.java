package com.hyh.entity;

import com.hyh.annotation.EntityExcept;
import com.hyh.annotation.EntityTable;
import com.hyh.common.BaseEntity;

import java.util.Date;

@EntityTable("t_archives")
public class ArchivesEntity extends BaseEntity<ArchivesEntity>{

    private String id;

    private String userId;

    private String sex;

    private String card;

    private String bloodType;

    private Date birthday;

    private String high;

    private String origin;

    private String mobile;

    private String province;

    private String city;

    private String area;

    private String quarters;

    private String community;

    private Date createAt;

    @EntityExcept
    private String userName;

    @EntityExcept
    private String userHead;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getQuarters() {
        return quarters;
    }

    public void setQuarters(String quarters) {
        this.quarters = quarters;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
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

    @Override
    public String toString() {
        return "ArchivesEntity{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", sex='" + sex + '\'' +
                ", card='" + card + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", birthday=" + birthday +
                ", high='" + high + '\'' +
                ", origin='" + origin + '\'' +
                ", mobile='" + mobile + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", quarters='" + quarters + '\'' +
                ", community='" + community + '\'' +
                ", createAt=" + createAt +
                ", userName='" + userName + '\'' +
                ", userHead='" + userHead + '\'' +
                '}';
    }

}
