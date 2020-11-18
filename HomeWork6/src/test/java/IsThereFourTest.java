import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IsThereFourTest {

    private static int[] array2;
    private static int[] keyArray;
    private static boolean result2;


    @Parameterized.Parameters
    public static Collection<Object[]> data2() {
        return Arrays.asList(new Object[][] {
                {new int[]{1, 4, 4, 4, 1}, new int[]{1, 4}, true},
                {new int[]{1, 2, 3, 5}, new int[]{1, 4}, false},
                {new int[]{4, 4, 4, 4}, new int[]{1, 4}, false},
                {new int[]{2, 2, 4, 5}, new int[]{1, 4}, false},
                {new int[]{2, 2, 7, 5}, new int[]{1, 4}, false}
        });
    }


    public IsThereFourTest(int[] array2, int[] keyArray, boolean result2) {
        this.array2 = array2;
        this.keyArray = keyArray;
        this.result2 = result2;
    }

    @Test
    public void isThereFourTest() {
        Assert.assertSame(Service.getService().isThereFour(array2, keyArray), result2);
    }
}
