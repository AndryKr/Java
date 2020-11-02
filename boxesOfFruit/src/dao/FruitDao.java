package dao;

import models.fruit.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitDao {

    private static FruitDao fruitDao;
    private FruitDao() {}

    public static FruitDao getInstance() {
        if (fruitDao == null)
            fruitDao = new FruitDao();
        return fruitDao;
    }

    private List<Fruit> fruits = new ArrayList<>();



    public List<Fruit> getFruits() {
        return fruits;
    }

    public void add(Fruit fruit) {
        fruits.add(fruit);
    }
}
