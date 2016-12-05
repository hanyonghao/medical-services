package com.hyh.entity;

import com.hyh.annotation.EntityExcept;
import com.hyh.annotation.EntityTable;
import com.hyh.common.BaseEntity;

import java.util.Date;

@EntityTable("t_message")
public class MessageEntity extends BaseEntity<MessageEntity>{

    private String id;

    private String userId;

    private String publisherId;

    private String content;

    private int isView;

    private Date createAt;

    @EntityExcept
    private String publisherName;

    @EntityExcept
    private String publisherHead;

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

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsView() {
        return isView;
    }

    public void setIsView(int isView) {
        this.isView = isView;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherHead() {
        return publisherHead;
    }

    public void setPublisherHead(String publisherHead) {
        this.publisherHead = publisherHead;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", publisherId='" + publisherId + '\'' +
                ", content='" + content + '\'' +
                ", isView=" + isView +
                ", createAt=" + createAt +
                ", publisherName='" + publisherName + '\'' +
                ", publisherHead='" + publisherHead + '\'' +
                '}';
    }
}
