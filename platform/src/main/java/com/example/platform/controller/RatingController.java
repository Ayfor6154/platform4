package com.example.platform.controller;

import com.example.platform.entity.Game;
import com.example.platform.entity.Rating;
import com.example.platform.service.RatingService;
import com.example.platform.utils.Result;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/review")
public class RatingController {
    @Resource
    private RatingService ratingService;


    @PostMapping("/add")
    public Result<Rating> addController(@RequestBody Rating newRating){
        Rating rating = ratingService.addService(newRating);
        if(rating!=null){
            return Result.success(rating,"评论成功！");
        }else{
            return Result.error("456","评论失败！");
        }
    }

    @RequestMapping(value = "/show",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<List<Rating>> showController(@RequestParam int ID) throws JSONException {
        //int id = Integer.parseInt(ID);
        List<Rating> List = ratingService.showService(ID);
        if(List!=null){
            return Result.success(List,"评论展示成功！");
        }else{
            return Result.error("456","评论展示失败！");
        }
    }

    @RequestMapping(value = "/addlike",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<Rating> addLikeController(@RequestParam int ID){
        Rating rating = ratingService.addLikedService(ID);
        //点赞这个地方应该也用到网络webSocket
        if(rating!=null){
            return Result.success(rating,"点赞成功！");
        }else{
            return Result.error("456","点赞失败！");
        }
    }
}
