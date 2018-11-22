package com.ccff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping(value = "/getFruits", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public void addFruit(int id, Model model){
        //implements omitted
    }
}
