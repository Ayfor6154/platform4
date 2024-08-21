package com.example.platform.service.serviceImpl;

import com.example.platform.entity.AuditRecord;
import com.example.platform.entity.Game;
import com.example.platform.repository.AuditRecordDao;
import com.example.platform.service.AuditRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuditRecordServiceImpl implements AuditRecordService {
    @Resource
    @Autowired
    private AuditRecordDao arDao;

    @Override
    public List<AuditRecord> showService(int stateID){
        List<AuditRecord> arList = arDao.findByState(stateID);
        // 重要信息置空
        if(arList != null){
            System.out.println("查出记录来了");

            for (int i=0;i<arList.size();i++) {
                System.out.println(arList.size());
                System.out.println(i);
                System.out.println(arList.get(i));
            }/**/
        }
        return arList;
    }

    @Override
    public AuditRecord auditService(int aRid,String desc,int ResultID){
        AuditRecord aRecord = arDao.findByID(aRid);
        aRecord.setDescription(desc);
        aRecord.setResultID(ResultID);
        //是不是应该创造一个result
        return aRecord;
    }

    @Override
    public AuditRecord addService(AuditRecord record) {
        //返回创建好的评论对象(带uid)
        AuditRecord newRecord = arDao.save(record);
        return newRecord;
    }

    @Override
    public AuditRecord updateService(int resultID ,int auditorID ,String desc,int aRid){
        arDao.updateByID(resultID,auditorID,desc,aRid);
        AuditRecord aRecord = arDao.findByID(aRid);
        return aRecord;
    }
}
