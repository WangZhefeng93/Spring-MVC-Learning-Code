package com.ccff.controller;

import com.ccff.model.Fruits;
import com.ccff.model.ListQueryModel;
import com.ccff.model.MapQueryModel;
import com.ccff.service.FruitsService;
import com.ccff.service.FruitsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/collectionTest")
public class CollectionController {

    private FruitsService fruitsService = new FruitsServiceImpl();

    @RequestMapping("/showPage")
    public String showPage(Model model){
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        model.addAttribute("fruitsList",fruitsList);
        return "fruits/collectionParamTest";
    }

    @RequestMapping("/showParam")
    public void showParam(Integer[] fruitsIdArray, HttpServletResponse response) throws IOException {
        for (int i = 0; i < fruitsIdArray.length; i++) {
            System.out.println("fruitsIdArray["+i+"] = "+fruitsIdArray[i]);
            response.getWriter().write("fruitsIdArray["+i+"] = "+fruitsIdArray[i]+"\n");
        }
    }

    @RequestMapping("/showListParam")
    public void showListParam(ListQueryModel listQueryModel, HttpServletResponse response) throws IOException {
        List<Fruits> list = listQueryModel.getFruitsList();
        //这句话的意思，是让浏览器用utf8来解析返回的数据
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
        response.setCharacterEncoding("UTF-8");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("水果商品名称："+list.get(i).getName());
            response.getWriter().write("水果商品名称："+list.get(i).getName()+"<br>");
        }
    }

    @RequestMapping("/showBasicListParam")
    public void showBasicListParam(ListQueryModel listQueryModel, HttpServletResponse response) throws IOException {
        List<Integer> list = listQueryModel.getFruitsIdList();
        //这句话的意思，是让浏览器用utf8来解析返回的数据
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
        response.setCharacterEncoding("UTF-8");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("水果商品ID："+list.get(i));
            response.getWriter().write("水果商品ID："+list.get(i)+"<br>");
        }
    }

    @RequestMapping("/showMapParam")
    public void showMapParam(MapQueryModel mapQueryModel, HttpServletResponse response) throws IOException {
        Map<String,Object> map = mapQueryModel.getFruitsMap();
        //这句话的意思，是让浏览器用utf8来解析返回的数据
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
        response.setCharacterEncoding("UTF-8");
        for (String key : map.keySet()){
            String string = "fruitsMap["+key+"] = "+map.get(key);
            response.getWriter().write(string+"<br/>");
        }
    }

}
