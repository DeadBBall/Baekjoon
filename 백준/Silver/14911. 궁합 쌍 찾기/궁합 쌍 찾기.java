import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int ans, target;
    static List<Integer> numbers;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        findPair();
        System.out.print(ansMaker);
    }

    static void input() {
        numbers = new ArrayList<>();

        String[] nums = sc.nextLine().split(" ");

        for(String num : nums) {
            numbers.add(Integer.parseInt(num));
        }

        target = sc.nextInt();

        ansMaker = new StringBuilder();

        Collections.sort(numbers);
    }

    static void findPair() {
        for(int i = 0; i < numbers.size() - 1; i++) {
            int a = numbers.get(i);

            for(int j = i + 1; j < numbers.size(); j++) {
                int b = numbers.get(j);

                if(a + b == target) {
                    ans++;
                    ansMaker.append(a).append(" ").append(b).append("\n");
                    break;
                } else if(a + b > target) break;
            }
        }

        ansMaker.append(ans);
    }
}