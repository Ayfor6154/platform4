package com.example.platform.service;

import com.example.platform.entity.Order;

import java.util.List;

public interface OrderService {
    Order addService(Order order);

    Order inquiryIsOwned(int gID,int uID);

    List<Order> findUserOrderService(int uID);
}
