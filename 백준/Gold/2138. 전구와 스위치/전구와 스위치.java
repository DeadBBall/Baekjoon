import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final char ON = '1';
    static int n;
    static boolean[] origin;
    static boolean[] target;

    public static void main(String[] args) {
        input();
        System.out.println(pressSwitch());
    }

    static void input() {
        n = sc.nextInt();
        origin = new boolean[n];
        target = new boolean[n];

        String bulbs = sc.next();

        for(int bulbIdx = 0; bulbIdx < n; bulbIdx++) {
            if(bulbs.charAt(bulbIdx) == ON) {
                origin[bulbIdx] = true;
            }
        }

        bulbs = sc.next();

        for(int bulbIdx = 0; bulbIdx < n; bulbIdx++) {
            if(bulbs.charAt(bulbIdx) == ON) {
                target[bulbIdx] = true;
            }
        }

    }

    static int pressSwitch() {
        boolean[] copiedOrigin = Arrays.copyOf(origin, n);

        int result = countPress(copiedOrigin, 0);

        copiedOrigin = Arrays.copyOf(origin, n);

        copiedOrigin[0] = !copiedOrigin[0];
        copiedOrigin[1] = !copiedOrigin[1];

        result = Math.min(result, countPress(copiedOrigin, 1));

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    static int countPress(boolean[] copiedOrigin, int count) {
        for(int bulbIdx = 1; bulbIdx < n; bulbIdx++) {
            if(copiedOrigin[bulbIdx - 1] != target[bulbIdx - 1]) {
                copiedOrigin[bulbIdx - 1] = !copiedOrigin[bulbIdx - 1];
                copiedOrigin[bulbIdx] = !copiedOrigin[bulbIdx];

                if(bulbIdx != n - 1) {
                    copiedOrigin[bulbIdx + 1] = !copiedOrigin[bulbIdx + 1];
                }

                count++;
            }
        }

        if(copiedOrigin[0] == target[0] && copiedOrigin[n - 1] == target[n - 1]) {
            return count;
        }

        return Integer.MAX_VALUE;
    }
}