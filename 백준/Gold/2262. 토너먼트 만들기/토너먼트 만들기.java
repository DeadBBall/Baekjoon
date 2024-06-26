import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static LinkedList list;

    public static void main(String[] args){
        input();
        makeMatch();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        list = new LinkedList();

        for(int idx = 0; idx < n; idx++) {
            int rank = sc.nextInt();

            list.add(rank);
        }
    }

    static void makeMatch() {
        while(list.size != 1) {
            Player bottom = new Player(0);

            Player now = list.start;

            while(now != null) {
                if(now.rank > bottom.rank) {
                    bottom = now;
                }
                now = now.next;
            }

            if(bottom.prev == null) {
                ans += bottom.rank - bottom.next.rank;
            } else if(bottom.next == null) {
                ans += bottom.rank - bottom.prev.rank;
            } else {
                ans += Math.min(bottom.rank - bottom.next.rank, bottom.rank - bottom.prev.rank);
            }

            list.remove(bottom);
        }
    }
}

class LinkedList {
    Player start;
    int size;
    Player end;

    void add(int rank) {
        Player now = new Player(rank);

        if(start == null) {
            start = now;
            end = now;
        } else {
            end.next = now;
            now.prev = end;
            end = now;
        }

        size++;
    }

    void remove(Player now) {
        if(now.prev == null) {
            start = now.next;
            now.next.prev = null;

        } else if(now.next == null) {
            now.prev.next = null;
            end = now.prev;
        } else {
            now.prev.next = now.next;
            now.next.prev = now.prev;
        }
        size--;
    }
}

class Player {
    int rank;
    Player prev;
    Player next;

    Player(int rank) {
        this.rank = rank;
    }
}