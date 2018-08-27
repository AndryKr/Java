/**
 * Java. Level 1. Lesson 3. Home work
 *
 * @author Andry Krasikov
 * @version Aug 19, 2018
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork3_2 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        riddle();
    }

    public static void riddle() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Попытайтесь угадать слово, которое я загадал из списка ниже:\n");
        System.out.println(Arrays.toString(words));
        Random puzzle = new Random();
        int i = puzzle.nextInt(words.length);
        String answer;
        do {
            System.out.println("\nВведите слово:");
            answer = scanner.nextLine();
            if (answer.equals(words[i])) {
                System.out.println("Вы угадали!");
            } else {
                int shortText = Math.min(answer.length(), words[i].length());
                int x = 0;
                for (int j = 0; j < shortText; j++) {
                    if (answer.charAt(j) == words[i].charAt(j)) {
                        System.out.print(answer.charAt(j));
                        x++;
                    } else {
                        System.out.print("#");
                    }
                }
                for (int k = 0; k < 15 - shortText; k++) {
                    System.out.print("#");
                }
                System.out.printf("\nВ вашем слове есть %d совпадение(я) с загаданным словом\n", x);
                System.out.println("\nВведите слово и попробуйте угадать ещё раз");
            }
        } while (!answer.equals(words[i]));
        scanner.close();
        System.out.println(words[i]);
    }
}