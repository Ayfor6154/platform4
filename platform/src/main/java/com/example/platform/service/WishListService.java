package com.example.platform.service;

import com.example.platform.entity.WishList;

import java.util.List;

public interface WishListService {
    WishList addService(WishList wishList);
    List<WishList> showService(int ID);
}
