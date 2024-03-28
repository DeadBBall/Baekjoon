import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] openClosets, necessaryClosets;
    static int closetCount, necessaryClosetCount;

    public static void main(String[] args) {
        input();
        System.out.println(countMinMove(0, openClosets[0], openClosets[1]));
    }

    static void input() {
        closetCount = sc.nextInt();
        openClosets = new int[2];

        for(int idx = 0; idx < 2; idx++) {
            openClosets[idx] = sc.nextInt();
        }

        necessaryClosetCount = sc.nextInt();
        necessaryClosets = new int[necessaryClosetCount];

        for(int idx = 0; idx < necessaryClosetCount; idx++) {
            necessaryClosets[idx] = sc.nextInt();
        }
    }

    static int countMinMove(int idx, int closet, int closet2) {
        if(idx == necessaryClosetCount) return 0;

        int moveCount = Math.abs(closet - necessaryClosets[idx]);
        int moveCount2 = Math.abs(closet2 - necessaryClosets[idx]);

        return Math.min(moveCount + countMinMove(idx + 1, necessaryClosets[idx], closet2),
                moveCount2 + countMinMove(idx + 1, closet, necessaryClosets[idx]));
    }

}
