package hexlet.code;

import hexlet.code.games.Calculate;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class Engine {
    public static void createGame() {
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit""");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        System.out.println("Your choice: " + choice);

        /*greetOrNotGreet(choice, "");*/

        if (choice != 0 && choice != 1) {
            greeting1();
            var name = getNameFromUser();
            greeting2(name);
            gameLogic(choice, name);
        } else if (choice == 1) {
            greeting1();
            var name = getNameFromUser();
            greeting2(name);
        }
    }

/*    public static void greetOrNotGreet(int choice, String name) {
        if (choice != 0 && choice != 1) {
            if (name.equals("")) {
                name = greeting();
            }
            gameLogic(choice, name);
        } else if (choice == 1) {
            if (name.equals("")) {
                name = greeting();
            }
            Scanner sc = new Scanner(System.in);
            int newChoice = sc.nextInt();
            greetOrNotGreet(newChoice, name);
        }
    }*/

    public static void gameLogic(int choice, String name) {
        final var rounds = 3;
        var questions = new String[rounds];
        var answers = new String[rounds];

        final var even = 2;
        final var calc = 3;
        final var gcd = 4;
        final var progression = 5;
        final var prime = 6;

        switch (choice) {
            case even:
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                questions = Even.getQuestions();
                answers = Even.getAnswers(questions);
                break;
            case calc:
                System.out.println("What is the result of the expression?");
                questions = Calculate.getQuestions();
                answers = Calculate.getAnswers(questions);
                break;
            case gcd:
                System.out.println("Find the greatest common divisor of given numbers.");
                questions = GCD.getQuestions();
                answers = GCD.getAnswers(questions);
                break;
            case progression:
                System.out.println("What number is missing in the progression?");
                questions = Progression.getQuestions();
                answers = Progression.getAnswers(questions);
                break;
            case prime:
                System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
                questions = Prime.getQuestions();
                answers = Prime.getAnswers(questions);
                break;
            default:
                System.out.println("answer");
        }

        for (var i = 0; i < rounds; i++) {
            var q = questions[i];
            var rightAnswer = answers[i];
            System.out.println("Question: " + q);

            Scanner sc = new Scanner(System.in);
            String answer = sc.next();

            System.out.println("Your answer: " + answer);

            if (rightAnswer.equals(answer)) {
                System.out.println("Correct!");
            } else {
                /*'yes' is wrong answer ;(. Correct answer was 'no'.
                        Let's try again, Bill!*/
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", answer, rightAnswer);
                System.out.printf("Let's try again, %s!", name);
                return;
            }
        }

        System.out.println("Congratulations, " + name + "!");
    }

    public static void greeting1() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
    }

    public static void greeting2(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static String getNameFromUser() {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        return name;
    }
}
/*
1 - Greet
        2 - Even
        3 - Calc
        4 - GCD
        5 - Progression
        6 - Prime
        0 - Exit*/
