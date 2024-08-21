package com.example.platform.repository;

import com.example.platform.entity.Rating;
import com.example.platform.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletDao extends JpaRepository<Wallet, Integer> {

    @Query(value = "update tl_wallet set amount=amount+money?1 where id = ?2",nativeQuery = true)
    void saveMoney(float money,int rid);//money是改变的值

    @Query(value = "select * from tl_wallet where uid = ?1",nativeQuery = true)
    Wallet findByID(int rid);
}
