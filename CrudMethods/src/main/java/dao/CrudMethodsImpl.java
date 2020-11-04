package dao;

import models.Student;
import services.ConnectionService;

import java.sql.*;

public class CrudMethodsImpl extends ConnectionService implements CrudMethods {

    private Connection connection = getConnect();

    private static CrudMethodsImpl crudMethods;

    private CrudMethodsImpl() {
    }

    public static CrudMethodsImpl getInstance() {
        if (crudMethods == null)
            crudMethods = new CrudMethodsImpl();
        return crudMethods;
    }


    public void createTable(String tableName) {
        String sql = "CREATE TABLE " + tableName + " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, score TEXT)";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void add(Student student) {
        String sql = "INSERT INTO students (name, score) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getScore());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateBook(Student student) {
        String sql = "UPDATE students SET name=?, score=? WHERE id=?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getScore());
            preparedStatement.setInt(3, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Student getById(int id) {
        String sql = "SELECT * FROM students WHERE id=?";
        Student student = new Student(0, null, null);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                student.setName(resultSet.getString("name"));
                student.setScore(resultSet.getInt("score"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    public void delete(int id) {
        String sql = "DELETE FROM students WHERE ID=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void dropTable(String tableName) {
        String sql = "DROP TABLE " + tableName;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
