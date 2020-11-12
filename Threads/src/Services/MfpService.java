package Services;

public class MfpService {

    private final int PERIOD = 50;

    private Object printer = new Object();
    private Object scanner = new Object();

    private static MfpService mfpService;

    private MfpService() {}

    public static MfpService getInstance() {
        if (mfpService == null)
            mfpService = new MfpService();
        return mfpService;
    }

    public void startThreads() {

        new Thread(() -> {print("Doc # 1 ", 3);}).start();

        new Thread(() -> {print("Doc # 2 ", 5);}).start();

        new Thread(() -> {scan("Doc # 3 ", 2);}).start();

        new Thread(() -> {scan("Doc # 4 ", 4);}).start();

        new Thread(() -> {copyPrint("Doc # 5 ", 3);}).start();
    }

    private void print(String docName, int count) {
        synchronized (printer) {
            System.out.println(docName + "sent to print.");
            try {
                for (int i = 1; i < count + 1; i++) {
                    System.out.println(docName + " printed " + i + " pages.");
                    Thread.sleep(PERIOD);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void scan(String docName, int count) {
        synchronized (scanner) {
            System.out.println(docName + "sent to scan.");
            try {
                for (int i = 1; i < count + 1; i++) {
                    System.out.println(docName + " scanned " + i + " pages.");
                    Thread.sleep(PERIOD);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void copyPrint (String docName, int count) {
        synchronized (scanner) {
            synchronized (printer) {
                System.out.println(docName + "sent to copyPrint.");
                try {
                    for (int i = 1; i < count + 1; i++) {
                        System.out.println(docName + " copyPrint " + i + " pages.");
                        Thread.sleep(PERIOD);
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
