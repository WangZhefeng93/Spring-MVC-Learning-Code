package com.ccff.service;

import com.ccff.model.Fruits;

import java.util.ArrayList;
import java.util.List;

public class FruitsServiceImpl implements FruitsService {
    public List<Fruits> fruitsList = null;

    /**
     * 初始化水果商品水果数据
     * @return
     */
    public List<Fruits> initFruitsData(){
        if (fruitsList == null){
            fruitsList = new ArrayList<Fruits>();

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
        }else {
            return fruitsList;
        }
    }

    /**
     * 获取所有水果商品数据
     * @return
     */
    @Override
    public List<Fruits> queryFruitsList() {
        initFruitsData();
        return fruitsList;
    }

    /**
     * 根据给出的水果商品的id查询获取该水果商品的详细信息
     * @param id
     * @return
     */
    @Override
    public Fruits queryFruitById(int id) {
        initFruitsData();
        for (Fruits fruits : fruitsList){
            if (fruits.getId() == id)
                return fruits;
        }
        return null;
    }

    /**
     * 根据给出的搜索条件构造Fruits实体类，搜索水果商品详细信息
     * @param fruits
     * @return
     */
    @Override
    public List<Fruits> queryFruitsByCondition(Fruits fruits) {
        initFruitsData();
        String name = fruits.getName();
        String area = fruits.getProducing_area();
        List<Fruits> queryList = new ArrayList<Fruits>();
        Fruits f;
        for (int i = 0; i < fruitsList.size(); i++) {
            f = fruitsList.get(i);
            //有一项符合条件就返回
            if ((!"".equals(name) && f.getName().contains(name)) ||
                    (!"".equals(area) && f.getProducing_area().contains(area)))
                queryList.add(f);
        }
        return queryList.size()>0?queryList:null;
    }
}
