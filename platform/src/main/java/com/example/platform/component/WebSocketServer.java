package com.example.platform.component;

import com.alibaba.fastjson.JSON;
import com.example.platform.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.platform.entity.Message;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:gzh
 * @Date: 2022/4/20 20:27
 * 注意在websocket通信中只能传string
 */
//@Component
@RestController
@ServerEndpoint("/socket/{username}")
public class WebSocketServer {
    //    存储当前对象
    public static final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    //@Autowired
    //@Resource
    //private MessageController msgController;
    @Autowired
    private MessageService msgService = new MessageService() {
        @Override
        public Message addService(Message msg) {
            return null;
        }

        @Override
        public List<Message> findService(String name, int stateID) {
            return null;
        }

        @Override
        public void updateService(int ID, int stateID) {

        }
    };
//    建立连接
    /***
     * 1.把登录用户存到sessionMap中
     * 2.发送给所有人当前登录人员信息
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        System.out.println("当前用户名=="+username);
        sessionMap.put(username, session);
        // 发送登录人员消息给所有的客户端
        sendAllMessage(setUserList());

        // 发送离线消息给用户
        sendOfflineMessagesToUser(username);
    }

    //关闭连接
    /**
     * 1.把登出的用户从sessionMap中剃除
     * 2.发送给所有人当前登录人员信息
     */
    @OnClose
    public void onClose(@PathParam("username") String username) {
        sessionMap.remove(username);
        sendAllMessage(setUserList());
    }

    /**
     * 接收处理客户端发来的数据
     */
    @OnMessage
    public void onMessage(String message) {
//        解析消息为java对象
        Message msg = JSON.parseObject(message, Message.class);
        if(StringUtils.isEmpty(msg.getTo())){
            sendAllMessage(JSON.toJSONString(msg));
        }else{
            Session sessionTo = sessionMap.get(msg.getTo());
            sendMessage(message,sessionTo);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    private String setUserList(){
        ArrayList<String> list = new ArrayList<>();
        for(String key:sessionMap.keySet()){
            list.add(key);
        }
        Message message = new Message();
        message.setUserNames(list);
        return JSON.toJSONString(message);
    }

    //    服务端发送消息给指定客户端
    private void sendMessage(String message, Session toSession) {
        try {
            toSession.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //   服务端发送消息给所有客户端
    private void sendAllMessage(String message) {
        try {
            for (Session session : sessionMap.values()) {
                session.getBasicRemote().sendText(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*
    private void sendOfflineMessagesToUser(String recipient) {
        List<Message> msgList = msgController.findController(recipient,2);
        //System.out.println("是null吗"+msgList==null);
        if(msgList!=null){
            for (Message msg : msgList) {
                sendMessage(msg.getMsg(), sessionMap.get(recipient));
                msgController.updateController(msg.getID(),0);
            }
        }
        else{
            System.out.println("没有记录");
        }
    }*/
    //@PostMapping("/find")
    public List<Message> findController(String name,int stateID){
        System.out.println("是null吗"+msgService);
        List<Message> msgList = msgService.findService(name,stateID);
        System.out.println("是null吗"+msgList==null);
        if(msgList!=null){
            System.out.println("有离线消息");
        }else{
            System.out.println("没有离线消息");
        }
        return msgList;
    }


    private void sendOfflineMessagesToUser(String recipient) {
        List<Message> msgList = findController(recipient,2);
        //List<Message> msgList = msgService.findService(recipient,2);
        //System.out.println("是null吗"+msgList==null);
        if(msgList!=null){
            for (Message msg : msgList) {
                sendMessage(msg.getMsg(), sessionMap.get(recipient));
                //msgController.updateController(msg.getID(),0);
                msgService.updateService(msg.getID(),0);
            }
        }
        else{
            System.out.println("没有记录");
        }
    }
}
