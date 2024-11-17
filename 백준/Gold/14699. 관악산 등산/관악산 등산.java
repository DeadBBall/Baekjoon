import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static PriorityQueue<RestArea> restAreas;
    static int[] heights, dp;
    static List<Integer>[] edges;
    static StringBuilder ans;

    public static void main(String[] args) {
        input();
        climb();
        System.out.print(ans);
    }


    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        heights = new int[n + 1];
        dp = new int[n + 1];
        edges = new List[n + 1];

        restAreas = new PriorityQueue<>(new Comparator<RestArea>() {
            @Override
            public int compare(RestArea o1, RestArea o2) {
                return o2.height - o1.height;
            }
        });

        for(int idx = 0; idx < n; idx++) {
            int height = sc.nextInt();

            heights[idx + 1] = height;

            restAreas.add(new RestArea(idx + 1, height));
            edges[idx + 1] = new ArrayList<>();
        }

        while(m-- > 0) {
            int area = sc.nextInt();
            int area2 = sc.nextInt();

            if(heights[area] > heights[area2]) {
                edges[area2].add(area);
            } else if(heights[area] < heights[area2]) {
                edges[area].add(area2);
            }
        }

        ans = new StringBuilder();
    }

    static void climb() {
        while(!restAreas.isEmpty()) {
            RestArea now = restAreas.remove();

            if(edges[now.idx].isEmpty()) {
                dp[now.idx] = 1;
            } else {
                for(int next : edges[now.idx]) {
                    dp[now.idx] = Math.max(dp[next] + 1, dp[now.idx]);
                }
            }
        }

        for(int idx = 1; idx <= n; idx++) {
            ans.append(dp[idx]).append("\n");
        }
    }
}

class RestArea {
    int idx;
    int height;

    public RestArea(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}