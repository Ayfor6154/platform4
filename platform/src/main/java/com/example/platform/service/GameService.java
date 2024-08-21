package com.example.platform.service;

import com.example.platform.entity.Game;

import java.util.List;

public interface GameService {
    /**
     * 展示首页的游戏业务逻辑
     * @param name 账户名
     * @param password 密码
     * @return
     */
    //List<Game> showGameService();
    //不知道参数应该写啥
    Game showDetailService(Integer ID);//或者名字
    //Game showDetail2Service(Game game);

    Game addService(Game game);
    List<Game> selectOneMakerService(Integer ID);

    List<Game> selectHomeGames();
    List<Game> selectNewService();
    List<Game> selectHotService();
}
