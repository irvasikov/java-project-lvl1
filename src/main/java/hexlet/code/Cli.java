package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("Hello, " + name + "!");
    }

    public static void meet() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n" +
                "0 - Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        System.out.println("Your choice: " + choice);
        if (choice == 1) {
            greeting();
        }
    }
}
