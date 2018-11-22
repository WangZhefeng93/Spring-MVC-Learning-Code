package com.ccff.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PasswordLengthExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //1、解析出异常类型
        PasswordLengthException passwordLengthException = null;
        if (e instanceof PasswordLengthException){
            //2、如果该异常类型是自定义的PasswordLengthException异常，直接取出异常信息，在错误页面显示
            passwordLengthException = (PasswordLengthException) e;
        }else {
            //3、如果该异常类型不是自定义的PasswordLengthException异常，构造一个自定义的异常类型（信息为“未知错误”）
            passwordLengthException = new PasswordLengthException("未知错误");
        }
        //错误信息
        String message = passwordLengthException.getMessage();
        ModelAndView modelAndView = new ModelAndView();
        //将错误信息传到页面
        modelAndView.addObject("message",message);
        //指向到错误页面
        modelAndView.setViewName("/exception/passwordLengthError");
        return modelAndView;
    }
}
