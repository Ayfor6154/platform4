package com.example.platform.service.serviceImpl;

import com.example.platform.entity.Game;
import com.example.platform.entity.Message;
import com.example.platform.repository.GameDao;
import com.example.platform.repository.MessageDao;
import com.example.platform.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    @Autowired
    private MessageDao msgDao;

    @Override
    public Message addService(Message msg) {
        //返回创建好的评论对象(带uid)
        Message newMessage = msgDao.save(msg);
        return newMessage;
    }

    @Override
    public List<Message> findService(String name, int stateID) {
        //返回创建好的评论对象(带uid)
        List<Message> msgList = msgDao.findByName(name,stateID);
        return msgList;
    }

    @Override
    public void updateService(int ID, int stateID) {
        //返回创建好的评论对象(带uid)
        msgDao.setIDState(stateID,ID);
    }
}
