import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GetNewArrayTest {

    private static int[] array1;
    private static int keyElement;
    private static int[] result1;

    @Parameterized.Parameters
    public static Collection<Object[]> data1() {
        return Arrays.asList(new Object[][] {
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7},4, new int[]{1, 7}},
                {new int[]{1, 2, 4, 4, 2, 4, 2, 8, 5},4, new int[]{2, 8, 5}},
                {new int[]{1, 2, 3, 3, 2, 1, 2, 8, 4},4, new int[]{}},
                {new int[]{4, 2, 3, 3, 2, 1, 2, 8, 2},4, new int[]{2, 3, 3, 2, 1, 2, 8, 2}}
        });
    }

    public GetNewArrayTest(int[] array1, int keyElement, int[] result1) {
        this.array1 = array1;
        this.keyElement = keyElement;
        this.result1 = result1;
    }

    @Test
    public void getNewArrayTest() {
        Assert.assertArrayEquals(Service.getService().getNewArray(array1, keyElement), result1);
    }
}
