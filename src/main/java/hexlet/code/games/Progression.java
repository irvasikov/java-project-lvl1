package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public class Progression {

    public static String[] getQuestions() {
        String[] questions = new String[3];

        for (var i = 0; i < 3; i++) {
            questions[i] = getProgression(getNumbers());
        }

        return questions;
    }

    public static String[] getAnswers(String[] questions) {
        String[] answers = new String[3];

        for (var i = 0; i < 3; i++) {
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
        var excludeNumber = ThreadLocalRandom.current().nextInt(3, 7);
        String[] resultString = new String[10];

        for (var i = 0; i < 10; i++) {
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
        var startNumber = ThreadLocalRandom.current().nextInt(0, 21);
        var step = ThreadLocalRandom.current().nextInt(0, 6);

        int[] numbers = new int[10];

        for (var i = 0; i < 10; i++) {
            var newNum = startNumber + i * step;
            numbers[i] = newNum;
        }
        return numbers;
    }
}

/*    Welcome to the Brain Games!
    May I have your name? Sam
    Hello, Sam!
    What number is missing in the progression?
    Question: 5 7 9 11 13 .. 17 19 21 23
    Your answer: 15
    Correct!
    Question: 2 5 8 .. 14 17 20 23 26 29
    Your answer: 11
    Correct!
    Question: 14 19 24 29 34 39 44 49 54 ..
    Your answer: 59
    Correct!
    Congratulations, Sam!*/
