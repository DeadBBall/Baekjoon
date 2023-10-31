import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] numbers;
    static OhKunSu[] answers;

    public static void main(String[] args) {
        input();
        searchOhKunSu();
        printAns();
    }
    static void input() {
        n = sc.nextInt();
        numbers = new int[n];
        answers = new OhKunSu[n];

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextInt();
        }
    }

    static void searchOhKunSu() {
        answers[n - 1] = new OhKunSu(-1, -1);
        for(int idx = n - 2; idx >= 0; idx--) {
            if(numbers[idx] < numbers[idx + 1]) {
                answers[idx] = new OhKunSu(idx + 1, numbers[idx + 1]);
            }
            else {
                int now = answers[idx + 1].idx;
                while(true) {
                    if(now == -1) {
                        answers[idx] = new OhKunSu(-1, -1);
                        break;
                    }
                    if(numbers[idx] < numbers[now]) {
                        answers[idx] = new OhKunSu(now, numbers[now]);
                        break;
                    }
                    now = answers[now].idx;
                }
            }
        }
    }

    static void printAns() {
        StringBuilder ansMaker = new StringBuilder();
        for(int idx = 0; idx < n; idx++) {
            ansMaker.append(answers[idx].num + " ");
        }
        System.out.print(ansMaker);
    }

}

class OhKunSu {
    int idx;
    int num;

    OhKunSu(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}