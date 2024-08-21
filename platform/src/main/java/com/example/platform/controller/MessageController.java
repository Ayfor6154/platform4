package com.example.platform.controller;

import com.example.platform.entity.Game;
import com.example.platform.entity.Message;
import com.example.platform.service.GameService;
import com.example.platform.service.MessageService;
import com.example.platform.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/msg")
public class MessageController {
    @Resource
    private MessageService msgService;

    @PostMapping("/add")
    public Result<Message> addController(@RequestBody Message newMessage){
        Message msg = msgService.addService(newMessage);
        if(msg!=null){
            return Result.success(msg,"离线消息保存成功！");
        }else{
            return Result.error("456","离线消息保存失败！");
        }
    }

    //@PostMapping("/find2")
    @RequestMapping(value = "/find2",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<List<Message>> find2Controller(@RequestParam String name,@RequestParam int stateID){
        List<Message> msgList = msgService.findService(name,stateID);
        if(msgList!=null){
            return Result.success(msgList,"某状态消息查询成功！");
        }else{
            return Result.error("456","某状态消息查询失败！");
        }
    }

    //@PostMapping("/find")
    @RequestMapping(value = "/find",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public List<Message> findController(@RequestParam String name,@RequestParam int stateID){
        List<Message> msgList = msgService.findService(name,stateID);
        System.out.println("是null吗"+msgList==null);
        if(msgList!=null){
            System.out.println("有离线消息");
        }else{
            System.out.println("没有离线消息");
        }
        return msgList;
    }

    //@PostMapping("/update")
    @RequestMapping(value = "/update",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public void updateController(@RequestParam int ID,@RequestParam int stateID){
        msgService.updateService(ID,stateID);
    }
}
