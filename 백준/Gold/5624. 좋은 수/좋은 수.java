import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[] numbers;
    static Set<Integer> sumSet;

    public static void main(String[] args) {
        input();
        findGoodNumber();
        System.out.println(ans);
    }


    static void input() {
        n = sc.nextInt();
        numbers = new int[n];

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextInt();
        }

        sumSet = new HashSet<>();
    }

    static void findGoodNumber() {
        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                sumSet.add(numbers[j] + numbers[i - 1]);
            }

            for(int j = i - 1; j >= 0; j--) {
                if(sumSet.contains(numbers[i] - numbers[j])) {
                    ans++;
                    break;
                }
            }
        }
    }
}