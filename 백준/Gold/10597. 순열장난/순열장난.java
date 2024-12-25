import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String num;
    static int max;
    static boolean[] visit;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        restorePermutation(0, new ArrayList<>());
        System.out.print(ansMaker);
    }

    static void input() {
        num = sc.next();
        max = 0;

        if(num.length() > 10) {
            max += (num.length() + 9) / 2;
        } else {
            max += num.length();
        }

        visit = new boolean[max + 1];
        ansMaker = new StringBuilder();
    }

    static void restorePermutation(int idx, List<Integer> permutation) {
        if(idx == num.length()) {
            if(ansMaker.isEmpty()) {
                permutation.forEach(number -> ansMaker.append(number).append(" "));
            }

            return;
        }

        int now = Integer.parseInt(num.substring(idx, idx + 1));

        if(now != 0 && !visit[now]) {
            visit[now] = true;
            permutation.add(now);

            restorePermutation(idx + 1, permutation);

            if(!ansMaker.isEmpty()) return;

            visit[now] = false;
            permutation.remove(permutation.size() - 1);
        }

        if(idx < num.length() - 1) {
            now = Integer.parseInt(num.substring(idx, idx + 2));
            
            if(now <= max && !visit[now]) {
                visit[now] = true;
                permutation.add(now);

                restorePermutation(idx + 2, permutation);

                if(!ansMaker.isEmpty()) return;

                visit[now] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}