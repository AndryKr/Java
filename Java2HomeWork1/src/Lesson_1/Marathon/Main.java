/**
 * Java. Level 2. Lesson 1. Home work
 *
 * @author Andry Krasikov
 * @version Oct 08, 2018
 */

package Lesson_1.Marathon;

public class Main {

    public static void main(String[] args) {
         Course c = new Course();
         Team team = new Team("Friends");
         c.doIt(team.competitors);
         team.showResults();
    }
}
