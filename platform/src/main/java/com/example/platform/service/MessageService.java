package com.example.platform.service;

import com.example.platform.entity.Message;

import java.util.List;

public interface MessageService {
    Message addService(Message msg);

    List<Message> findService(String name, int stateID);

    void updateService(int stateID,int ID);
}
