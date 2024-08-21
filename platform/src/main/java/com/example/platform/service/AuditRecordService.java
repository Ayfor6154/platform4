package com.example.platform.service;

import com.example.platform.entity.AuditRecord;
import java.util.List;

public interface AuditRecordService {
    /**
     /** 根据状态展示记录
     */
    List<AuditRecord> showService(int stateID);
    //List<AuditRecord> showDoneService();
    /**
    /** 审核记录
     */
    AuditRecord auditService(int aRid,String desc,int ResultID);
    //AuditRecord updateService();

    AuditRecord addService(AuditRecord record);


    AuditRecord updateService(int resultID ,int auditorID ,String desc,int aRid);
}
