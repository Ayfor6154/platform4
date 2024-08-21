package com.example.platform.repository;


import com.example.platform.entity.Game;
import com.example.platform.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListDao extends JpaRepository<WishList, Integer> {
    @Query(value = "select * from tl_wishlist where playerID = ?1",nativeQuery = true)
    List<WishList> findByPlayerID(int ID);
}
