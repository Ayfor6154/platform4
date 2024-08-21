package com.example.platform.service.serviceImpl;

import com.example.platform.entity.Game;
import com.example.platform.entity.Rating;
import com.example.platform.repository.RatingDao;
import com.example.platform.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Resource
    @Autowired
    private RatingDao ratingDao;

    @Override
    public Rating addService(Rating rating){
        //返回创建好的评论对象(带uid)
        Rating newRating = ratingDao.save(rating);
        return newRating;
    }

    @Override
    public List<Rating> showService(int ID){
        List<Rating> ratingList = ratingDao.findByGameID(ID);
        if(ratingList!=null){
            System.out.println("这个游戏有评论!");
        }
        return ratingList;
    }

    @Override
    public Rating addLikedService(int ID){
        ratingDao.addLikedNum(ID);
        Rating rating = ratingDao.findByID(ID);
        if(rating!=null){
            System.out.println("点赞成功");
        }
        return rating;
    }

}
