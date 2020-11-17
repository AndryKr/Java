public class Service {

    private static Service service;

    private Service() {}

    public static Service getService() {
        if (service == null)
            service = new Service();
        return service;
    }

    public int[] getArray(int[] array) {
        return array;
    }

    private boolean isThereFour(int[] array) {
        return true;
    }
}
