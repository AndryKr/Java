/**
 * Java. Alg. Lesson 2. Homework
 *
 * @author Andry Krasikov
 * @version Nov 26, 2018
 */

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main2 {

    public static void main(String[] args) {
        testArrayImpl();
    }

    public static void testArrayImpl() {

        ArrayImpl array1 = new ArrayImpl();
        Random random = new Random();

        for (int i = 0; i < array1.getCapacity(); i++) {
            array1.add(random.nextInt(1000));
        }

        ArrayImpl array2 = array1;
        ArrayImpl array3 = array1;

        long start = System.nanoTime();
        array1.sortBubble();
        long finish = System.nanoTime();
        System.out.println("Время сортировки пузырьком: " +
                TimeUnit.NANOSECONDS.toMillis(finish - start) + " мс");

        long start2 = System.nanoTime();
        array2.sortSelect();
        long finish2 = System.nanoTime();
        System.out.println("Время сортировки выбором: " +
                TimeUnit.NANOSECONDS.toMillis(finish2 - start2) + " мс");

        long start3 = System.nanoTime();
        array3.sortInsert();
        long finish3 = System.nanoTime();
        System.out.println("Время сортировки методом вставками: " +
                TimeUnit.NANOSECONDS.toMillis(finish3 - start3) + " мс");
    }
}