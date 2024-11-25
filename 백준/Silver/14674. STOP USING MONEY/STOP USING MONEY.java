import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k;
    static PriorityQueue<Game> games;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        buyGames();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();

        games = new PriorityQueue<>(new Comparator<Game>() {
            @Override
            public int compare(Game o1, Game o2) {
                long o1Sat = (long) o2.h * o1.c;
                long o2Sat = (long) o1.h * o2.c;

                if(o1Sat == o2Sat) {
                    if(o1.c == o2.c) return o1.i - o2.i;

                    return o1.c - o2.c;
                }

                return Long.compare(o1Sat, o2Sat);
            }
        });

        while(n-- > 0) {
            games.add(new Game(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        ansMaker = new StringBuilder();
    }

    static void buyGames() {
        while(k-- > 0) {
            ansMaker.append(games.remove().i).append("\n");
        }
    }
}

class Game {
    int i;
    int c;
    int h;

    public Game(int i, int c, int h) {
        this.i = i;
        this.c = c;
        this.h = h;
    }
}