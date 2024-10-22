import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n1, n2, t;
    static char[] ants;
    static boolean[] isFirstGroup;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        move();
        System.out.print(ansMaker);
    }

    static void input() {
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        ants = new char[n1 + n2];
        isFirstGroup = new boolean[n1 + n2];

        String ant = sc.next();

        for(int idx = 0; idx < ant.length(); idx++) {
            ants[idx] = ant.charAt(ant.length() - 1 - idx);
            isFirstGroup[idx] = true;
        }

        ant = sc.next();

        for(int idx = 0; idx < ant.length(); idx++) {
            ants[idx + n1] = ant.charAt(idx);
        }

        ansMaker = new StringBuilder();

        t = sc.nextInt();
    }

    static void move() {
        while(t-- > 0) {
            for(int idx = 0; idx < n1 + n2 - 1; idx++) {
                if(isFirstGroup[idx] && !isFirstGroup[idx + 1]) {
                    jump(idx);
                    idx++;
                }
            }
        }

        for(char ant : ants) {
            ansMaker.append(ant);
        }
    }

    static void jump(int idx) {
        char tmp = ants[idx];
        ants[idx] = ants[idx + 1];
        ants[idx + 1] = tmp;

        isFirstGroup[idx] = false;
        isFirstGroup[idx + 1] = true;
    }
}