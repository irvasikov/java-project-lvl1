package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public class Calculate {
    public static String[] getQuestions() {
        String[] sings = {"+", "-", "*"};
        String[] questions = new String[3];

        for (var i = 0; i < 3; i++) {
            int randomNum1 = ThreadLocalRandom.current().nextInt(1, 100);
            int randomNum2 = ThreadLocalRandom.current().nextInt(1, 100);
            int randomSing = ThreadLocalRandom.current().nextInt(0, 3);

            var resultQuestion = Integer.toString(randomNum1) + " " + sings[randomSing] + " " + Integer.toString(randomNum2);

            questions[i] = resultQuestion;
        }
        return questions;
    }

    public static String[] getAnswers(String[] questions) {
        String[] answers = new String[3];


        for (var i = 0; i < 3; i++) {
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
        }

        return result;
    }
}
