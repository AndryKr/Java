/**
 * Java. Alg. Lesson 3. Homework
 *
 * @author Andry Krasikov
 * @version Nov 22, 2018
 */

public interface Queue {

    void insert(int value);
    int remove();

    boolean isEmpty();
    boolean isFull();

    int getSize();
}