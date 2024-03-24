import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker;
    static int g;

    public static void main(String[] args) {
        input();
        diet();
        System.out.print(ansMaker.isEmpty() ? -1 : ansMaker);
    }

    static void input() {
        g = sc.nextInt();
        ansMaker = new StringBuilder();
    }

    static void diet() {
        int now = 1;
        int before = 1;

        while(true) {
            int diff = now * now - before * before;

            if(now - before == 1 && diff > g) break;

            if(diff > g) {
                before++;
            }
            else {
                if(diff == g) {
                    ansMaker.append(now).append("\n");
                }
                now++;
            }
        }
    }

}