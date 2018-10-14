/**
 * Java. Level 2. Lesson 3. Home work
 *
 * @author Andry Krasikov
 * @version October 14, 2018
 */

import java.util.ArrayList;

class MaleNames {

    static String maleNames[] = {"Василий", "Кирилл", "Степан", "Александр", "Вячеслав", "Василий", "Вячеслав",
            "Фёдор", "Кирилл", "Филипп", "Иван", "Степан"};
    static ArrayList<String> names = new ArrayList<>();


    public static void main(String[] args) {
        writeToAL(maleNames);
        infoNames(names);
    }

    static void writeToAL(String[] maleNames) {
        for (int i = 0; i < maleNames.length; i++) {
            names.add(maleNames[i]);
        }
    }
    static void infoNames(ArrayList<String> maleNames) {
        for (int i = 0, k = 1; i < maleNames.size(); i++, k = 1) {
            for (int j = i+1; j < maleNames.size(); j++) {
                if (maleNames.get(i) == maleNames.get(j)) {
                    k++;
                    maleNames.remove(j);
                }
            }
            System.out.println("Имя " + maleNames.get(i) + " встречается " + k + " раз(а).");
        }
        System.out.println("\nСписок унакальных имён\n" + maleNames);
        System.out.println("Уникальных имён в списке " + maleNames.size());
    }
}


