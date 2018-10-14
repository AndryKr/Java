/**
 * Java. Level 2. Lesson 3. Home work
 *
 * @author Andry Krasikov
 * @version October 14, 2018
 */

import java.util.HashMap;
import java.util.Set;

public class PhoneBook {

    static HashMap<Integer, String> pb = new HashMap<>();

    public static void main(String[] args) {
        add(5459454,"Петров");
        add(5368980,"Петров");
        add(2384321,"Николаев");
        get("Петров");
    }

    static void add(Integer phoneNumber, String lastname)  {
        pb.put(phoneNumber, lastname);
    }
    static void get(String lastname) {
        Set<HashMap.Entry<Integer, String>> set = pb.entrySet();
        for (HashMap.Entry<Integer, String> me: set) {
            if (me.getValue().equalsIgnoreCase(lastname))
                System.out.println(me.getKey());
        }
    }
}
