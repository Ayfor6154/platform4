package com.example.platform.repository;

import com.example.platform.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameDao extends JpaRepository<Game, Integer> {
    /**/
    //这几个方法真的必要存在吗
    @Query(value = "select * from tl_game where gname = ?1",nativeQuery = true)
    Game findByName(String name);
    //List<Object[]> findByName(String name);
    @Query(value = "select * from tl_game where gname = ?1 and makerID =?2 ",nativeQuery = true)
    Game findByNameAndPassword(String name, int makerid);

    @Query(value = "select * from tl_game where makerID =?1 ",nativeQuery = true)
    List<Game> findByMakerId(int makerid);
/*
    @Query(value = "select * from tl_game where makerID =?1 ",nativeQuery = true)
    List<Game> findByPlayerId(int makerid);*/

    @Query(value = "select * from tl_game",nativeQuery = true)
    List<Game> findAllGame();

    @Query(value = "select * from tl_game where gid = ?1",nativeQuery = true)
    Game findByID(Integer ID);
    //findGameOnPage()

    //找新游戏
    @Query(value = "select * from tl_game ORDER BY time DESC ",nativeQuery = true)
    List<Game> findNewGames();

    //找最火的游戏
    @Query(value = "select * from tl_game ORDER BY clickNum DESC ",nativeQuery = true)
    List<Game> findHotGames();

}
