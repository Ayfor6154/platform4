package com.example.platform.controller;

import com.example.platform.entity.Game;
import com.example.platform.entity.Rating;
import com.example.platform.entity.User;
import com.example.platform.entity.WishList;
import com.example.platform.service.GameService;
import com.example.platform.service.UserService;
import com.example.platform.token.UserLoginToken;
import com.example.platform.utils.Result;
import jdk.nashorn.internal.runtime.Debug;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//可以接受客户端的请求了
@RestController
@RequestMapping("/game")    //注入GameService/game
//嘶，这个很难搞
//注解@RequestMapping中的"/user"是这个控制器类的基路由


public class GameController {


    @Resource
    private GameService gameService;
/*
    //处理post请求
    //实现登录的控制
    //这里的@PostMapping("/login")表示处理post请求，路由为/user/login
    @GetMapping("")///getHomeGame
    public Result<List<Game>> showGameController(){
        List<Game> gameList = gameService.showGameService();
        if(gameList!=null){
            return Result.success(gameList,"游戏展示成功！");
            //不知道这样行不行
        }
        else{
            //System.out.println(user);
            return Result.error("123","无法访问网站！");
        }
    }

*//*
    //@GetMapping("")///getHomeGame
    @PostMapping("/{id}")
    public Result<Game> showDetailController(@RequestBody Game game){
        //System.out.println(gid);
        Game newgame = gameService.showDetailService(gid);
        if(game!=null){
            return Result.success(game,"游戏详情展示成功！");
            //不知道这样行不行
        }
        else{
            //System.out.println(user);
            return Result.error("123","无法展示游戏详情");//无法访问网站！
        }
    }*/
    /**
    **跳转游戏详情页
     */
    @PostMapping("/{gameid}")
    //@RequestMapping(value = "/{id}", produces ={"application/json;charset=UTF-8"})
    public Result<Game> showDetailController(@PathVariable("gameid") Integer gid) throws JSONException {
        System.out.println(gid);
        Game game = gameService.showDetailService(gid);
        if(game!=null){
            return Result.success(game,"游戏详情展示成功！");
            //不知道这样行不行
        }
        else{
            //System.out.println(user);
            return Result.error("123","无法展示游戏详情");//无法访问网站！
        }
    }

    @PostMapping("/add")
    public Result<Game> registerController(@RequestBody Game newGame){
        Game game = gameService.addService(newGame);
        if(game!=null){
            return Result.success(game,"创建成功！");
        }else{
            return Result.error("456","创建失败！");
        }
    }

    //@PostMapping("")
    /*
    @RequestMapping(value = "",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<List<Game>> showOneMakerController(@RequestParam int ID) throws JSONException {
        List<Game> gameList = gameService.selectOneMakerService(ID);
        if(gameList!=null){
            return Result.success(gameList,"游戏库展示成功！");
        }else{
            return Result.error("456","游戏库展示失败！");
        }
    }*/
    @RequestMapping(value = "",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<List<Game>> showOneMakerController(@RequestParam int ID) throws JSONException {
        //int id = Integer.parseInt(ID);
        List<Game> List = gameService.selectOneMakerService(ID);
        if(List!=null){
            return Result.success(List,"游戏库展示成功！");
        }else{
            return Result.error("456","游戏库展示失败！");
        }
    }

/*
    @RequestMapping(value = "/bought",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<List<Game>> showBoughtController(@RequestParam int ID) throws JSONException {
        //int id = Integer.parseInt(ID);
        List<Game> List = gameService.selectBoughtService(ID);
        if(List!=null){
            return Result.success(List,"游戏库展示成功！");
        }else{
            return Result.error("456","游戏库展示失败！");
        }
    }
    */

    @GetMapping("/fyp")
    public Result<List<Game>> getHomeGames(){
        System.out.println("访问成功");
        List<Game> List = gameService.selectHomeGames();
        if(List!=null){
            return Result.success(List,"首页游戏展示成功！");
        }else{
            return Result.error("456","首页游戏展示失败！");
        }
    }

    @GetMapping("/new")
    public Result<List<Game>> getNewGames(){
        System.out.println("访问成功");
        List<Game> List = gameService.selectNewService();
        if(List!=null){
            return Result.success(List,"new游戏展示成功！");
        }else{
            return Result.error("456","new游戏展示失败！");
        }
    }

    @GetMapping("/hot")
    public Result<List<Game>> getHotGames(){
        System.out.println("访问成功");
        List<Game> List = gameService.selectHotService();
        if(List!=null){
            return Result.success(List,"hot游戏展示成功！");
        }else{
            return Result.error("456","hot游戏展示失败！");
        }
    }
}
