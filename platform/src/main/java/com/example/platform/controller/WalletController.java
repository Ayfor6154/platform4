package com.example.platform.controller;

import com.example.platform.entity.Wallet;
import com.example.platform.service.WalletService;
import com.example.platform.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//可以接受客户端的请求了
@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Resource
    private WalletService walletService;

    @PostMapping("/add")
    public Result<Wallet> addController(@RequestBody Wallet newWallet){
        Wallet wallet = walletService.addService(newWallet);
        if(wallet!=null){
            return Result.success(wallet,"创建钱包成功！");
        }else{
            return Result.error("456","创建钱包失败！");
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<Wallet> updateController(@RequestParam float money,@RequestParam int ID){
        Wallet wallet = walletService.updateService(money,ID);
        if(wallet!=null){
            return Result.success(wallet,"更新成功！");
        }else{
            return Result.error("456","更新失败！");
        }
    }

    @RequestMapping(value = "/select",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<Wallet> selectController(@RequestParam int ID){
        Wallet wallet = walletService.selectService(ID);
        if(wallet!=null){
            return Result.success(wallet,"更新成功！");
        }else{
            return Result.error("456","更新失败！");
        }
    }
}
