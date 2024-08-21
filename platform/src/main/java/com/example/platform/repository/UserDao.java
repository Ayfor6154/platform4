package com.example.platform.repository;

import com.example.platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {   //这里要求用Integer，不知道会不会有影响
    //User findByName(String name);                                 //通过用户名name查找用户，注意要按照JPA的格式使用驼峰命名法
    @Query(value = "select * from tl_user where username = ?1",nativeQuery = true)
    User findByName(String name);
    //List<Object[]> findByName(String name);
    @Query(value = "select * from tl_user where username = ?1 and password =?2 ",nativeQuery = true)
    User findByNameAndPassword(String name, String password);       //通过用户名name和密码查找用户
    //List<Object[]> findByNameAndPassword(String name, String password);
    @Query(value = "select * from tl_user where uid = ?1 ",nativeQuery = true)
    User findByID(int ID);
    @Query(value = "select * from tl_user where uid = ?1 ",nativeQuery = true)
    List<User> findByIDList(int ID);
    /**
     * 要求驼峰命名法。如果自定义查询方法可以不遵守这个规则
     *
     * 自定义查询方法例子(本项目不需要用到):
     */
    /*
    @Query(value = "select * from user where uname LIKE ?1 OR email LIKE ?2 OR lastdid LIKE ?3 OR uid LIKE ?4",nativeQuery = true)
    Page<User> findUserswithoutgender(
            String uname,
            String email,
            String lastdid,
            String uid,
            Pageable request
    );*/


}
