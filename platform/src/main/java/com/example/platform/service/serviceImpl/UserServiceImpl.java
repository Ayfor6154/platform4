package com.example.platform.service.serviceImpl;

import com.example.platform.entity.User;
import com.example.platform.repository.UserDao;
import com.example.platform.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    @Autowired
    private UserDao userDao;

    @Override
    public User loginService(String name, String password) {
        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null
        //ArrayList<User> arrayList= new ArrayList<>(userDao.findByNameAndPassword(name, password));
        //User user = (User)userDao.findByNameAndPassword(name, password).get(0);
        /*
        List<Object[]> listArray = userDao.findByNameAndPassword(name, password);
        if (listArray != null && listArray.size() > 0) {
            User user = new ObjectMapper().convertValue(listArray.get(0), User.class);
            // 重要信息置空
            if(user != null){
                user.setPassword("");
            }
            return user;
        }
        else
        {
            return null;
        }*/
        User user = userDao.findByNameAndPassword(name, password);
        // 重要信息置空
        if(user != null){
            //这个置空要怎么办
            //user.setPassword("");
        }
        return user;
    }

    @Override
    public User registerService(User user) {
        //当新用户的用户名已存在时
        if(userDao.findByName(user.getName())!=null){
            // 无法注册
            return null;
        }else{
            //返回创建好的用户对象(带uid)
            User newUser = userDao.save(user);
            if(newUser != null){
                newUser.setPassword("");
            }
            return newUser;
        }
    }

    @Override
    public User findUserById(int ID) {
        User user = userDao.findByID(ID);
        // 重要信息置空
        /*
        if(user != null){
            user.setPassword("");
        }
        */
        return user;
    }

    @Override
    public List<User> findUserByIdList(int ID) {
        List<User> user = userDao.findByIDList(ID);
        // 重要信息置空
        /*
        if(user != null){
            user.setPassword("");
        }
        */
        return user;
    }


}
