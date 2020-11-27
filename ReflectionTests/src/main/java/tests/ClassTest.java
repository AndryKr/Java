package tests;

import services.annotations.AfterSuite;
import services.annotations.BeforeSuite;
import services.annotations.Test;

public class ClassTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Запуск метода с аннотацией BeforeSuite");
    }

    @Test
    public void testWithDefaultPriority() {
        System.out.println("Запуск теста с приоритетом по умолчанию");
    }

    @Test(priority = 1)
    public void testWithPriority1() {
        System.out.println("Запуск теста с приоритетом 1");
    }

    @Test(priority = 10)
    public void testWithPriority10() {
        System.out.println("Запуск теста с приоритетом 10");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Запуск метода с аннотацией AfterSuite");
    }

}
