package com.example.platform.service.serviceImpl;

import com.example.platform.entity.WishList;
import com.example.platform.repository.WishListDao;
import com.example.platform.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WishListServiceImpl implements WishListService {
    @Resource
    @Autowired
    private WishListDao dao;

    @Override
    public WishList addService(WishList wishList){
        WishList newWishList = dao.save(wishList);
        return newWishList;
    }

    @Override
    public List<WishList> showService(int ID){
        List<WishList> wishList = dao.findByPlayerID(ID);
        // 重要信息置空
        if(wishList != null){
            System.out.println("查出心愿单来了");

            for (int i=0;i<wishList.size();i++) {
                System.out.println(wishList.size());
                System.out.println(i);
                System.out.println(wishList.get(i));
            }/**/
        }
        return wishList;
    }
}
