package doMain;

import services.ServicesImpl;

public class Main {
    public static void main(String[] args) {

        String path = "src/resources/50byte.txt";
        ServicesImpl.getInstance().readFile(path);
        ServicesImpl.getInstance().joinFails();
    }
}
