/**
 * Java. Alg. Lesson 3. Homework
 *
 * @author Andry Krasikov
 * @version Nov 22, 2018
 */

public interface Stack {

    boolean isEmpty();
    boolean isFull();

    int getSize();

    void push(char value);

    char pop();

    char peek();

}
