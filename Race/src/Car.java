public class Car implements Runnable {

    private static int CARS_COUNT;
    private static boolean WINNER_IS_EXIST;

    static {
        CARS_COUNT = 0;
        WINNER_IS_EXIST = false;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            race.getCyclicBarrier().await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            if(!WINNER_IS_EXIST) {
                WINNER_IS_EXIST = true;
                System.out.println(this.name + " WIN!");
            }
            race.getCyclicBarrier().await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}