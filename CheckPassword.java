import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java. Level 2. Lesson 3. Home work
 *
 * @author Andry Krasikov
 * @version October 14, 2018
 */

public class CheckPassword {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(isValid(scanner.nextLine()));
    }

    static boolean isValid(String line) {
        if (line.length()>=8) {
            String pattern = "(.*[a-z]+.*[0-9]+.*[A-Z]+.*)|(.*[0-9]+.*[a-z]+.*[A-Z]+.*)" +
                    "|(.*[A-Z]+.*[0-9]+.*[a-z]+.*)|(.*[A-Z]+.*[a-z]+.*[0-9]+.*)|" +
                    "(.*[a-z]+.*[A-Z]+.*[0-9]+.*)|(.*[0-9]+.*[A-Z]+.*[a-z]+.*)";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);
            return m.matches();
        } else return false;
    }
}
