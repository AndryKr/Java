public class DequeImpl implements Deque{
    //public static final int DEFAULT_FRONT = 0;
   // public static final int DEFAULT_REAR = -1;

    private int[] data;
    private int size;
    private int maxSize;
    private int front;
    private int rear;

    public DequeImpl(int maxSize) {
        this.data = new int[maxSize];
        this.maxSize = maxSize;
        front = 0;
        this.rear = maxSize - 1;
    }

    @Override
    public void insertRight(int value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }

        data[++rear] = value;
        size++;
    }

    @Override
    public void insertLeft(int value) {
        if (front == 0)
            front = maxSize;
        data[--front] = value;
        size++;
    }

    @Override
    public int removeLeft() {
        int temp = data[front++];

        if (front == maxSize) {
            front = -1;
        }

        size--;
        return temp;
    }

    @Override
    public int removeRight() {
        int temp = data[rear--];
        if (rear < 0)
            rear = maxSize - 1;
        size--;
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public int getSize() {
        return size;
    }
}
