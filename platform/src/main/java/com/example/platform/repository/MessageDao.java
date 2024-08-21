package com.example.platform.repository;

import com.example.platform.entity.Game;
import com.example.platform.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao extends JpaRepository<Message, Integer> {
    @Query(value = "select * from tl_msg where toUser = ?1 and stateID = ?2",nativeQuery = true)
    List<Message> findByName(String name,int stateID);

    @Query(value = "update tl_msg set stateID=?1 where id = ?2",nativeQuery = true)
    void setIDState(int stateID,int ID);
}
