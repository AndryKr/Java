/**
 * Java. Level 2. Lesson 3. Home work
 *
 * @author Andry Krasikov
 * @version October 14, 2018
 */

import java.util.HashMap;
import java.util.Map;

class MaleNamesMap {

    static String maleNames[] = {"Василий", "Кирилл", "Степан", "Александр", "Вячеслав", "Василий", "Вячеслав",
            "Фёдор", "Кирилл", "Филипп", "Иван", "Степан"};
    static Map<String, Integer> name = new HashMap<>();

    public static void main(String[] args) {
        infoNames(maleNames);
    }

    static void infoNames(String[] maleNames) {
        for (int i = 0; i < maleNames.length; i++) {
            Integer amount = name.get(maleNames[i]);
            name.put(maleNames[i], amount == null ? 1 : amount + 1);
        }
        System.out.println(name);
    }
}


