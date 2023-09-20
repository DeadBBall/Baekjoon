import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static Set<Integer> note;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            input();
            checkNote();
        }
        System.out.println(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        note = new HashSet<>();

        for(int numIdx = 0; numIdx < n; numIdx++) {
            int nowNumber = sc.nextInt();
            note.add(nowNumber);
        }
    }

    static void checkNote() {
        int m = sc.nextInt();

        for(int numIdx = 0; numIdx < m; numIdx++) {
            int nowNumber = sc.nextInt();

            if(note.contains(nowNumber))
                ansMaker.append(1).append("\n");
            else
                ansMaker.append(0).append("\n");
        }
    }

}