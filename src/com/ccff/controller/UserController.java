package com.ccff.controller;

import com.ccff.model.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private List<User> loginedUsersList = new ArrayList<>();

    /*@RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/login");
        return modelAndView;
    }*/
    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }

    /*@RequestMapping("/doLogin")
    public ModelAndView doLogin(User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.addObject("username",user.getUsername());
        modelAndView.addObject("userId",user.getUserId());
        modelAndView.addObject("password",user.getPassword());
        modelAndView.setViewName("user/doLogin");
        return modelAndView;
    }*/
    /*@RequestMapping("/doLogin")
    public String doLogin(User user, HttpServletRequest request){
        request.setAttribute("user",user);
        request.setAttribute("username",user.getUsername());
        request.setAttribute("userId",user.getUserId());
        request.setAttribute("password",user.getPassword());
        return "user/doLogin";
    }*/
    @RequestMapping("/doLogin")
    public String doLogin(User user, Model model){
        model.addAttribute("user",user);
        model.addAttribute("username",user.getUsername());
        model.addAttribute("userId",user.getUserId());
        model.addAttribute("password",user.getPassword());
        return "user/doLogin";
    }
    /*@RequestMapping("/doLogin")
    public String doLogin(User user, Model model){
        model.addAttribute("user",user);
        model.addAttribute("username",user.getUsername());
        model.addAttribute("userId",user.getUserId());
        model.addAttribute("password",user.getPassword());
        return "doLoginInternal";
    }*/
    /*@RequestMapping("/doLogin")
    public String doLogin(User user){
        return "baidu";
    }*/
    /*@RequestMapping("/doLogin")
    public void doLogin(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user",user);
        request.setAttribute("username",user.getUsername());
        request.setAttribute("userId",user.getUserId());
        request.setAttribute("password",user.getPassword());
        //请求转发
        request.getRequestDispatcher("/WEB-INF/jsp/user/doLogin.jsp").forward(request,response);
    }*/
   /* @RequestMapping("/doLogin")
    public void doLogin(User user, HttpServletResponse response) throws ServletException, IOException {
        //将数据存放到map中
        Map<String,Object> map = new HashMap<>();
        map.put("userId",user.getUserId());
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        //将map转为JSON
        JSONObject myJson = JSONObject.fromObject(map);
        String jsonString = myJson.toString();
        //将数据发送回客户端
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(jsonString);
        out.close();
    }*/
    /*@RequestMapping("/doLogin")
    @ResponseBody
    public Object doLogin(User user) {
        //模拟已经注册好的用户的集合信息
        loginedUsersList = initLoginedUsers();
        //处理用户注册信息
        int count = -1;
        for (int i = 0; i < loginedUsersList.size(); i++) {
            User u = loginedUsersList.get(i);
            if (u.getUserId() != user.getUserId()){
                count = loginedUsersList.size()+1;
                break;
            }
        }
        return count;
    }*/
    /*@RequestMapping(value = "/doLogin", produces = "text/html;charset=utf-8")
    @ResponseBody
    public Object doLogin(User user) {
        System.out.println(user.getUsername());
        return user.getUsername();
    }*/
    /*@RequestMapping(value = "/doLogin")
    @ResponseBody
    public Object doLogin(User user) {
        return user;
    }*/
    /*@RequestMapping("/doLogin")
    @ResponseBody
    public Object doLogin(User user) {
        //模拟已经注册好的用户的集合信息
        loginedUsersList = initLoginedUsers();
        //处理用户注册信息
        for (int i = 0; i < loginedUsersList.size(); i++) {
            User u = loginedUsersList.get(i);
            if (u.getUserId() != user.getUserId()){
                loginedUsersList.add(user);
                break;
            }
        }
        return loginedUsersList;
    }*/
    /*@RequestMapping("/doLogin")
    @ResponseBody
    public Object doLogin(User user) {
        //模拟已经注册好的用户的集合信息
        loginedUsersList = initLoginedUsers();
        //处理用户注册信息
        loginedUsersList.add(user);
        Map<String,User> map = new HashMap<>();
        for (int i = 0; i < loginedUsersList.size(); i++) {
            map.put("user"+(i+1),loginedUsersList.get(i));
        }
        return map;
    }*/

    private List<User> initLoginedUsers() {
        List<User> list = new ArrayList<>();

        User user1 = new User();
        user1.setUserId(1);
        user1.setUsername("tom");
        user1.setPassword("123456");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUsername("jack");
        user2.setPassword("123456");

        list.add(user1);
        list.add(user2);

        return list;
    }
}
