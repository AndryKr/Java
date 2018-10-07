/**
 * Java. Level 2. Lesson 1. Home work
 *
 * @author Andry Krasikov
 * @version Oct 08, 2018
 */

package Lesson_1.Marathon;

public class Course {

    Obstacle[] obstacles = {new Cross(100), new Wall(5), new Water(20)};
    void doIt(Competitor[] competitors) {
        for (Competitor c : competitors) {
            for (Obstacle o : obstacles) {
                o.doit(c);
                if (!c.isOnDistance()) {
                    break;
                }
            }
        }
    }
}
