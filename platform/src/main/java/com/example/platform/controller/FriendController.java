package com.example.platform.controller;

import com.example.platform.entity.FriendRelationship;
import com.example.platform.entity.Message;
import com.example.platform.service.FriendService;
import com.example.platform.utils.Result;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendController {
    @Resource
    private FriendService friendService;

    @PostMapping("/add")
    public Result<FriendRelationship> addController(@RequestBody FriendRelationship newFR){
        FriendRelationship fr = friendService.addService(newFR);
        if(fr!=null){
            return Result.success(fr,"发送好友申请成功！");
        }else{
            return Result.error("456","发送好友申请失败！");
        }
    }

    //@PostMapping("/find")
    @RequestMapping(value = "/find",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<List<FriendRelationship>> findController(@RequestParam int ID,@RequestParam int stateID){
        List<FriendRelationship> frList = friendService.findService(ID,stateID);
        if(frList!=null){
            return Result.success(frList,"好友关系查询成功！");
        }else{
            return Result.error("456","好友关系查询失败！");
        }
    }
/*
    @PostMapping("/find")
    public List<Message> findController(@RequestParam String name, @RequestParam int stateID){
        List<Message> msgList = msgService.findService(name,stateID);
        System.out.println("是null吗"+msgList==null);
        if(msgList!=null){
            System.out.println("有离线消息");
        }else{
            System.out.println("没有离线消息");
        }
        return msgList;
    }*/

    //@PostMapping("/update")
    @RequestMapping(value = "/update",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public void updateController(@RequestParam int ID,@RequestParam int stateID){
        friendService.updateService(stateID,ID);
    }


    //@PostMapping("/check")
    @RequestMapping(value = "/check",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<FriendRelationship> checkController(@RequestParam Integer fromID,@RequestParam Integer toID) throws JSONException {
        FriendRelationship fr = friendService.checkHasRecord(fromID,toID);
        if(fr!=null){
            System.out.println(fr.getState());
            if(fr.getState()==0){
                System.out.println(fr.getState());
                return Result.success(fr,"已申请,请等待对方通过");
            }
            else{
                return Result.success(fr,"已成为好友");
            }
        }else{
            return Result.error("456","好友关系申请查询无！");
        }
    }
}
