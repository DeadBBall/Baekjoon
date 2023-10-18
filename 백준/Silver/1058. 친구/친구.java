import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[][] friends;
    static int[] friendCount;

    public static void main(String[] args) {
        input();
        checkAll();
        System.out.println(ans);
    }
    static void input() {
        n = sc.nextInt();
        friends = new int[n][n];
        friendCount = new int[n];

        for(int y = 0; y < n; y++) {
            String myFriend = sc.next();
            for(int x = 0; x < n; x++) {
                if(myFriend.charAt(x) == 'Y') {
                    friends[y][x] = 1;
                }
            }
        }
    }

    static void checkAll() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(i != k && friends[i][k] == 0 && friends[i][j] == 1 && friends[j][k] == 1) {
                        friendCount[i]++;
                        friends[i][k] = 2;
                    }
                }
            }
        }

        for(int start = 0; start < n; start++) {
            for(int end = 0; end < n; end++) {
                if(friends[start][end] == 1)
                    friendCount[start]++;
            }
        }

        for(int idx = 0; idx < n; idx++) {
            ans = Math.max(ans, friendCount[idx]);
        }
    }
}