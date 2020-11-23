package doMain;

import services.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "";
        Scanner.getInstance().findClass(path);
    }
}
