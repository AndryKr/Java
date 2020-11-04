package dao;

import models.Student;

public interface CrudMethods {

    void createTable(String tableName);

    void add(Student student);

    void updateBook(Student student);

    Student getById(int id);

    void delete(int id);

    void dropTable(String tableName);
}
