/**
 * Java. Alg. Lesson 3. Homework
 *
 * @author Andry Krasikov
 * @version Nov 22, 2018
 */

public class StackImpl implements Stack {

    private char[] data;
    private int size;

    public StackImpl (int maxsize) {
        this.data = new char[maxsize];
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull(){
        return size == data.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void push(char value) {
        data[size++] = value;
    }

    @Override
    public char pop() {
        return data[--size];
    }

    @Override
    public char peek() {
        return data[size-1];
    }

}
