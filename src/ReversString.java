/**
 * Java. Alg. Lesson 3. Homework
 *
 * @author Andry Krasikov
 * @version Nov 22, 2018
 */

import java.util.Stack;

public class ReversString {

    private String str;

    public ReversString(String str) {
        this.str = str;
    }

    public void revers() {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println("\n");
    }
}
