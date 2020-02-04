package main.java.com.task2.service;

import main.java.com.task2.model.Menu;

public class Executor {
    Menu consoleMenu = new Menu();
    LfuImplementation algorithms = new LfuImplementation();

    public void run(){
        consoleMenu.showMenu();
        algorithms.runLFU();
        algorithms.printCacheAfterLFU();
    }
}
