package com.ccff.controller;

import com.ccff.model.Fruits;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//基于注解的Handler类
//使用@Controller来标识它是一个控制器
@Controller
@RequestMapping("/query")
public class FruitsController {

    private FruitsServiceTest fruitsService = new FruitsServiceTest();

    //@RequestMapping实现对方法和url进行映射，一个方法对应一个url
    //一般建议将url和方法写成一样的
    //获取水果商城的全部水果商品信息
    @RequestMapping("/queryAllFruits.action")
    public String queryAllFruits(Model model){
        //模拟service获取水果商品列表
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        //将结果放到model中传到显示页面中
        model.addAttribute("fruitsList",fruitsList);
        return "fruits/fruitsList";
    }

    //根据水果id查询水果信息
    @RequestMapping(value = "/queryFruitByID.action", method = RequestMethod.GET)
    public String queryFruitByID(Model model, @RequestParam(value = "fruit_id", defaultValue = "1") int fruitId){
        //模拟service获取水果商品列表
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        List<Fruits> resultFruit = new ArrayList<>();
        for (Fruits fruits : fruitsList){
            if (fruits.getId() == fruitId)
                resultFruit.add(fruits);
        }
        //将结果放到model中传到显示页面中
        model.addAttribute("resultFruit",resultFruit);
        return "fruits/resultFruitList";
    }

    //将水果信息作为JSON数据返回
    @RequestMapping("/queryJsonAllFruits.action")
    public void queryJsonAllFruits(HttpServletResponse response) throws IOException {
        //模拟service获取水果商品列表
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        //将fruitsList转换为JSON串
        String jsonInfo = converListToJson(fruitsList);
        //设置返回格式
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        //写出json串
        response.getWriter().write(jsonInfo);
    }

    //测试视图解析器ResourceBundleViewResolver
    @RequestMapping("/testResourceBundleViewResolver1.action")
    public String testResourceBundleViewResolver1(Model model){
        //模拟service获取水果商品列表
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        //将结果放到model中传到显示页面中
        model.addAttribute("fruitsList",fruitsList);
        return "aaa";
    }
    @RequestMapping("/testResourceBundleViewResolver2.action")
    public String testResourceBundleViewResolver2(Model model){
        //模拟service获取水果商品列表
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        //将结果放到model中传到显示页面中
        model.addAttribute("fruitsList",fruitsList);
        return "bbb";
    }

    @RequestMapping("/testFreeMarkerViewResolver.action")
    public String testFreeMarkerViewResolver(Model model){
        model.addAttribute("username","张三");
        return "freemarker";
    }

    //将集合转为JSON字符串的工具类
    private String converListToJson(List<Fruits> fruitsList) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (Fruits fruits:fruitsList){
            builder.append('{');
            builder.append("\"name\":\"").append(fruits.getName()).append("\",");
            builder.append("\"price\":\"").append(fruits.getPrice()).append("\",");
            builder.append("\"producing_area\":\"").append(fruits.getProducing_area()).append("\",");
            builder.append("},");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(']');
        return builder.toString();
    }

}

class FruitsServiceTest{
    public List<Fruits> queryFruitsList(){
        List<Fruits> fruitsList = new ArrayList<Fruits>();

        Fruits apple = new Fruits();
        apple.setId(1);
        apple.setName("红富士苹果");
        apple.setPrice(2.3);
        apple.setProducing_area("山东");

        Fruits banana = new Fruits();
        banana.setId(2);
        banana.setName("香蕉");
        banana.setPrice(1.5);
        banana.setProducing_area("上海");

        fruitsList.add(apple);
        fruitsList.add(banana);
        return fruitsList;
    }
}