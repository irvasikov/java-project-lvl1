package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public class Calculate {
    public static String[] getQuestions() {
        final var rounds = 3;
        final var limitOfRandom = 100;

        String[] sings = {"+", "-", "*"};
        String[] questions = new String[rounds];

        for (var i = 0; i < rounds; i++) {
            int randomNum1 = ThreadLocalRandom.current().nextInt(1, limitOfRandom);
            int randomNum2 = ThreadLocalRandom.current().nextInt(1, limitOfRandom);
            int randomSing = ThreadLocalRandom.current().nextInt(0, rounds);

            var resultQuestion = randomNum1 + " " + sings[randomSing] + " " + randomNum2;

            questions[i] = resultQuestion;
        }
        return questions;
    }

    public static String[] getAnswers(String[] questions) {
        final var rounds = 3;
        String[] answers = new String[rounds];


        for (var i = 0; i < rounds; i++) {
            var elementsOfExpr = questions[i].split(" ");
            var num1 = Integer.parseInt(elementsOfExpr[0]);
            var sing = elementsOfExpr[1];
            var num2 = Integer.parseInt(elementsOfExpr[2]);

            answers[i] = resultOfExpression(num1, num2, sing);
        }
        return answers;
    }

    public static String resultOfExpression(int num1, int num2, String sing) {
        String result = "";

        switch (sing) {
            case "+":
                result = Integer.toString(num1 + num2);
                return result;
            case "-":
                result = Integer.toString(num1 - num2);
                return result;
            case "*":
                result = Integer.toString(num1 * num2);
                return result;
            default:
                System.out.println("blah blah blah");
        }

        return result;
    }
}
