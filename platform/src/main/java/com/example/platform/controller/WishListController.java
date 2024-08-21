package com.example.platform.controller;

import com.example.platform.entity.WishList;
import com.example.platform.service.WishListService;
import com.example.platform.utils.Result;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
    @Resource
    private WishListService service;

    @PostMapping("/add")
    public Result<WishList> addController(@RequestBody WishList newWishList){
        WishList wishList = service.addService(newWishList);
        if(wishList!=null){
            return Result.success(wishList,"心愿单加入成功！");
        }else{
            return Result.error("456","心愿单加入失败！");
        }
    }

    //@GetMapping("")
    @RequestMapping(value = "",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<List<WishList>> showController(@RequestParam int ID) throws JSONException {
        //int id = Integer.parseInt(ID);
        List<WishList> wishList = service.showService(ID);
        if(wishList!=null){
            return Result.success(wishList,"心愿单展示成功！");
        }else{
            return Result.error("456","心愿单展示失败！");
        }
    }
}
