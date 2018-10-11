/**
 * Java. Level 2. Lesson 2. Home work
 *
 * @author Andry Krasikov
 * @version October 11, 2018
 */

public class Exceptions {
    static int size = 4;
    static String[][] mass = {{"13144", "16564", "13545", "154315"},
            {"2475", "123545", "1643", "153543"},
            {"162727", "46564a64", "12345345", "14535"},
            {"1665636", "15445636", "16562", "146134"}};

    public static void main(String[] args) {
        try {
            arr(mass);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    static int arr(String[][] mass) throws MyArrayDataException, MyArraySizeException {

        int result = 0;
        if (mass == null || mass.length != size)
            throw new MyArraySizeException("Количество строк не совпадает.");

        for (int i = 0; i < mass.length; i++) {
            if (mass[i] == null || mass[i].length != size)
                throw new MyArraySizeException("Количество ячеек в строке " + (i + 1) + " не совпадает");

            for (int j = 0; j < mass[i].length; j++) {
                try {
                    result += Integer.parseInt(mass[i][j]);
                } catch (MyArrayDataException e) {
                    throw new MyArrayDataException("Не верный символ(ы) в строке " + (i + 1) + "ячейке" + (j + 1));
                }
            }
        }
        return result;
    }
}

class MyArraySizeException extends Exception {

    public MyArraySizeException(String msg) {
        super(msg);
    }
}

class MyArrayDataException extends Exception {

    public MyArrayDataException(String msg) {
        super(msg);
    }
}