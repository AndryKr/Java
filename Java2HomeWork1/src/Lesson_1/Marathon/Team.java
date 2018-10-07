/**
 * Java. Level 2. Lesson 1. Home work
 *
 * @author Andry Krasikov
 * @version Oct 08, 2018
 */

package Lesson_1.Marathon;

public class Team {

   private String teamName;

   Competitor[] competitors = {new Human("Bob"), new Cat("Barsik"), new Dog("Bobick"), new Fish("Goldy")};;

    public Team (String teamName) {
        this.teamName = teamName;
    }

    void showResults () {
        System.out.println("\nРезультаты команды " + teamName + ":");
        for (Competitor c : competitors) {
            c.info();
        }
    }
}
