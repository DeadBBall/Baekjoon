import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[] heightOfRectangles;
    static int[] segTree;

    public static void main(String[] args) {
        input();
        makeSegTree(1, 1, n);
        checkAll(1, n);
        System.out.println(ans);
    }
    static void input() {
        n = sc.nextInt();
        heightOfRectangles = new int[n + 1];
        segTree = new int[n * 4];

        for(int rectangleIdx = 1; rectangleIdx <= n; rectangleIdx++) {
            heightOfRectangles[rectangleIdx] = sc.nextInt();
        }
        heightOfRectangles[0] = Integer.MAX_VALUE;
    }

    static int makeSegTree(int node, int start, int end) {
        if(start == end) {
            return segTree[node] = start;
        }

        int mid = (start + end) >> 1;
        int leftMin = makeSegTree(node * 2, start, mid);
        int rightMin = makeSegTree(node * 2 + 1, mid + 1, end);

        return segTree[node] = heightOfRectangles[leftMin] < heightOfRectangles[rightMin] ? leftMin : rightMin;
    }

    static void checkAll(int left, int right) {
        if(left > right) return;

        int minIdx = findMin(1, 1, n, left, right);
        ans = Math.max(ans, heightOfRectangles[minIdx] * (right - left + 1));

        checkAll(left, minIdx - 1);
        checkAll(minIdx + 1, right);
    }

    static int findMin(int node, int start, int end, int left, int right) {
        if(left > end || right < start) return 0;

        if(left <= start & end <= right) return segTree[node];

        int mid = (start + end) >> 1;

        int leftMin = findMin(node * 2, start, mid, left, right);
        int rightMin = findMin(node * 2 + 1, mid + 1, end, left, right);

        return heightOfRectangles[leftMin] < heightOfRectangles[rightMin] ? leftMin : rightMin;
    }

}