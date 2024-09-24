import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static Number[] numbers;

    public static void main(String[] args) throws IOException {
        input();
        bubbleSort();
        System.out.println(ans + 1);
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        numbers = new Number[n];

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = new Number(Integer.parseInt(br.readLine()), idx);
        }

        Arrays.sort(numbers, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return o1.value - o2.value;
            }
        });
    }

    static void bubbleSort() {
        for(int idx = 0; idx < n; idx++) {
            ans = Math.max(ans, numbers[idx].idx - idx);
        }
    }
}

class Number {
    int value;
    int idx;

    public Number(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }
}