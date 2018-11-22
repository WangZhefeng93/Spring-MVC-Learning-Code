package com.ccff.controller;

import com.ccff.model.Fruits;
import com.ccff.model.UserAndProductModel;
import com.ccff.service.FruitsService;
import com.ccff.service.FruitsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/query")
public class UserAndFruitsController {
    private FruitsService fruitsService = new FruitsServiceImpl();

    @RequestMapping("/queryUserAndFruitsByCondition")
    public String queryUserAndFruitsByCondition(Model model, UserAndProductModel userAndProductModel){
        List<Fruits> findList = null;
        if (userAndProductModel == null){
            findList = fruitsService.queryFruitsList();
        }else if (userAndProductModel.getUserFruits() == null || (userAndProductModel.getUserFruits().getName() == null && userAndProductModel.getUserFruits().getProducing_area() == null)){
            //如果fruits或查询条件为空，默认查询所有数据
            findList = fruitsService.queryFruitsList();
        }else {
            //如果fruits查询条件不为空，按条件查询
            findList = fruitsService.queryFruitsByCondition(userAndProductModel.getUserFruits());
        }
        //将model数据传到页面
        model.addAttribute("findList",findList);
        return "fruits/findFruits";
    }
}
