import java.util.Arrays;

public class Service {

    private static Service service;

    private Service() {}

    public static Service getService() {
        if (service == null)
            service = new Service();
        return service;
    }

    public int[] getNewArray(int[] array, int keyElement) {
        for (int i = array.length - 1; i >= 0; i--)
            if(array[i] == keyElement) {
                return Arrays.copyOfRange(array, i + 1, array.length);
            } else if (i == 0) {
                throw new RuntimeException("Во входящем массиве отсутствует " + keyElement);
            }
        return null;
    }

    public boolean isThereFour(int[] array, int[] arrayOfKeyElements) {
        boolean bool1 = false;
        boolean bool2 = false;
        for (int i = array.length - 1, j = 0; i >= 0; i--) {
            if(array[i] == arrayOfKeyElements[j]) {
                bool1 = true;
            }
            if (array[i] == arrayOfKeyElements[j + 1]) {
                bool2 = true;
            }
        }
        return bool1 && bool2;
    }
}
