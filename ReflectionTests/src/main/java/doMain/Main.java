package doMain;

import services.TestingService;
import tests.ClassTest;

public class Main {
    public static void main(String[] args) {
        TestingService.start(ClassTest.class);
    }
}
