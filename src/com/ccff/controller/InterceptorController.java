package com.ccff.controller;

import com.ccff.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/InterceptorTest")
public class InterceptorController {
    @RequestMapping("/index")
    public String index(){
        return "interceptor/index";
    }

    @RequestMapping("/login")
    public String login(){
        return "interceptor/login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(Model model, HttpServletRequest request, User user){
        //检测账号密码，成功即登录成功
        boolean flag = checkUser(user);
        if (flag){
            //登录成功，将用户信息放入session中
            request.getSession().setAttribute("user",user);
        }else {
            //登录失败，返回登录界面，重新登录
            model.addAttribute("errorMsg","账号或密码错误！");
            model.addAttribute("user",user);
            return "interceptor/login";
        }
        return "interceptor/success";
    }

    @RequestMapping("/loginout")
    public String loginout(Model model, HttpServletRequest request){
        if (request.getSession().getAttribute("user") != null){
            //将用户信息从session中清除
            request.getSession().removeAttribute("user");
        }else {
            model.addAttribute("errorMsg","注销失败！用户已注销！");
        }
        return "interceptor/login";
    }

    private boolean checkUser(User user) {
        if (1 == user.getUserId() && "张三".equals(user.getUsername()) && "123456789".equals(user.getPassword()))
            return true;
        else
            return false;
    }
}
