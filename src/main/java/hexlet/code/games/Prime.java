package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public class Prime {
    public static String[] getQuestions() {
        String[] questions = new String[3];

        for (var i = 0; i < 3; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 100);
            questions[i] = Integer.toString(randomNum);
        }

        return questions;
    }

    public static String[] getAnswers(String[] questions) {
        String[] answers = new String[3];

        for (var i = 0; i < 3; i++) {
            var number = Integer.parseInt(questions[i]);
            answers[i] = (isNumberPrime(number)) ? "yes" : "no";
        }
        return answers;
    }

    public static boolean isNumberPrime(int number) {
        if (number < 2)
            return false;
        double s = Math.sqrt(number);
        for (int i = 2; i <= s; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
