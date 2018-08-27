/**
 * Java. Level 1. Lesson 3. Home work
 *
 * @author Andry Krasikov
 * @version Aug 19, 2018
 */

import java.util.Random;
import java.util.Scanner;

public class HomeWork3_1 {
    public static void main(String[] args) {
        riddle();
    }

    public static void riddle () {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int digit = rand.nextInt(10);
        System.out.println("Попытайтесь угадать целое число в пределах от 0 до 9 за 3 попытки.");
        if (scanner.hasNextInt()) {
            for (int i = 0; i < 3; i++) {
                int answer = scanner.nextInt();
                if (answer >= 0 && answer < 10) {
                    if (digit == answer) {
                        System.out.printf("Поздравляем! Вы угадали, компьютер загодал число %d! \n", digit);
                        i = 3;
                    } else if (answer > digit) {
                        System.out.println("Загаданное число меньше.");
                    } else {
                        System.out.println("Загаданное число больше.");
                    }
                } else {
                    System.out.println("Некорректный ввод");
                }
            }
            replay();
            scanner.close();
        } else {
            System.out.println("Некорректный ввод");
            riddle ();
        }
    }

    public static void replay () {
        System.out.println("Попытки закончились. Повторить игру ещё раз? 1-да, 0-нет.");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int replay = scanner.nextInt();
            if (replay == 0) {
                System.out.println("Конец игры!");
            } else if (replay == 1) {
                riddle();
            } else {
                System.out.println("Некорректный ввод");
                replay();
            }
        } else {
            System.out.println("Некорректный ввод");
            replay();
        }
    }
}
