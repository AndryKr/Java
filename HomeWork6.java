/**
 * Java. Level 1. Lesson 6. Home work
 *
 * @author Andry Krasikov
 * @version Aug 31, 2018
 */

class HomeWork6 {
	
	public static void main(String[] args) {
		IAnimal[] animals = {new Cat("Cat", 200, 2, 1), new Dog("Dog", 400, 10, 0.5), new Dachshund("Dachshund", 500, 12, 0.1), new Shepherd("Shepherd", 600, 9, 2)};
		for (IAnimal animal : animals)
			System.out.println(animal);
	}
	
}
 
interface IAnimal {
	abstract boolean run (double runing);
	abstract boolean swim (double swiming);
	abstract boolean jump (double jumping);
}

abstract class Animal implements IAnimal {
	String type;
	double runing;
    double swiming;
    double jumping;

    Animal(String type, double runing, double swiming, double jumping) {
		this.type = type;
        this.runing = runing;
        this.swiming = swiming;
        this.jumping = jumping;
    }
		
		@Override
    public String toString() {
        return type + " - run: " + run(runing) + ", swim: " + swim(swiming) + ", jump: " + jump(jumping);
    }
}

class Dog extends Animal {
	
	Dog(String type, double runing, double swiming, double jumping) {
        super(type, runing, swiming, jumping);
    }
	
	public boolean run (double runing) {
		return runing<=500;
	}

	public boolean swim (double swiming) {
		return swiming<=10;
	} 

	public boolean jump (double jumping) {
		return jumping<=0.5;
	}
	
}

class Dachshund extends Dog {
	
	Dachshund(String type, double runing, double swiming, double jumping) {
        super(type, runing, swiming, jumping);
    }
	
	@Override
	public boolean run (double runing) {
	return runing<=400;
	}
}

class Shepherd extends Dog {
	
	Shepherd(String type, double runing, double swiming, double jumping) {
        super(type, runing, swiming, jumping);
    }
	
	@Override
	public boolean run (double runing) {
	return runing<=600;
	}
}

class Cat extends Animal {

	Cat(String type, double runing, double swiming, double jumping) {
        super(type, runing, swiming, jumping);
    }
	
	public boolean run (double runing) {
		return runing<=200;
	}

	public final boolean swim (double swiming) {
		return false;
	} 

	public boolean jump (double jumping) {
		return jumping<=2;
	}
}