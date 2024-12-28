import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String n, m;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            compare();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.next();
        m = sc.next();
    }

    static void compare() {
        int zeroCnt = 0;
        int oneCnt = 0;

        for(int idx = 0; idx < n.length(); idx++) {
            if(n.charAt(idx) != m.charAt(idx)) {
                if(n.charAt(idx) == '1') oneCnt++;
                else zeroCnt++;
            }
        }

        ansMaker.append(Math.max(zeroCnt, oneCnt)).append("\n");
    }
}