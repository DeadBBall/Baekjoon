import java.util.*;

public class Main {
    static final int SIZE = 1_000_000;
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] tree;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        findCandy();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        tree = new int[SIZE * 4 + 1];
        ansMaker = new StringBuilder();
    }

    static void findCandy() {
        while(n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a == 1) {
                int idx = find(0, SIZE, 1, b);

                ansMaker.append(idx).append("\n");

                update(0, SIZE, 1, idx, -1);
            } else {
                int c = sc.nextInt();
                update(0, SIZE, 1, b, c);
            }
        }
    }

    static int find(int left, int right, int node, int rank) {
        if(left == right) return left;

        int mid = (left + right) >> 1;

        if(rank <= tree[node * 2]) {
            return find(left, mid, node * 2, rank);
        } else {
            return find(mid + 1, right, node * 2 + 1, rank - tree[node * 2]);
        }
    }

    static void update(int left, int right, int node, int idx, int cnt) {
        if(idx < left || right < idx) return;

        tree[node] += cnt;

        if(left == right) return;

        int mid = (left + right) >> 1;

        update(left, mid, node * 2, idx, cnt);
        update(mid + 1, right, node * 2 + 1, idx, cnt);
    }
}