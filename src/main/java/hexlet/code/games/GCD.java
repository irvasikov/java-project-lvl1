package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public class GCD {
    public static String[] getQuestions() {
        final var limitOfRandom = 100;
        final var rounds = 3;
        String[] questions = new String[rounds];

        for (var i = 0; i < rounds; i++) {
            int randomNum1 = ThreadLocalRandom.current().nextInt(1, limitOfRandom);
            int randomNum2 = ThreadLocalRandom.current().nextInt(1, limitOfRandom);

            questions[i] = randomNum1 + " " + randomNum2;
        }

        return questions;
    }

    public static String[] getAnswers(String[] questions) {
        final var rounds = 3;
        String[] answers = new String[rounds];

        for (var i = 0; i < rounds; i++) {
            String[] numbers = questions[i].split(" ");
            var num1 = Integer.parseInt(numbers[0]);
            var num2 = Integer.parseInt(numbers[1]);
            answers[i] = Integer.toString(gcd(num1, num2));
        }

        return answers;
    }

    public static int gcd(int number1, int number2) {
        if (number1 == 0) {
            return number2;
        }

        while (number2 != 0) {
            if (number1 > number2) {
                number1 = number1 - number2;
            } else {
                number2 = number2 - number1;
            }
        }

        return number1;
    }
}
