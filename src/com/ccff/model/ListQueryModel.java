package com.ccff.model;

import java.util.List;

public class ListQueryModel {
    private List<Fruits> fruitsList;
    private List<Integer> fruitsIdList;

    public List<Fruits> getFruitsList() {
        return fruitsList;
    }

    public void setFruitsList(List<Fruits> fruitsList) {
        this.fruitsList = fruitsList;
    }

    public List<Integer> getFruitsIdList() {
        return fruitsIdList;
    }

    public void setFruitsIdList(List<Integer> fruitsIdList) {
        this.fruitsIdList = fruitsIdList;
    }
}
