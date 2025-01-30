import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int a, b, v;
    static String vote;

    public static void main(String[] args) {
        input();
        decide();
    }

    static void input() {
        v = sc.nextInt();
        vote = sc.next();
    }

    static void decide() {
        for(int idx = 0; idx < v; idx++) {
            if(vote.charAt(idx) == 'A') {
                a++;
            } else {
                b++;
            }
        }
        
        if(a > b) {
            System.out.println("A");
        } else if(a < b) {
            System.out.println("B");
        } else {
            System.out.println("Tie");
        }
    }
}