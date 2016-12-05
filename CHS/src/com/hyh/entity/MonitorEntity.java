package com.hyh.entity;

import com.hyh.annotation.EntityTable;
import com.hyh.common.BaseEntity;

import java.util.Date;

@EntityTable("t_monitor")
public class MonitorEntity extends BaseEntity<MonitorEntity>{

    private String id;

    private String userId;

    private String name;

    private String values;

    private String type;

    private Date createAt;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "MonitorEntity{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", values='" + values + '\'' +
                ", type='" + type + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
