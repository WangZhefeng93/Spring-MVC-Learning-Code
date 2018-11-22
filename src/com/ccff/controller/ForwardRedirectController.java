package com.ccff.controller;

import com.ccff.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/ForwardRedirectTest")
public class ForwardRedirectController {
    /*@RequestMapping("/show")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("forward:/WEB-INF/jsp/user/login.jsp");
        return modelAndView;
    }*/
    /*@RequestMapping("/show")
    public String show(){
        System.out.println("show");
        return "forward:/WEB-INF/jsp/user/login.jsp";
    }*/
    @RequestMapping("/show")
    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(request,response);
    }

    @RequestMapping("/doLogin")
    public void doLogin(User user, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println("doLogin");
        session.setAttribute("user",user);
        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
    }
    /*@RequestMapping("/login")
    public String login(){
        System.out.println("login");
        return "user/login";
    }*/

    /*@RequestMapping("/checkLogin")
    public String checkLogin(User user, Model model){
        System.out.println("checkLogin");
        model.addAttribute("userId",user.getUserId());
        model.addAttribute("username",user.getUsername());
        model.addAttribute("password",user.getPassword());
        return "redirect:doLogin.action";
    }*/
    /*@RequestMapping("/checkLogin")
    public String checkLogin(User user, RedirectAttributes redirectAttributes){
        System.out.println("checkLogin");
        redirectAttributes.addFlashAttribute("user",user);
        return "redirect:doLogin.action";
    }*/

    /*@RequestMapping("/doLogin")
    public void doLogin(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doLogin");
        request.setAttribute("user",user);
        request.getRequestDispatcher("/WEB-INF/jsp/user/success.jsp").forward(request,response);
    }*/
    /*@RequestMapping("/doLogin")
    public String doLogin(User user, RedirectAttributes redirectAttributes) {
        System.out.println("doLogin");
        redirectAttributes.addAttribute("username",user.getUsername());
        redirectAttributes.addAttribute("userId",user.getUserId());
        redirectAttributes.addAttribute("password",user.getPassword());
        return "redirect:/welcome.jsp";
    }*/
    /*@RequestMapping("/doLogin")
    public String doLogin(User user, Model model) {
        model.addAttribute("username",user.getUsername());
        model.addAttribute("userId",user.getUserId());
        model.addAttribute("password",user.getPassword());
        return "redirect:/welcome.jsp";
    }*/
    /*@RequestMapping("/checkLogin")
    public ModelAndView checkLogin(User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userId",user.getUserId());
        modelAndView.addObject("username",user.getUsername());
        modelAndView.addObject("password",user.getPassword());
        modelAndView.setViewName("redirect:doLogin.action");
        return modelAndView;
    }*/
    /*@RequestMapping("/checkLogin")
    public ModelAndView checkLogin(User user, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        session.setAttribute("user",user);
        modelAndView.setViewName("redirect:doLogin.action");
        return modelAndView;
    }*/

    /*@RequestMapping("/doLogin")
    public ModelAndView doLogin(int userId, String username, String password) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView();
        username = new String(username.getBytes("iso8859-1"), "utf-8");
        modelAndView.addObject("username",username);
        modelAndView.addObject("userId",userId);
        modelAndView.addObject("password",password);
        modelAndView.setViewName("redirect:/welcome.jsp");
        return modelAndView;
    }*/
    /*@RequestMapping("/doLogin")
    public ModelAndView doLogin(User user) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.addObject("user",user);
        modelAndView.addObject("username",new String(user.getUsername().getBytes("iso8859-1"), "utf-8"));
        modelAndView.addObject("userId",user.getUserId());
        modelAndView.addObject("password",user.getPassword());
        modelAndView.setViewName("redirect:/welcome.jsp");
        return modelAndView;
    }*/
    /*@RequestMapping("/doLogin")
    public ModelAndView doLogin(User user, HttpSession session) {
        session.setAttribute("loginedUser",user);
        return new ModelAndView("redirect:/welcome.jsp");
    }*/
    /*@RequestMapping("/doLogin")
    public ModelAndView doLogin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        session.setAttribute("loginedUser",user);
        return new ModelAndView("redirect:/welcome.jsp");
    }*/
    /*@RequestMapping("/doLogin")
    public String doLogin(User user){
        return "forward:success.action";
    }*/

   /* @RequestMapping("/success")
    public String success(User user){
        return "forward:/WEB-INF/jsp/user/success.jsp";
    }*/
    /*@RequestMapping("/success")
    public String success(User user, Model model){
        model.addAttribute("user",user);
        return "user/success";
    }*/
}
