/**
 * Java. Alg. Lesson 3. Homework
 *
 * @author Andry Krasikov
 * @version Nov 22, 2018
 */

public class Main3 {

    public static void main(String[] args) {
        testStack();
        testBrackets();
        readString();
        testQueue();
        testDeque();
    }

    public static void readString() {
        ReversString reversStr = new ReversString("Hello, World!");
        reversStr.revers();
    }

    public static void testBrackets() {
        Brackets brackets = new Brackets("public char peek() {return data[size-1];}");
        brackets.check();
    }

    public static void testStack() {
        Stack stack = new StackImpl(6);
        stack.push('p');
        stack.push('e');
        stack.push('o');
        stack.push('p');
        stack.push('l');
        stack.push('e');

        System.out.println("Top stack is " + stack.peek());
        System.out.println("Read stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.print("\n");
    }

    private static void testQueue() {
        Queue queue = new QueueImpl(5);
        addToQueue(queue, 1);
        addToQueue(queue, 2);
        addToQueue(queue, 3);
        addToQueue(queue, 4);
        addToQueue(queue, 5);

        removeQueue(queue);
        removeQueue(queue);

        addToQueue(queue, 6);
        addToQueue(queue, 7);

        while ( !queue.isEmpty() ) {
            System.out.println(queue.remove());
        }

    }

    private static void removeQueue(Queue queue) {
        if ( !queue.isEmpty() ) {
            queue.remove();
        }
    }

    private static void addToQueue(Queue queue, int value) {
        if ( !queue.isFull() ) {
            queue.insert(value);
        }
    }

    private static void testDeque() {
        Deque dequeue = new DequeImpl(5);
        dequeue.insertRight(1);
        dequeue.insertRight(2);
        dequeue.insertRight(4);
        dequeue.insertRight(6);
        dequeue.insertRight(9);
        dequeue.removeRight();
        dequeue.removeLeft();
        dequeue.insertRight(8);
        dequeue.insertLeft(0);
        System.out.println("\nТест Deque");
        while ( !dequeue.isEmpty() ) {
            System.out.println(dequeue.removeLeft());
        }
    }
}

