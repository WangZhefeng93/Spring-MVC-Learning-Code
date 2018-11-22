package com.ccff.controller;

import com.ccff.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/convert")
public class ConvertController {

    @RequestMapping("/convertTest")
    public String convertTest(){
        return "user/convertTest";
    }

    @RequestMapping("/doConvertTest")
    public String doConvertTest(User user, Model model){
        model.addAttribute("user",user);
        System.out.println(user.getLoginDate());
        return "user/doConvertTest";
    }

}
