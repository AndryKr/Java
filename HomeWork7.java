/**
 * Java. Level 1. Lesson 7. Home work
 *
 * @author Andry Krasikov
 * @version Sept 02, 2018
 */

class HomeWork7 {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Murka", 3, false), 
		new Cat("Barsik", 10, false), 
		new Cat("Murzik", 10, false), 
		new Cat("Boris", 4, false)};
        Plate plate = new Plate(15);
        System.out.println(plate);
		for(Cat cat: cats) {
			if(plate.getFood() >= cat.getAppetite()) {
				cat.eat(plate);
				cat.setSatiety(true);
				System.out.println(cat.getName() + ": " + cat.getSatiety());
			} else {
				System.out.println(cat.getName() + ": " + cat.getSatiety());
			}
		}
		System.out.println(plate);
		for(Cat cat: cats) {
			if(plate.getFood() < cat.getAppetite()) {
			plate.fill(5);
			System.out.println("подкинули 5 единиц еды, " + plate);
			}
			if(cat.getSatiety() == false) {
				cat.eat(plate);
				cat.setSatiety(true);
				System.out.println(cat.getName() + ": " + cat.getSatiety());
				System.out.println(plate);
			}	
		}
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
	
	void fill(int food) {
		this.food += food; 
	}

    @Override
    public String toString() {
        return "в тарелке " + food + " единиц еды";
    }
}
