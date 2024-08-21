package com.example.platform.repository;

import com.example.platform.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RatingDao extends JpaRepository<Rating, Integer> {
    @Query(value = "select * from tl_rating where orderID = ?1 ORDER BY time DESC",nativeQuery = true)
    List<Rating> findByOrderID(int oid);
    @Query(value = "select * from tl_rating where gameID = ?1 ORDER BY time DESC",nativeQuery = true)
    List<Rating> findByGameID(int oid);
    @Query(value = "select * from tl_rating where rid = ?1",nativeQuery = true)
    Rating findByID(int rid);
    @Transactional
    @Modifying()
    @Query(value = "update tl_rating set likedNum=likedNum+1 where rid = ?1",nativeQuery = true)
    void addLikedNum(int rid);
}
