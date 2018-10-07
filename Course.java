package Lesson_1.Marathon;

public class Course {

    private int crossLength;
    private int wallHeight;
    private int waterLength;

    public Course (int crossLength, int wallHeight, int waterLength) {
        this.crossLength = crossLength;
        this.wallHeight = wallHeight;
        this.waterLength = waterLength;
    }

    Obstacle[] obstacles = {new Cross(crossLength), new Wall(wallHeight), new Water(waterLength)};
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
