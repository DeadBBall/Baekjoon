import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String hongjun;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        beTogether();
        System.out.print(ansMaker);
    }

    static void input() {
        hongjun = sc.next();
        ansMaker = new StringBuilder();
    }

    static void beTogether() {
        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 3; x++) {
                if(y == 1 && x == 1) {
                    ansMaker.append(":").append(hongjun).append(":");
                } else {
                    ansMaker.append(":fan:");
                }
            }
            ansMaker.append("\n");
        }
    }
}