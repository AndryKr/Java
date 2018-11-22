public interface Deque{

    void insertRight(int value);
    void insertLeft(int value);

    int removeLeft();
    int removeRight();

    boolean isEmpty();
    boolean isFull();

    int getSize();
}
