package com.example.platform.service;

import com.example.platform.entity.FriendRelationship;
import com.example.platform.entity.Message;

import java.util.List;

public interface FriendService {
    FriendRelationship addService(FriendRelationship fr);

    List<FriendRelationship> findService(int ID,int stateID);

    void updateService(int stateID,int ID);

    FriendRelationship checkHasRecord(int fromID,int toID);
}
