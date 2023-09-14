import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int SANGEUN = 1;
    static int n;
    static int m;
    static List<Integer>[] lines;
    static boolean[] friends;
    static int ans;

    public static void main(String[] args) {
        input();
        searchFriend();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();

        lines = new ArrayList[n + 1];
        friends = new boolean[n + 1];
        for(int friendIdx = 1; friendIdx <= n; friendIdx++) {
            lines[friendIdx] = new ArrayList<>();
        }

        while(m-- > 0) {
            int friendA = sc.nextInt();
            int frinedB = sc.nextInt();

            lines[friendA].add(frinedB);
            lines[frinedB].add(friendA);
        }

    }

    static void searchFriend() {
        Queue<Friend> friendQueue = new LinkedList<>();

        friendQueue.add(new Friend(SANGEUN, 0));
        friends[SANGEUN] = true;

        while(!friendQueue.isEmpty()) {
            Friend now = friendQueue.remove();

            List<Integer> friendOfNow = lines[now.number];

            for(Integer end: friendOfNow) {
                if(friends[end]) continue;

                friends[end] = true;

                if(now.dist <= 1) {
                    friendQueue.add(new Friend(end, now.dist + 1));
                    ans++;
                }
            }
        }

    }

    static class Friend {
        int number;
        int dist;

        public Friend(int number, int dist) {
            this.number = number;
            this.dist = dist;
        }

    }
}