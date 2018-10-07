package Lesson_1.Marathon;

public class Team {

    private String teamName;
    private String catName;
    private String name;
    private String dogName;
    private String fishName;
   Competitor[] competitors = {new Human(name), new Cat(catName), new Dog(dogName), new Fish(fishName)};;

    public Team (String teamName, String name, String catName, String dogName, String fishName) {
        this.teamName = teamName;
        this.catName = catName;
        this.name = name;
        this.dogName = dogName;
        this.fishName = fishName;
    }


        void showResults () {
            System.out.println("\nРезультаты команды " + teamName + ":");
            for (Competitor c : competitors) {
                c.info();
            }
        }
}
