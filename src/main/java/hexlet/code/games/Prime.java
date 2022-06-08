package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public class Prime {
    public static String[] getQuestions() {
        final var limitOfRandom = 100;
        final var rounds = 3;
        String[] questions = new String[rounds];

        for (var i = 0; i < rounds; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, limitOfRandom);
            questions[i] = Integer.toString(randomNum);
        }

        return questions;
    }

    public static String[] getAnswers(String[] questions) {
        final var rounds = 3;
        String[] answers = new String[rounds];

        for (var i = 0; i < rounds; i++) {
            var number = Integer.parseInt(questions[i]);
            answers[i] = (isNumberPrime(number)) ? "yes" : "no";
        }
        return answers;
    }

    public static boolean isNumberPrime(int number) {
        if (number < 2) {
            return false;
        }
        double s = Math.sqrt(number);
        for (int i = 2; i <= s; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
