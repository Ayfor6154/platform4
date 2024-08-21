package com.example.platform.controller;

import com.example.platform.config.CurrentUser;
import com.example.platform.entity.Order;
import com.example.platform.entity.User;
import com.example.platform.service.serviceImpl.TokenService;
import com.example.platform.service.UserService;
import com.example.platform.token.PassToken;
import com.example.platform.token.UserLoginToken;
import com.example.platform.utils.Result;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//可以接受客户端的请求了
@RestController
@RequestMapping("/user")    //注入UserService
                            //注解@RequestMapping中的"/user"是这个控制器类的基路由
public class UserController {

    @Resource
    private UserService userService;
    //@Autowired
    @Resource
    TokenService tokenService;


    //处理post请求
    //实现登录的控制
    //这里的@PostMapping("/login")表示处理post请求，路由为/user/login
    /*
    @PostMapping("/login")
    public Result<User> loginController(@RequestParam String name, @RequestParam String password){
    //public Result<User> loginController(@RequestBody String name, @RequestBody String password){
        name=removeFirst(name);
        password = removeFirst(password);

        System.out.println(name);
        System.out.println(password);
        User user = userService.loginService(name, password);
        if(user!=null){
            return Result.success(user,"登录成功！");
        }
        else{
            System.out.println(user);
            return Result.error("123","账号或密码错误！");
        }



    }
    */
    @PassToken
    @ResponseBody
    //@PostMapping("/login")
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})// MediaType.APPLICATION_JSON_VALUE
    public String loginController(@RequestParam String name, @RequestParam String password) throws JSONException {
        //public Result<User> loginController(@RequestBody String name, @RequestBody String password){
        System.out.println(name);
        System.out.println(password);
        name = removeFirst(name);
        password = removeFirst(password);

        System.out.println(name);
        System.out.println(password);
        User user = userService.loginService(name, password);
        System.out.println("1token呢");
        System.out.println(user.getID());
        System.out.println(user.getPassword());

        JSONObject jsonObject = new JSONObject();
        if(user!=null){

            String token = tokenService.getToken(user);
            System.out.println("token呢");
            jsonObject.put("token",token);
            jsonObject.put("user",user);
            jsonObject.put("msg","登录成功");
            jsonObject.put("code",200);

            //return Result.success(user,"登录成功！");
        }
        else{

            jsonObject.put("msg","账号或密码错误");
            jsonObject.put("code",500);

            //System.out.println(user);
            //return Result.error("123","账号或密码错误！");
        }
        return jsonObject.toString();//

    }
/*
    @ResponseBody
    @GetMapping("/login")
    public Object login(User user){
        User u = userService.loginService(user);
        JSONObject jsonObject = new JSONObject();
        if (u != null){
            String token = tokenService.getToken(u);
            jsonObject.put("token",token);
            jsonObject.put("user",u);
            jsonObject.put("msg","登录成功");
            jsonObject.put("code",200);
        }else{
            jsonObject.put("msg","账号或密码错误");
            jsonObject.put("code",500);
        }
        return jsonObject;
    }*/

    //实现注册的控制
    //
    //这里的@PostMapping("/register")表示处理post请求，路由为/user/register
    @PostMapping("/register")
    public Result<User> registerController(@RequestBody User newUser){
        User user = userService.registerService(newUser);
        if(user!=null){
            return Result.success(user,"注册成功！");
        }else{
            return Result.error("456","用户名已存在！");
        }
    }

    public String removeFirst(String uname){
        uname=uname.startsWith(",") ? uname.substring(1) : uname;
        return uname;
    }

    //测试方法
    @GetMapping("/getMessage")
    @ResponseBody
    @UserLoginToken
    public String getMessage(){
        System.out.println("访问成功");
        return "你已通过验证";
    }

    @GetMapping("/test")
    @ResponseBody
    @UserLoginToken
    public Object testCurrentUser(@CurrentUser User user) {
        return user;
    }
    /*

    //@GetMapping("/hello")
    //?nickname=zhangsan
    @RequestMapping(name="/hello",method= RequestMethod.GET)
    public String hello(){
        return  "hello world，你好，11";
    }

    */

    @RequestMapping(value = "/findList",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<List<User>> findUserByIDList(@RequestParam int uID){
        List<User> user = userService.findUserByIdList(uID);
        if(user!=null){
            return Result.success(user,"有这个用户！");
        }else{
            return Result.error("456","没有这个用户！");
        }
    }

    @RequestMapping(value = "/find",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<User> findUserByID(@RequestParam int uID){
        User user = userService.findUserById(uID);
        if(user!=null){
            return Result.success(user,"有这个用户！");
        }else{
            return Result.error("456","没有这个用户！");
        }
    }

}



/*
    */