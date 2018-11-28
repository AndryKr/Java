/**
 * Java. Alg. Lesson 5. Homework
 *
 * @author Andry Krasikov
 * @version Nov 29, 2018
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exponentiation {
    public static void main(String[] args){
        int number = getByte("Введите целое число");
        int degree = getByte("Введите степень (целое число)");
        System.out.println(exponentiation(number,degree));
    }

    static int getByte(String message){
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (true){
            try {
                number = sc.nextByte();
                return number;
            } catch (InputMismatchException ex) {
                System.out.println("Некорректный ввод");
                sc.next();
            }
        }
    }

    public static double exponentiation(int number, int degree){

        if (degree == 0){
            return 1;
        } else if (degree == 1){
            return number;
        } else if (degree < 0) {
           return calculationMinusDegree(number,degree);
        } else {
            return number*exponentiation(number,degree-1);
        }
    }

    public static double calculationMinusDegree(int number, int degree){
        return (1/exponentiation(number, Math.abs(degree)));
    }

}
