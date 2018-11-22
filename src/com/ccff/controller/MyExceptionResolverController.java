package com.ccff.controller;

import com.ccff.exception.UserIdBigZeroException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyExceptionResolverController {
    //用于处理用户编号异常的方法
    @ExceptionHandler(UserIdBigZeroException.class)
    public ModelAndView handleUserIdBigZeroException(Exception ex){
        ModelAndView modelAndView = new ModelAndView();
        String message = ((UserIdBigZeroException)ex).getMessage();
        modelAndView.addObject("message",message);
        modelAndView.setViewName("/exception/userIdBigZeroError");
        return modelAndView;
    }
}
