package com.example.platform.repository;

import com.example.platform.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
    @Query(value = "select * from tl_order where gameID = ?1 and userID = ?2",nativeQuery = true)
    Order findOwnedByID(int gID,int uID);


    @Query(value = "select * from tl_order where userID = ?1",nativeQuery = true)
    List<Order> findOrderByUser(int uID);
}
