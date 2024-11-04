import java.util.*;

public class Main {
    static final int MAX_SIZE = 181;
    static Scanner sc = new Scanner(System.in);
    static int[] numbers;
    static int n;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        setup();

        while(true) {
            input();

            if(n == 0) break;

            findNumber();
        }

        System.out.print(ansMaker);
    }

    static void setup() {
        numbers = new int[MAX_SIZE];

        for(int idx = 1; idx <= MAX_SIZE; idx++) {
            numbers[idx - 1] = (int)Math.pow(idx, 2);
        }

        ansMaker = new StringBuilder();
    }

    static void input() {
        n = sc.nextInt();
    }

    static void findNumber() {
        int ans = 0;

        for(int i = 0; i < MAX_SIZE; i++) {
            int numI = numbers[i];

            if(numI == n) ans++;
            else if(numI > n) break;

            for(int j = i; j < MAX_SIZE; j++) {
                int numJ = numbers[j] + numI;

                if(numJ == n) ans++;
                else if(numJ > n) break;

                for(int k = j; k < MAX_SIZE; k++) {
                    int numK = numbers[k] + numJ;

                    if(numK == n) ans++;
                    else if(numK > n) break;

                    for(int l = k; l < MAX_SIZE; l++) {
                        int numL = numbers[l] + numK;

                        if(numL == n) ans++;
                        else if(numL > n) break;
                    }

                }
            }
        }

        ansMaker.append(ans).append("\n");
    }
}