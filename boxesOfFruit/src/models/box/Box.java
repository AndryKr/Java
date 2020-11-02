package models.box;

import models.fruit.Fruit;

import java.util.List;

public class Box<T extends Fruit> {

    private double weightBox;
    private List<T> fruits;

    public Box(double weightBox, List<T> fruits) {
        this.weightBox = weightBox;
        this.fruits = fruits;
    }

    public List<T> getFruits() {
        return fruits;
    }

    public double getWeightBox() {
        return weightBox;
    }

    public boolean compare(Box box) {
        if (BoxService.getInstance.getWeight() == box.getWeightBox()) {
            return true;
        } else
            return false;
   }
}
