/**
 * Java. Level 2. Lesson 2. Home work
 *
 * @author Andry Krasikov
 * @version October 11, 2018
 */

public enum DayOfWeek {
    SUNDAY("Воскресенье", 0), MONDAY("Понедельник", 8), TUESDAY("Вторник", 8), WEDNESDAY("Среда",8),
    THURSDAY("Четверг", 8), FRIDAY("Пятница", 8), SATURDAY("Суббота", 0);

    public String getRus() {
        return rus;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    private int workingHours;
    private String rus;

    DayOfWeek(String rus, int workingHours) {
        this.rus = rus;
        this.workingHours = workingHours;
    }
}

class DayOfWeekMain {
    public static void main(final String[] args) {
        int hours;
        for (DayOfWeek d: DayOfWeek.values()) {
                if (d.getWorkingHours() == 0) {
                    System.out.println(d.getRus() + " - сегодня выходной.");
                } else {
                    hours = 48 - d.ordinal()*d.getWorkingHours();
                    System.out.println(d.getRus() + " - осталось " + hours + "ч до конца рабочей недели.");
                }
        }
    }
}


