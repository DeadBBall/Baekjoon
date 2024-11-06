import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[] tabs, targetTabs;

    public static void main(String[] args) {
        input();
        coding();
        System.out.println(ans);
    }


    static void input() {
        n = sc.nextInt();
        tabs = new int[n];

        for(int idx = 0; idx < n; idx++) {
            tabs[idx] = sc.nextInt();
        }

        targetTabs = new int[n];

        for(int idx = 0; idx < n; idx++) {
            targetTabs[idx] = sc.nextInt();
        }
    }

    static void coding() {
        for(int i = 0; i < n; i++) {
            while(tabs[i] != targetTabs[i]) {
                if (tabs[i] > targetTabs[i]) {
                    int lastIdx = i + 1;
                    int minDiff = tabs[i] - targetTabs[i];

                    while (lastIdx < n && tabs[lastIdx] > targetTabs[lastIdx]) {
                        minDiff = Math.min(minDiff, tabs[lastIdx] - targetTabs[lastIdx]);
                        lastIdx++;
                    }

                    ans += minDiff;

                    for (int j = i; j < lastIdx; j++) {
                        tabs[j] -= minDiff;
                    }

                } else if (tabs[i] < targetTabs[i]) {
                    int lastIdx = i + 1;
                    int minDiff = targetTabs[i] - tabs[i];

                    while (lastIdx < n && tabs[lastIdx] < targetTabs[lastIdx]) {
                        minDiff = Math.min(minDiff, targetTabs[lastIdx] - tabs[lastIdx]);
                        lastIdx++;
                    }

                    ans += minDiff;

                    for (int j = i; j < lastIdx; j++) {
                        tabs[j] += minDiff;
                    }
                }
            }
        }
    }
}