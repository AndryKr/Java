package services;

import services.annotations.AfterSuite;
import services.annotations.BeforeSuite;
import services.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestingService {

    public static void start(Class classInstance) {
        startTesting(classInstance);
    }

    public static void start(String className) throws ClassNotFoundException {
        startTesting(Class.forName(className));
    }

    private static void startTesting(Class classTest) throws RuntimeException {
        Object testInstance = null;
        Method beforeSuite = null;
        Method afterSuite = null;
        List<List<Method>> testMethodsListByPriority = new ArrayList<List<Method>>(10);

        try {
            testInstance = classTest.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            testMethodsListByPriority.add(new ArrayList<>());
        }

        Method[] methods = classTest.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuite != null)
                    throw new RuntimeException("Больше чем 1 метод с аннотацией BeforeSuite");
                beforeSuite = method;
            }

            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuite != null)
                    throw new RuntimeException("Больше чем 1 метод с аннотацией AfterSuite");
                afterSuite = method;
            }

            if (method.isAnnotationPresent(Test.class)) {
                int priority = method.getAnnotation(Test.class).priority();
                if ((priority > 0) && (priority <= 10))
                    testMethodsListByPriority.get(priority - 1).add(method);
            }
        }

        try {
            beforeSuite.invoke(testInstance);
            for (List<Method> methodsList : testMethodsListByPriority) {
                for (Method testMethod : methodsList) {
                    testMethod.invoke(testInstance);
                }
            }
            afterSuite.invoke(testInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
