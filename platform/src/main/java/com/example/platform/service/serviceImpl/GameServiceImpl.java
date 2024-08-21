package com.example.platform.service.serviceImpl;

import com.example.platform.entity.Game;
import com.example.platform.entity.Rating;
import com.example.platform.entity.User;
import com.example.platform.repository.GameDao;
import com.example.platform.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Resource
    @Autowired
    private GameDao gameDao;
 /*
    @Override
    public List<Game> showGameService(){
        List<Game> gameList = gameDao.findAllGame();
        // 重要信息置空
        if(gameList != null){
            System.out.println("查出游戏来了");

                for (int i=0;i<gameList.size();i++) {
                    System.out.println(gameList.size());
                    System.out.println(i);
                    System.out.println(gameList.get(i));
                }
        }
        return gameList;
    }*/
    @Override
    public Game showDetailService(Integer ID){
        Game game = gameDao.findByID(ID);
        if(game!=null){
            System.out.println("2查出游戏来了!");
        }
        return game;
    }

    @Override
    public Game addService(Game game) {
        //返回创建好的评论对象(带uid)
        Game newGame = gameDao.save(game);
        return newGame;
    }

    @Override
    public List<Game> selectOneMakerService(Integer ID){
        List<Game> gameList = gameDao.findByMakerId(ID);
        if(gameList!=null){
            System.out.println("厂商游戏库里有游戏!");
        }
        return gameList;
    }

    @Override
    public List<Game> selectHomeGames(){
        List<Game> gameList = gameDao.findAllGame();
        if(gameList!=null){
            System.out.println("首页有游戏!");
        }
        return gameList;
    }


    @Override
    public List<Game> selectNewService(){
        List<Game> gameList = gameDao.findNewGames();
        if(gameList!=null){
            System.out.println("new游戏");
        }
        return gameList;
    }

    @Override
    public List<Game> selectHotService(){
        List<Game> gameList = gameDao.findHotGames();
        if(gameList!=null){
            System.out.println("hot游戏");
        }
        return gameList;
    }
/*
    @Override
    public Game showDetail2Service(Game game){
        Game game = gameDao.findByID(ID);
    }*/

}
