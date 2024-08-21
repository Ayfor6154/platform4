package com.example.platform.service.serviceImpl;

import com.example.platform.entity.Rating;
import com.example.platform.entity.Wallet;
import com.example.platform.repository.WalletDao;
import com.example.platform.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WalletServiceImpl implements WalletService {
    @Resource
    @Autowired
    private WalletDao walletDao;

    @Override
    public Wallet addService(Wallet wallet) {
        //返回创建好的评论对象(带uid)
        Wallet newWallet = walletDao.save(wallet);
        return newWallet;
    }

    @Override
    public Wallet updateService(float money,int ID){
        walletDao.saveMoney(money,ID);
        Wallet wallet = walletDao.findByID(ID);
        if(wallet!=null){
            System.out.println("余额更新成功");
        }
        return wallet;
    }

    @Override
    public Wallet selectService(int ID){
        Wallet wallet = walletDao.findByID(ID);
        if(wallet!=null){
            System.out.println("余额查询成功");
        }
        return wallet;
    }
}
