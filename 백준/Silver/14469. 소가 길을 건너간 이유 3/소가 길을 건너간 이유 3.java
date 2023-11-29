import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static Cow[] cows;

    public static void main(String[] args) {
        input();
        enterFarm();
        System.out.println(ans);
    }
    static void input() {
        n = sc.nextInt();
        cows = new Cow[n];
        for(int cowIdx = 0; cowIdx < n; cowIdx++) {
            int arrivedTime = sc.nextInt();
            int checkTime = sc.nextInt();
            cows[cowIdx] = new Cow(arrivedTime, checkTime);
        }
        Arrays.sort(cows, new Comparator<Cow>() {
            @Override
            public int compare(Cow o1, Cow o2) {
                return o1.arrivedTime - o2.arrivedTime;
            }
        });
    }

    static void enterFarm() {
        int nowTime = 0;
        for(int cowIdx = 0; cowIdx < n; cowIdx++) {
            Cow now = cows[cowIdx];
            if(nowTime <= now.arrivedTime)
                nowTime = (now.arrivedTime + now.checkTime);
            else
                nowTime += now.checkTime;
        }
        ans = nowTime;
    }

    static class Cow {
        int arrivedTime;
        int checkTime;

        Cow(int arrivedTime, int checkTime) {
            this.arrivedTime = arrivedTime;
            this.checkTime = checkTime;
        }
    }
}