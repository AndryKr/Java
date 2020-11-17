import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class Race {

    private ArrayList<Stage> stages;

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(MainClass.CARS_COUNT+1);

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

}