package Lesson_1.Marathon;

public class Main {

    public static void main(String[] args) {
         Course c = new Course(100, 5, 20); // Создаем полосу препятствий
         Team team = new Team("Friends", "Bob", "Barsik", "Bobick", "Goldy"); // Создаем команду
         c.doIt(team.competitors); // Просим команду пройти полосу
         team.showResults(); // Показываем результаты
    }
}
