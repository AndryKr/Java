package doMain;

import dao.CrudMethodsImpl;
import models.Student;
import services.TxtUpdateDbImpl;

public class Main {

    public static void main(String[] args) {

        CrudMethodsImpl crudMethods = CrudMethodsImpl.getInstance();

//        Создаем таблицу в базе данных
        crudMethods.createTable("students");

//        Добавляем запись
        crudMethods.add(new Student("Bob1", 10));
        crudMethods.add(new Student("Bob2", 20));
        crudMethods.add(new Student("Bob3", 30));
        crudMethods.add(new Student("Petya", 100));

        System.out.println(crudMethods.getById(4).toString());

//        Удалить записть по id
        crudMethods.delete(4);

//        Запустить обновление базы данных из файла
//        TxtUpdateDbImpl.getInstance().txtUpdate();

//        Удалить таблицу из базы данных
//        crudMethods.dropTable("students");
    }
}
