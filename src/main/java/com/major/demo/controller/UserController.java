package com.major.demo.controller;

import com.major.demo.entiy.Response;
import com.major.demo.entiy.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller // 以 Spring MVC 形式返回 json
@RestController // RestController = Controller + ResponseBody
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
//    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setName("xiaoming");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("pwd");
        user.setDesc(null);

        return user;
    }

    @RequestMapping("/getUserJson")
//    @ResponseBody
    public Response getUserJson() {
        User user = new User();
        user.setName("xiaoming");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("pwd");
        user.setDesc(null);

        return Response.success(user);
    }

    @RequestMapping("/getUsers")
//    @ResponseBody
    public Response getUsers() {
        List<User> list = new ArrayList<>();
        {
            User user = new User();
            user.setName("xiaoming");
            user.setAge(18);
            user.setBirthday(new Date());
            user.setPassword("pwd");
            user.setDesc(null);
            list.add(user);
        }
        {
            User user = new User();
            user.setName("xiaohua");
            user.setAge(28);
            user.setBirthday(new Date());
            user.setPassword("pwd123");
            user.setDesc("i am i");
            list.add(user);
        }

        return Response.success(list);
    }
}
