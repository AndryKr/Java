package services;

import dao.FruitDao;
import models.box.Box;
import models.fruit.Fruit;

public class BoxService {

    private static BoxService boxService;
    private BoxService() {}

    public static BoxService getInstance() {
        if (boxService == null)
            boxService = new BoxService();
        return boxService;
    }

    public double getWeight() {
        double weightBox = 0;
        for (Fruit fruit : FruitDao.getInstance().getFruits()) {
            weightBox += fruit.getWeight();
        }
        return weightBox;
    }
    public void moveToNewBox(Box box) {
        FruitDao.getInstance().getFruits().addAll(box.getFruits());
        box.getFruits().clear();
    }
}
