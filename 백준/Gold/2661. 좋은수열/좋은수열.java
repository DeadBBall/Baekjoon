import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder progression;
    static int n;
    static boolean flag;

    public static void main(String[] args) {
        input();
        makeProgression();
    }

    static void input() {
        n = sc.nextInt();
        progression = new StringBuilder();
        flag = false;
    }

    static void makeProgression() {
        if(progression.length() == n) {
            System.out.println(progression);
            flag = true;
            return;
        }

        for(int num = 1; num <= 3; num++) {
            if(flag) return;

            progression.append(num);

            if(!isBad()) {
                makeProgression();
            }

            progression.deleteCharAt(progression.length() - 1);
        }
    }

    static boolean isBad() {
        for(int len = 1; len <= progression.length() / 2; len++) {
            String left = progression.substring(progression.length() - len * 2, progression.length() - len);
            String right = progression.substring(progression.length() - len, progression.length());

            if(left.equals(right)) return true;
        }

        return false;
    }
}