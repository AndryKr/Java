package services;

import dao.CrudMethodsImpl;
import models.Student;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TxtUpdateDbImpl implements TxtUpdateDb {

    private static TxtUpdateDbImpl txtUpdateDb;

    private TxtUpdateDbImpl() {
    }

    public static TxtUpdateDbImpl getInstance() {
        if (txtUpdateDb == null)
            txtUpdateDb = new TxtUpdateDbImpl();
        return txtUpdateDb;
    }

    public void txtUpdate() {
        String fileName = "test.txt";
        Path path = Paths.get(fileName);

        Scanner scanner = null;
        try {
            scanner = new Scanner(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.useDelimiter("\n");

        while(scanner.hasNext()) {
            Student student = parseTxtLine(scanner.nextLine());
            CrudMethodsImpl.getInstance().updateBook(student);
        }

        scanner.close();
    }

    private static Student parseTxtLine(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(" ");
        int id = scanner.nextInt();
        String name = scanner.next();
        int score = scanner.nextInt();
        return new Student(id, name, score);
    }


}
