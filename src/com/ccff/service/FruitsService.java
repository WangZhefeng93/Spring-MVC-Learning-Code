package com.ccff.service;

import com.ccff.model.Fruits;

import java.util.List;

public interface FruitsService {
    public List<Fruits> queryFruitsList();
    public Fruits queryFruitById(int id);
    public List<Fruits> queryFruitsByCondition(Fruits fruits);
}
