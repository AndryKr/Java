package Services;

public class ThreadsService {

    private static final int LETTERS_COUNT = 3;
    private static final int PRINT_COUNT = 5;
    private static final char FIRST_LETTER = 'A';
    private static final int NUMBER_OF_THREADS = 3;

    private final Object monitor = new Object();
    private volatile int currentIndex = 0;

    private static ThreadsService threadsService;

    private ThreadsService() {}

    public static ThreadsService getInstance() {
        if (threadsService == null)
            threadsService = new ThreadsService();
        return threadsService;
    }

    private void printChar(int counter) {
        synchronized (monitor) {
            try {
                for (int i = 0; i < PRINT_COUNT; i++) {
                    while (currentIndex != counter)
                        monitor.wait();
                    System.out.print((char)(FIRST_LETTER + counter));
                    currentIndex = (currentIndex + 1)%LETTERS_COUNT;
                    monitor.notifyAll();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void createThreads(){
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
           int counter = i;
           new Thread(() -> printChar(counter)).start();
      }
    }
}
