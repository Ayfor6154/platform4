package com.example.platform.service.serviceImpl;

import com.example.platform.entity.Game;
import com.example.platform.entity.Order;
import com.example.platform.repository.OrderDao;
import com.example.platform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    @Autowired
    private OrderDao orderDao;

    @Override
    public Order addService(Order order) {
        //返回创建好的评论对象(带uid)
        Order newOrder = orderDao.save(order);
        return newOrder;
    }

    @Override
    public Order inquiryIsOwned(int gID,int uID){
        Order order = orderDao.findOwnedByID(gID,uID);
        if(order!=null){
            System.out.println("玩家游戏库里有这款游戏!");
        }
        return order;
    }

    @Override
    public List<Order> findUserOrderService(int uID){
        List<Order> orderList = orderDao.findOrderByUser(uID);
        if(orderList!=null){
            System.out.println("用户的游戏订单");
        }
        return orderList;
    }
}

