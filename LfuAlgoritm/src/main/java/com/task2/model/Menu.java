package main.java.com.task2.model;

import main.java.com.task2.dao.Database;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
    private Database database = new Database();
    public static LinkedList<Integer> listOfSelectedNews = new LinkedList<>();

    public void showMenu() {
        boolean closeLoop = true;
        while (closeLoop) {
            printNews();
            System.out.println("Show program CACHE enter -> cache ");
            System.out.println("Exit -> exit");
            String userChoose = chooseNews();
            if (userChoose.equals("exit") || userChoose.equals("Exit")) {
                System.exit(0);
            } else if (userChoose.equals("cache")) {
                closeLoop = false;
            } else {
                try {
                    if (Integer.parseInt(userChoose) <= 9) {
                        listOfSelectedNews.addLast(Integer.valueOf(userChoose));
                    } else {
                        System.out.println("\n\n----BAD NUMBER----\n" +
                                "----See better how much news today----\n\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\n\n----Please enter correct symbol----\n\n");
                }
            }
        }
        printListOfSelectedNews();
    }

    private void printNews() {
        ArrayList<News> newsList = database.getNewsList();
        newsList.forEach(a -> System.out.println(a.getNews()));
    }

    private String chooseNews() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Choose news what you want read or something else  :");
        return scanner.nextLine();
    }

    private void printListOfSelectedNews() {
        System.out.print("\n\nList number what choose user :");
        listOfSelectedNews.forEach(a -> System.out.print(a + ", "));
        System.out.println("\n");
    }
}
