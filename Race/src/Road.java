import java.util.concurrent.atomic.AtomicBoolean;

public class Road extends Stage {

    private boolean winnerIsExists;
    private AtomicBoolean winner;

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил гонку: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}