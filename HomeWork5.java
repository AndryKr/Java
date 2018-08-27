/**
 * Java. Level 1. Lesson 5. Home work5
 *
 * @author Andry Krasikov
 * @version Aug 27, 2018
 */

class HomeWork5 {

    public static void main(String[] args) {
        Worker[] worker = new Worker[5];
        worker[0] = new Worker("Ivanov Ivan Ivanovich", "director", "ivanov@email.ru", "123-11-00", 1000000, 45);
        worker[1] = new Worker("Petrova Nina Petrovna", "designer", "petrova@email.ru", "123-11-01", 170000, 28);
        worker[2] = new Worker("Nikolaev Nikolay Nikolaevich", "engineer", "nikolaev@email.ru", "123-11-02", 210000, 41);
        worker[3] = new Worker("Semenov Semen Semenovich", "developer", "semenov@email.ru", "123-11-03", 200000, 27);
        worker[4] = new Worker("Andreeva Irina Andreevna", "secretary", "andreeva@email.ru", "123-11-04", 100000, 27);

        filter(worker);
    }

    static void filter(Worker[] worker) {
        for (int i = 0; i < worker.length; i++) {
            if (worker[i].age > 40)
                System.out.println(Worker.toString(worker[i]));
        }
    }
}

class Worker {
    private String fio;
    String position;
    String email;
    String phone_number;
    private int salary;
    int age;

    Worker(String fio, String position, String email, String phone_number, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone_number = phone_number;
        this.salary = salary;
        this.age = age;
    }

    int getSalary() {
        return salary;
    }

    String getFio() {
        return fio;
    }

    void setSalary(int salary) {
        if (salary != this.salary)
            salary = this.salary;
        this.salary = salary;
    }

    void setFio(String fio) {
        if (fio != this.fio)
            fio = this.fio;
        this.fio = fio;
    }

    static String toString(Worker worker) {
        return worker.fio + ", " + worker.position + ", " + worker.email + ", " + worker.phone_number + ", " + worker.salary + ", " + worker.age;
    }
}
