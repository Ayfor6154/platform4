package com.example.platform.repository;

import com.example.platform.entity.AuditRecord;
import com.example.platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditRecordDao extends JpaRepository<AuditRecord, Integer> {
    @Query(value = "select * from tl_auditrecord where aRid = ?1",nativeQuery = true)
    AuditRecord findByID(int ID);
    @Query(value = "select * from tl_auditrecord where gameID = ?1",nativeQuery = true)
    AuditRecord findByGameID(int ID);

    @Modifying
    @Query(value = "update tl_auditrecord set resultID=?1, auditorID=?2, description=?3 where aRid = ?3",nativeQuery = true)
    void updateByID(int resultID ,int auditorID ,String desc,int aRid);
    //List<Object[]> findByName(String name);
    @Query(value = "select * from tl_auditrecord where username = ?1 and password =?2 ",nativeQuery = true)
    AuditRecord findByNameAndPassword(String name, String password);       //通过用户名name和密码查找用户
    //List<Object[]> findByNameAndPassword(String name, String password);
    @Query(value = "select * from tl_auditrecord where auditorID = ?1 ",nativeQuery = true)
    AuditRecord findByAuditorID(int ID);
    @Query(value = "select * from tl_auditrecord where state = ?1 ",nativeQuery = true)
    List<AuditRecord> findByState(int stateID);
}
