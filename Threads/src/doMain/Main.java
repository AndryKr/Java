package doMain;

import Services.MfpService;
import Services.ThreadsService;

public class Main {

    public static void main(String[] args) {

        //Запускать либо Task1 либо Task2

        //Task1
        ThreadsService.getInstance().createThreads();

        //Task2
        MfpService.getInstance().startThreads();
    }


}
