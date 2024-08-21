package com.example.platform.repository;

import com.example.platform.entity.FriendRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendDao extends JpaRepository<FriendRelationship, Integer> {
    @Query(value = "update tl_friend set stateID=?1 where fid = ?2",nativeQuery = true)
    void setIDState(int stateID,int ID);
    @Query(value = "select * from tl_friend where fid = ?1",nativeQuery = true)
    FriendRelationship findByID(int ID);

    @Query(value = "select * from tl_friend where (toId = ?1 or fromID = ?1) and stateID = ?2",nativeQuery = true)
    List<FriendRelationship> findFR(int ID,int stateID);

    @Query(value = "select * from tl_friend where fromID = ?1 and toID=?2",nativeQuery = true)
    FriendRelationship checkByTwoUsersID(int fromID,int toID);
}
