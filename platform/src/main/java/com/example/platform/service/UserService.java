package com.example.platform.service;

import com.example.platform.entity.User;

import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {
    /**
     * 登录业务逻辑
     * @param name 账户名
     * @param password 密码
     * @return
     */
    User loginService(String name, String password);

    /**
     * 注册业务逻辑
     * @param user 要注册的User对象，属性中主键uid要为空，若uid不为空可能会覆盖已存在的user
     * @return
     */
    User registerService(User user);

    User findUserById(int ID);
    List<User> findUserByIdList(int ID);
}
