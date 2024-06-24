import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k, b, ans;
    static boolean[] trafficLights;

    public static void main(String[] args){
        input();
        repairTrafficLights();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        b = sc.nextInt();
        trafficLights = new boolean[n + 1];

        while(b-- > 0) {
            int brokenPosition = sc.nextInt();

            trafficLights[brokenPosition] = true;
        }
    }

    static void repairTrafficLights() {
        int brokenCnt = 0;

        for(int idx = 1; idx <= k; idx++) {
            if(trafficLights[idx]) brokenCnt++;
        }

        ans = brokenCnt;

        for(int idx = k + 1; idx <= n; idx++) {
            if(trafficLights[idx]) brokenCnt++;

            if(trafficLights[idx - k]) brokenCnt--;
            
            ans = Math.min(ans, brokenCnt);
        }
    }

}