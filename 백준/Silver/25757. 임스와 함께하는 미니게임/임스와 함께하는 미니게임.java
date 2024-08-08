import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static String game;
    static Set<String> members;

    public static void main(String[] args) {
        input();
        playGame();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        game = sc.next();

        members = new HashSet<>();

        while(n-- > 0) {
            members.add(sc.next());
        }
    }

    static void playGame() {
        if(game.equals("Y")) {
            ans = members.size();
        } else if(game.equals("F")) {
            ans = members.size() / 2;
        } else {
            ans = members.size() / 3;
        }
    }
}