import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static List<Integer> ansList;
    static List<Question> questionList;

    public static void main(String[] args) {
        input();
        playBaseball();
        System.out.println(ansList.size());
    }

    static void input() {
        n = sc.nextInt();
        ansList = new ArrayList<>();
        questionList = new ArrayList<>();

        for(int questionIdx = 0; questionIdx < n; questionIdx++) {
            String number = sc.next();
            int strike = sc.nextInt();
            int ball = sc.nextInt();
            questionList.add(new Question(number, strike, ball));
        }
    }

    static void playBaseball() {
        for(int num = 123; num <= 987; num++) {
            boolean flag = true;

            if(!checkValidNumber(num)) continue;

            for(int qIdx = 0; qIdx < n; qIdx++) {
                if(!checkNumber(num, questionList.get(qIdx))) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                ansList.add(num);
        }
    }

    static boolean checkValidNumber(int number) {
        String numStr = String.valueOf(number);

        if(numStr.contains("0")) return false;

        return numStr.charAt(0) != numStr.charAt(1)
                && numStr.charAt(1) != numStr.charAt(2)
                && numStr.charAt(0) != numStr.charAt(2);
    }

    static boolean checkNumber(int number, Question question) {
        String target = String.valueOf(number);
        int strike = 0;
        int ball = 0;

        for(int idx = 0; idx < 3; idx++) {
            if(target.charAt(idx) == question.number.charAt(idx)) strike++;
        }

        for(int idx = 0; idx < 3; idx++) {
            if(target.contains(String.valueOf(question.number.charAt(idx)))) ball++;
        }

        ball -= strike;

        if(strike == question.strike && ball == question.ball) return true;

        return false;
    }

    static class Question {
        String number;
        int strike;
        int ball;

        public Question(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

}