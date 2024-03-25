import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static boolean finish;
    static int x, n;
    static int[] bricks;

    public static void main(String[] args) {
        while(!finish) {
            input();

            if(finish) break;

            closeHole();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        if(!sc.hasNext()) {
            finish = true;
            return;
        }

        x = sc.nextInt() * 10000000;
        n = sc.nextInt();

        bricks = new int[n];

        for(int brickIdx = 0; brickIdx < n; brickIdx++) {
            bricks[brickIdx] = sc.nextInt();
        }

        Arrays.sort(bricks);
    }

    static void closeHole() {
        int left = 0;
        int right = n - 1;

        int leftAns = 0;
        int rightAns = 0;

        while(left < right) {
            int sum = bricks[left] + bricks[right];

            if(sum == x) {
                leftAns = bricks[left];
                rightAns = bricks[right];
                break;
            }
            else if(sum > x) right--;
            else left++;
        }

        ansMaker.append(leftAns == 0 ? "danger" : "yes " + leftAns + " " + rightAns).append("\n");
    }

}