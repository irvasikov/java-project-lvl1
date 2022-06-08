package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public class Progression {

    public static String[] getQuestions() {
        final var rounds = 3;
        String[] questions = new String[rounds];

        for (var i = 0; i < rounds; i++) {
            questions[i] = getProgression(getNumbers());
        }

        return questions;
    }

    public static String[] getAnswers(String[] questions) {
        final var rounds = 3;
        String[] answers = new String[rounds];

        for (var i = 0; i < rounds; i++) {
            var answer = getRightAnswer(questions[i]);
            answers[i] = Integer.toString(answer);
        }

        return answers;
    }

    public static int getRightAnswer(String progress) {
        String[] chars = progress.split(" ");
        var result = 0;

        for (var i = 0; i < chars.length; i++) {
            var ch = chars[i];
            if (ch.equals("..")) {
                var previousNumber = Integer.parseInt(chars[i - 1]);
                var step =  previousNumber - Integer.parseInt(chars[i - 2]);
                result = previousNumber + step;
            }
        }
        return result;
    }

    public static String getProgression(int[] numbers) {
        final var startRandomExcludeNumber = 3;
        final var endRandomExcludeNumber = 7;
        final var numberOfProgression = 10;

        var excludeNumber = ThreadLocalRandom.current().nextInt(startRandomExcludeNumber, endRandomExcludeNumber);
        String[] resultString = new String[numberOfProgression];

        for (var i = 0; i < numberOfProgression; i++) {
            var addStr = Integer.toString(numbers[i]);

            if (i == excludeNumber) {
                addStr = "..";
            }
            resultString[i] = addStr;
        }

        String result = String.join(" ", resultString);

        return result;

    }

    public static int[] getNumbers() {
        final var limitRandomNumberStart = 21;
        final var limitRandomNumberStep = 6;
        final var numberOfProgression = 10;

        var startNumber = ThreadLocalRandom.current().nextInt(0, limitRandomNumberStart);
        var step = ThreadLocalRandom.current().nextInt(0, limitRandomNumberStep);

        int[] numbers = new int[numberOfProgression];

        for (var i = 0; i < numberOfProgression; i++) {
            var newNum = startNumber + i * step;
            numbers[i] = newNum;
        }
        return numbers;
    }
}
