public interface Stack {

    boolean isEmpty();
    boolean isFull();

    int getSize();

    void push(char value);

    char pop();

    char peek();

}
