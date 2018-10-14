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
        unifyNames(names);
    }

    static void writeToAL(String[] maleNames) {
        for (int i = 0; i < maleNames.length; i++) {
            names.add(maleNames[i]);
        }
    }

    static void unifyNames(ArrayList<String> maleNames) {
        for (int i = 0; i < maleNames.size(); i++) {
            for (int j = i+1; j < maleNames.size(); j++) {
            if (maleNames.get(i) == maleNames.get(j)) {
                maleNames.remove(j);
                break;
            }
        }
    }
        System.out.println(maleNames);
        System.out.println("Уникальных имён в списке " + maleNames.size());
    }
}


