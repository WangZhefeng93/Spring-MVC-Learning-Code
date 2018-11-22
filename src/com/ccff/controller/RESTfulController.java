package com.ccff.controller;

import com.ccff.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/RESTfulTest")
public class RESTfulController {
    private List<User> userInfoList = new ArrayList<>();

    private void initUserInfoList(){
        User user1 = new User();
        user1.setUserId(1);
        user1.setUsername("张三");
        user1.setPassword("123456789");
        user1.setLoginDate(new Date());

        User user2 = new User();
        user2.setUserId(2);
        user2.setUsername("李四");
        user2.setPassword("123456789");
        user2.setLoginDate(new Date());

        User user3 = new User();
        user3.setUserId(3);
        user3.setUsername("王五");
        user3.setPassword("123456789");
        user3.setLoginDate(new Date());

        userInfoList.add(user1);
        userInfoList.add(user2);
        userInfoList.add(user3);
    }

    /**
     * 根据用户编号查询用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getUserById/{id}", method = {RequestMethod.GET})
    public @ResponseBody User getUserById(@PathVariable("id") int id){
        initUserInfoList();
        User user = new User();
        for (User u : userInfoList){
            if (u.getUserId() == id)
                return u;
        }
        return user;
    }

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/addUser", method = {RequestMethod.POST})
    public String addUser(User user){
        //具体添加用户信息逻辑
        return "...";
    }

    /**
     * 根据用户编号删除用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteUser/{id}", method = {RequestMethod.DELETE})
    public String deleteUser(@PathVariable("id") int id){
        //具体删除用户信息逻辑
        return "...";
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUser", method = {RequestMethod.PUT})
    public String updateUser(User user){
        //具体修改用户信息逻辑
        return "...";
    }
}
