/**
 * Java. Level 1. Lesson 7. Home work
 *
 * @author Andry Krasikov
 * @version Sept 02, 2018
 */

class HomeWork7 {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Murka", 3, false), new Cat("Barsik", 8, false), new Cat("Murzik", 5, false), new Cat("Boris", 3, false)};
        Plate plate = new Plate(15);
        System.out.println(plate);
		for(Cat cat: cats) {
			if(plate.getFood() >= cat.getAppetite()) {
				cat.eat(plate);
				cat.setSatiety(true);
				System.out.println(cat.getName() + ": " + cat.getSatiety());
			} else {
				System.out.println(cat.getName() + ": " + cat.getSatiety());
				//break;
			}
		}
		System.out.println(plate);
		plate.fill(15);
		System.out.println(plate);
		for(Cat cat: cats) {
			if(cat.getSatiety() == false && plate.getFood() >= cat.getAppetite()) {
				cat.eat(plate);
				cat.setSatiety(true);
				System.out.println(cat.getName() + ": " + cat.getSatiety());
			}
		}
		System.out.println(plate);
		//System.out.println(plate + "\nMurka: " + cats[0].getSatiety() +  ", Barsik: " + cats[1].getSatiety() + ", Murzik: " + cats[2].getSatiety() + ", Boris: " + cats[3].getSatiety());
    }
}

class Cat {
    private String name;
    private int appetite;
	private boolean satiety;

    Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
		this.satiety = satiety;
    }

    void eat(Plate plate) {
        plate.dicreaseFood(appetite);
    }
	
	int getAppetite() {
		return appetite;
	}
	
	void setSatiety(boolean satiety) {
		this.satiety = satiety;
	} 
	
	boolean getSatiety() {
		return satiety;
	}
	
	String getName() {
		return name;
	}
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    void dicreaseFood(int appetite) {
        this.food -= appetite;
    }
	
	int getFood() {
		return food;
	}
	
	void fill(int plate) {
		this.food = plate; 
		//return this.food;
	}

    @Override
    public String toString() {
        return "Food: " + food;
    }
}
