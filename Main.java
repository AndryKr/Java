package Lesson_1.Marathon;

public class Main {

    public static void main(String[] args) {
         Course c = new Course(new Obstacle[] {
                 new Cross(100),
                 new Wall(5),
                 new Water(20)});
         Team team = new Team("Friends", new Competitor[] {
                 new Human("Bob"),
                 new Cat("Barsik"),
                 new Dog("Bobick"),
                 new Fish("Goldy")});
         c.doIt(team.getCompetitors());
         team.showResults();
    }
}
