/**
 * Java. Alg. Lesson 3. Homework
 *
 * @author Andry Krasikov
 * @version Nov 22, 2018
 */

public interface Deque{

    void insertRight(int value);
    void insertLeft(int value);

    int removeLeft();
    int removeRight();

    boolean isEmpty();
    boolean isFull();

    int getSize();
}
