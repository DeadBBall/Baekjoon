import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int size;
    static int[] counts;
    static int[][] classes;

    public static void main(String[] args) {
        input();
        checkClass();
    }

    static void input() {
        size = sc.nextInt();
        counts = new int[size];
        classes = new int[size][5];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < 5; j++) {
                classes[i][j] = sc.nextInt();
            }
        }
    }

    static void checkClass() {
        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size; j++) {
                for(int k = 0; k < 5; k++) {
                    if(classes[i][k] == classes[j][k]) {
                        counts[i]++;
                        counts[j]++;
                        break;
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;

        for(int i = 0; i < size; i++) {
            if(max < counts[i]) {
                max = counts[i];
                ans = i + 1;
            }
        }

        System.out.println(ans);
    }

}