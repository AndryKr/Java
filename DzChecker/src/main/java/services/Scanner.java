package services;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;

public class Scanner {

    private static Scanner scanner;

    private Scanner() {
    }

    public static Scanner getInstance() {
        if (scanner == null)
            scanner = new Scanner();
        return scanner;
    }

    public void findClass(String path) {
        File file = new File(path);
        String[] fileList = file.list();
        if (fileList != null) {
            for (String fileName : fileList) {
                try {
                    getMethods(URLClassLoader.newInstance(new URL[]{file.toURL()}).loadClass(fileName));
                } catch (ClassNotFoundException | MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void getMethods(Class foundClass) {
        List<Method> methods = Arrays.asList(foundClass.getDeclaredMethods());
        methods.removeIf(method -> method.getReturnType().equals(Void.TYPE));
        checkMethods(methods, foundClass);
    }

    private void checkMethods(List<Method> methods, Class foundClass) {
        Constructor constructor;
        Object object = null;
        try {
            constructor = foundClass.getConstructor();
            object = constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        for (Method method : methods) {
            try {
                method.invoke(object);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
