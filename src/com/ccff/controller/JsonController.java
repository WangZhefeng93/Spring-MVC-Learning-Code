package com.ccff.controller;

import com.ccff.model.Student;
import com.ccff.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/JsonTest")
public class JsonController {
    //创建该类的日志对象
    Log log = LogFactory.getLog(this.getClass());

    /**
     * 显示json信息页面
     * @return
     */
    @RequestMapping("/json")
    public String json(){
        return "json/json";
    }

    /**
     * 处理提交的json信息，并返回
     * @return {"studentName":"张三","password":"123456789"}
     */
    @RequestMapping("/doJson")
    public @ResponseBody Student doJson(@RequestBody Student student){
        System.out.println("studentInfo[name:"+student.getStudentName()+",password:"+student.getPassword()+"]");
        //@ResponseBody将User转成Json格式输出
        return student;
    }

    /**
     * 这样能直接将Student对象转成JSON格式并在页面该页面直接输出-----------------------
     *
     * @return
     */
    @RequestMapping("/testJson")
    public @ResponseBody Student testJson(){
        Student student = new Student("李兰村大粑粑","123123");
        return student;
    }
}
