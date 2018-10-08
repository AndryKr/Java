package Lesson_1.Marathon;

public class Course {

    private Obstacle[] obstacles;

    public Course (Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

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
