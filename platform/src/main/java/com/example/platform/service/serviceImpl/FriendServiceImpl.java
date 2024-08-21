package com.example.platform.service.serviceImpl;

import com.example.platform.entity.FriendRelationship;
import com.example.platform.entity.Message;
import com.example.platform.repository.FriendDao;
import com.example.platform.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {
    @Resource
    @Autowired
    private FriendDao friendDao;

    @Override
    public FriendRelationship addService(FriendRelationship fr) {
        FriendRelationship newFR = friendDao.save(fr);
        return newFR;
    }

    @Override
    public List<FriendRelationship> findService(int ID,int stateID) {
        List<FriendRelationship> frList = friendDao.findFR(ID,stateID);
        return frList;
    }

    @Override
    public void updateService( int stateID,int ID) {
        friendDao.setIDState(stateID,ID);
    }

    @Override
    public FriendRelationship checkHasRecord(int fromID,int toID){
        FriendRelationship fr = friendDao.checkByTwoUsersID(fromID,toID);
        return fr;
    }
}
