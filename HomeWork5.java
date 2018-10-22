/**
 * Java. Level 2. Lesson 5. Homework
 *
 * @author Andry Krasikov
 * @version Oct 22, 2018
 */

import java.util.Arrays;

class HomeWork5 {

    static final int size = 10000000;
    static final int coinThreads = 20;
    static final int h = size / coinThreads;

    public static void main(String[] args) {
        HomeWork5 hw5 = new HomeWork5();
        hw5.doIt();
        hw5.doItThreads();
    }

    void doIt() {
        float[] arr = new float[size];

        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++)
            arr[i] = (float)(arr[i] *
                    Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        System.out.println("Потрачено времени на выполненике в одном потоке "
                + (System.currentTimeMillis() - a));
    }

    void doItThreads() {
        float[] arr = new float[size];
        float[][] ah = new float[coinThreads][h];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();

        Thread[] t = new Thread[coinThreads];

        for (int i = 0; i < coinThreads; i++) {
            System.arraycopy(arr, h*i, ah[i], 0, h);
            t[i] = new Thread(new CalcCellValue(ah[i], h*i));
            t[i].start();

        }

//        try {
//            for (int i = 0; i < coinThreads; i++) {
//            t[i].join();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        for (int i = 0; i < coinThreads; i++) {
            System.arraycopy(ah[i], 0, arr, h*i, h);
        }
        System.out.println("Потрачено времени на выполненике в " + coinThreads + " потоках "
                + (System.currentTimeMillis() - a));
    }

    class CalcCellValue implements Runnable {
        private float[] array;
        private int shift;

        CalcCellValue(float[] array, int shift) {
            this.array = array;
            this.shift = shift;
        }

        @Override
        public void run() {
            for (int i = 0; i < array.length; i++)
                array[i] = (float)(array[i] *
                        Math.sin(0.2f + (i + shift) / 5) *
                        Math.cos(0.2f + (i + shift) / 5) *
                        Math.cos(0.4f + (i + shift) / 2));
        }
    }
}
