package com.example.platform.entity;

import javax.persistence.*;

@Table(name = "tl_auditrecord")
@Entity
public class AuditRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aRid;
    private Integer auditorID;
    private int gameID;
    private String description;
    private Integer resultID;
    private int state;//0待审核;1审核通过；2未通过
    private int type;//0游戏；1用户；2评论
    //private int reporterID;

    public AuditRecord(){}

    //创造一个审核表
    /*
    public AuditRecord(int auID,int gID,String desc,int resID){
        this.auditorID=auID;
        this.gameID=gID;
        this.description=desc;
        this.resultID=resID;
    }*/

    public int getaRid() {
        return aRid;
    }

    public void setaRid(int aRid) {
        this.aRid = aRid;
    }

    public Integer getAuditorID() {
        return auditorID;
    }

    public void setAuditorID(Integer auditorID) {
        this.auditorID = auditorID;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getResultID() {
        return resultID;
    }

    public void setResultID(Integer resultID) {
        this.resultID = resultID;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
/*
    public int getReporterID() {
        return reporterID;
    }

    public void setReporterID(int reporterID) {
        this.reporterID = reporterID;
    }*/
}
