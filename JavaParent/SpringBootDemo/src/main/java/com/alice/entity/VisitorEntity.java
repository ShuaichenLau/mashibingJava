package com.alice.entity;

import java.util.Date;

/**
 * 访客 实体类
 * @author liusc
 * 2020-7-14 15:57:39
 */
public class VisitorEntity {

    private int id;  //int NOT NULL AUTO_INCREMENT COMMENT '主键',
    private String name;  //varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
    private String address;  //varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
    private Integer age;  //int DEFAULT NULL COMMENT '年龄',
    private String phoneNumber;  //varchar(11) DEFAULT NULL COMMENT '电话号码',

    private Date visitorStartTime;  //datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '访问开始时间',
    private Date visitorEndTime;  //datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '访问结束时间',

    public Date getVisitorStartTime() {
        return visitorStartTime;
    }

    public void setVisitorStartTime(Date visitorStartTime) {
        this.visitorStartTime = visitorStartTime;
    }

    public Date getVisitorEndTime() {
        return visitorEndTime;
    }

    public void setVisitorEndTime(Date visitorEndTime) {
        this.visitorEndTime = visitorEndTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
