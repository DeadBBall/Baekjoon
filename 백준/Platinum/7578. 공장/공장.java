import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long ans;
    static int[] tree;
    static int[] aMachines;
    static Map<Integer, Integer> bMachines;

    public static void main(String[] args) {
        input();
        count();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        tree = new int[n * 4];
        aMachines = new int[n];
        bMachines = new HashMap<>();

        for(int idx = 0; idx < n; idx++) {
            aMachines[idx] = sc.nextInt();
        }

        for(int idx = 0; idx < n; idx++) {
            bMachines.put(sc.nextInt(), idx);
        }
    }

    static void count() {
        for(int machine : aMachines) {
            int idx = bMachines.get(machine);

            ans += sum(0, n - 1, 1, idx + 1, n - 1);

            update(0, n - 1, 1, idx);
        }
    }

    static int sum(int left, int right, int node, int start, int end) {
        if(start > right || left > end) return 0;

        if(start <= left && right <= end) return tree[node];

        int mid = (left + right) >> 1;

        return sum(left, mid, node * 2, start, end) + sum(mid + 1, right, node * 2 + 1, start, end);
    }

    static void update(int left, int right, int node, int idx) {
        if(idx < left || right < idx) return;

        tree[node]++;

        if(left == right) return;

        int mid = (left + right) >> 1;

        update(left, mid, node * 2, idx);
        update(mid + 1, right, node * 2 + 1, idx);
    }
}