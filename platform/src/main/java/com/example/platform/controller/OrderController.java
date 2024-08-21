package com.example.platform.controller;

import com.example.platform.entity.Game;
import com.example.platform.entity.Order;
import com.example.platform.service.GameService;
import com.example.platform.service.OrderService;
import com.example.platform.utils.Result;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @PostMapping("/add")
    public Result<Order> registerController(@RequestBody Order newOrder){
        Order order = orderService.addService(newOrder);
        //话说是不是应该检查余额啊
        if(order!=null){
            return Result.success(order,"购买成功！");
        }else{
            return Result.error("456","购买失败！");
        }
    }

    //@PostMapping("/inquiry")
    @RequestMapping(value = "/inquiry",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<Order> inquiryIsOwnedController(@RequestParam int gameID,@RequestParam int uID){
        Order order = orderService.inquiryIsOwned(gameID,uID);
        if(order!=null){
            return Result.success(order,"有这个游戏！");
        }else{
            return Result.error("456","没有这个游戏！");
        }
    }

    @RequestMapping(value = "/bought",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<List<Order>> showBoughtController(@RequestParam int ID) throws JSONException {
        //int id = Integer.parseInt(ID);
        List<Order> List = orderService.findUserOrderService(ID);
        if(List!=null){
            return Result.success(List,"用户订单展示成功！");
        }else{
            return Result.error("456","用户订单展示失败！");
        }
    }

    //inquiryIsOwned
}
