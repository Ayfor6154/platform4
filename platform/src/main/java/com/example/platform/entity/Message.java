package com.example.platform.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Author:gzh
 * @Date: 2022/4/20 20:43
 */
@Data
@Table(name = "tl_msg")
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    //    时间
    private String time;
    //    接收方
    @Column(name="toUser")
    private String to;
    //    发送方
    @Column(name="fromUser")
    private String from;
    //    消息
    private String msg;
    //    登录用户名
    @Transient
    private List<String> userNames;// 不需要持久化到数据库

    @Column(name="stateID")
    private int state;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
