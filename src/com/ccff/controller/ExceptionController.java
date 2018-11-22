package com.ccff.controller;

import com.ccff.exception.PasswordLengthException;
import com.ccff.exception.UserIdBigZeroException;
import com.ccff.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ExceptionTest")
public class ExceptionController extends MyExceptionResolverController {
    @RequestMapping("/login")
    public String login(){
        return "exception/login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(User user) throws PasswordLengthException, UserIdBigZeroException {
        if ((Integer)user.getUserId() instanceof Integer && user.getUserId()<=0){
            throw new UserIdBigZeroException("user.id.must.big.zero");
        }
        if ("".equals(user.getUsername()) || "".equals(user.getPassword())){
            throw new NullPointerException("空指针异常");
        }else if (user.getPassword().length()<6 || user.getPassword().length()>12){
            throw new PasswordLengthException("密码长度异常");
        }
        return "exception/success";
    }
}
