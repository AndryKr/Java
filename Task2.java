import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {

    public static <T> List<T> arrToList(T[] arr) {
        List<T> res = new ArrayList<>();
        res.addAll(Arrays.asList(arr));
        return res;
    }
}
