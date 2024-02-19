import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static int n;
    static long ans;
    static long[] heights;
    static int[] segTree;

    public static void main(String[] args) {
        while(true) {
            input();

            if(n == 0) break;

            makeSegTree(1, n, 1);
            checkAllSegTree(1, n);
            ansMaker.append(ans).append("\n");
        }
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();

        if(n == 0) return;

        heights = new long[n + 1];
        ans = 0;

        for(int rectangleIdx = 1; rectangleIdx <= n; rectangleIdx++) {
            heights[rectangleIdx] = sc.nextLong();
        }
        heights[0] = Integer.MAX_VALUE;

        segTree = new int[n * 4];
    }

    static int makeSegTree(int start, int end, int node) {
        if(start == end) {
            return segTree[node] = start;
        }

        int mid = (start + end) >> 1;

        int leftMinIdx = makeSegTree(start, mid, node * 2);
        int rightMinIdx = makeSegTree(mid + 1, end, node * 2 + 1);

        return segTree[node] = heights[leftMinIdx] > heights[rightMinIdx] ? rightMinIdx : leftMinIdx;
    }

    static void checkAllSegTree(int left, int right) {
        if(left > right) return;

        int minIdx = findMinIdx(1, n, left, right, 1);
        ans = Math.max(ans, heights[minIdx] * (right - left + 1));

        checkAllSegTree(left, minIdx - 1);
        checkAllSegTree(minIdx + 1, right);
    }

    static int findMinIdx(int start, int end, int left, int right, int node) {
        if(left > end || right < start) return 0;

        if(left <= start && end <= right) return segTree[node];

        int mid = (start + end) >> 1;

        int leftMinIdx = findMinIdx(start, mid, left, right, node * 2);
        int rightMinIdx = findMinIdx(mid + 1, end, left, right, node * 2 + 1);

        return heights[leftMinIdx] > heights[rightMinIdx] ? rightMinIdx : leftMinIdx;
    }

}