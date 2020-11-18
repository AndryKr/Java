import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GetNewArrayExceptionTest {

    private static int[] array1;
    private static int keyElement;

    @Parameterized.Parameters
    public static Collection<Object[]> data1() {
        return Arrays.asList(new Object[][] {
                {new int[]{0, 2, 3, 3, 2, 1, 2, 8, 2},4},
                {new int[]{0, 2, 4, 3, 2, 1, 2, 8, 2},4}
        });
    }

    public GetNewArrayExceptionTest(int[] array1, int keyElement) {
        this.array1 = array1;
        this.keyElement = keyElement;
    }

    @Test(expected = RuntimeException.class)
    public void getNewArrayTest() {
        Service.getService().getNewArray(array1, keyElement);
    }
}
