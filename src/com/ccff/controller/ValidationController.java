package com.ccff.controller;

import com.ccff.model.User;
import com.ccff.validator.UserValidationGroup1;
import com.ccff.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/ValidationTest")
public class ValidationController {
    @InitBinder
    public void initBinder(DataBinder binder){
        binder.setValidator(new UserValidator());
    }

    @RequestMapping("/login")
    public String login(){
        return "validation/login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(@Valid User user, BindingResult bindingResult, Model model) {
        //获取检验错误信息
        List<ObjectError> allErrors = null;
        if (bindingResult.hasErrors()){
            allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors){
                //输出错误信息
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("allErrors",allErrors);
            return "validation/error";
        }else {
            model.addAttribute("user",user);
            return "validation/success";
        }
    }
}
