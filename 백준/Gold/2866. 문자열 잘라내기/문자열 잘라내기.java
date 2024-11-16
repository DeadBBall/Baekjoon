import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int r, c, count;
    static StringBuilder[] sbs;

    public static void main(String[] args) {
        input();
        cutStr();
        System.out.println(count);
    }


    static void input() {
        r = sc.nextInt();
        c = sc.nextInt();

        sbs = new StringBuilder[c];

        String[] strs = new String[r];

        for(int idx = 0; idx < r; idx++) {
            strs[idx] = sc.next();
        }

        for(int i = 0; i < c; i++) {
            sbs[i] = new StringBuilder();

            for(int j = 0; j < r; j++) {
                sbs[i].append(strs[j].charAt(i));
            }
        }
    }

    static void cutStr() {
        Set<String> stringSet = new HashSet<>();

        for(int j = 0; j < r - 1; j++) {
            for(int i = 0; i < c; i++) {
                sbs[i].deleteCharAt(0);
                stringSet.add(sbs[i].toString());
            }

            if (stringSet.size() != c) return;

            count++;

            stringSet.clear();
        }
    }
}