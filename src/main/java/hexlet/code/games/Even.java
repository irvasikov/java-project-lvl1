package hexlet.code.games;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Even {
/*    public static void game(String name) {
        int[] numbers = createArrOfNumbers();
        String[] rightAnswers = createArrOfAnswers(numbers);

        for (var num: numbers) {
            System.out.println("Question: " + num);

            Scanner sc = new Scanner(System.in);
            String answer = sc.next();

            System.out.println("Your answer: " + answer);

            var rightAnswer = (isEven(num)) ? "yes" : "no";

            if (rightAnswer.equals(answer)) {
                System.out.println("Correct!");
            } else {
                return;
            }
        }

        System.out.println("Congratulations, " + name + "!");
    }*/

    public static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        }
        return false;
    }

    public static String[] getAnswers(String[] numbers) {
        String[] rightAnswers = new String[3];

        for (var i = 0; i < 3; i++) {
            var num = numbers[i];
            var rightAnswer = (isEven(Integer.parseInt(num))) ? "yes" : "no";
            rightAnswers[i] = rightAnswer;
        }

        return rightAnswers;
    }

    public static String[] getQuestions() {
        String[] numbers = new String[3];
        for (var i = 0; i < 3; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 100);
            numbers[i] = Integer.toString(randomNum);
        }
        return numbers;
    }
}
