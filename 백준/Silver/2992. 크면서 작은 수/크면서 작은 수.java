import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int x, ans, len;
    static int[] numbers;

    public static void main(String[] args) {
        input();
        searchNumber(new StringBuilder());
        System.out.println(ans);
    }

    static void input() {
        x = sc.nextInt();
        numbers = new int[10];

        for(int num = x; num > 0; num /= 10) {
            numbers[num % 10]++;
            len++;
        }
    }

    static void searchNumber(StringBuilder number) {
        if(number.length() == len) {
            if(Integer.parseInt(number.toString()) > x) {
                ans = Integer.parseInt(number.toString());
            }

            return;
        }

        for(int idx = 0; idx <= 9; idx++) {
            if(numbers[idx] > 0) {
                numbers[idx]--;
                searchNumber(number.append(idx));

                if(ans != 0) return;

                number.deleteCharAt(number.length() - 1);
                numbers[idx]++;
            }
        }


    }
}