import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static List<Long> sticks;
    static long ans;

    public static void main(String[] args) {
        input();
        cutSticks();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        sticks = new ArrayList<>();

        for(int idx = 0; idx < n; idx++) {
            sticks.add(sc.nextLong());
        }
    }

    static void cutSticks() {
        while(sticks.size() != 1) {
            List<Long> newSticks = new ArrayList<>();

            Collections.sort(sticks);

            for(int idx = 0; idx < sticks.size() / 2; idx++) {
                ans += sticks.get(idx) * sticks.get(sticks.size() - 1 - idx);
                newSticks.add(sticks.get(idx) + sticks.get(sticks.size() - 1 - idx));
            }

            if(sticks.size() % 2 == 1) {
                newSticks.add(sticks.get(sticks.size() / 2));
            }

            sticks = new ArrayList<>(newSticks);
        }
    }
}