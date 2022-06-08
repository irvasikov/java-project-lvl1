package hexlet.code.games;

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
        return number % 2 == 0;
    }

    public static String[] getAnswers(String[] numbers) {
        final var rounds = 3;
        String[] rightAnswers = new String[rounds];

        for (var i = 0; i < rounds; i++) {
            var num = numbers[i];
            var rightAnswer = (isEven(Integer.parseInt(num))) ? "yes" : "no";
            rightAnswers[i] = rightAnswer;
        }

        return rightAnswers;
    }

    public static String[] getQuestions() {
        final var limitOfRandom = 100;
        final var rounds = 3;
        String[] numbers = new String[rounds];

        for (var i = 0; i < rounds; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, limitOfRandom);
            numbers[i] = Integer.toString(randomNum);
        }
        return numbers;
    }
}
