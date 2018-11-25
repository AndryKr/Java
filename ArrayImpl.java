/**
 * Java. Alg. Lesson 2. Homework
 *
 * @author Andry Krasikov
 * @version Nov 26, 2018
 */

public class ArrayImpl implements Array {
    protected int[] data;
    protected int currentSize;

    private static int CAPACITY = 100000;

    public ArrayImpl() {
        this(CAPACITY);
    }

    public ArrayImpl(int maxSize) {
        this.data = new int[maxSize];
    }

    @Override
    public void add(int value) {
        checkGrow();
        data[currentSize++] = value;
    }

    public static int getCapacity() {
        return CAPACITY;
    }

    void checkGrow() {
        if (currentSize == data.length) {
            int temp[] = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
    }

    @Override
    public boolean remove(int value) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i] == value) {
                data[i] = data[i - 1];
                currentSize--;
                break;
            }
        }
        return false;
    }

    @Override
    public boolean find(int value) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < currentSize - 1; i++) {
            for (int j = 0; j < currentSize - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    exchange(j, j + 1);
                }
            }
        }
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < currentSize - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < currentSize; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            exchange(i, minIndex);
        }
    }

    @Override
    public void sortInsert() {
        int in, out;
        for (out = 1; out < currentSize; out++) {
            int temp = data[out];
            in = out;
            while (in > 0 && data[in - 1] >= temp) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }

    private void exchange(int left, int right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (int i = 0; i < currentSize; i++) {
            stringBuilder.append(data[i] + " ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
