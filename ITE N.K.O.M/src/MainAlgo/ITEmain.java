package MainAlgo;

import java.io.IOException;

import ControllersUI.DataBase;

public class ITEmain {
    public static MainUI mainUI;
    public static void main(String[] args) throws IOException {
        new DataBase();
        mainUI=new MainUI();
    }
}
