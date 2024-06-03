import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, s;
    static int[] a;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        sort();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        a = new int[n];

        for(int idx = 0; idx < n; idx++) {
            a[idx] = sc.nextInt();
        }

        s = sc.nextInt();
        ansMaker = new StringBuilder();
    }

    static void sort() {
        int start = 0;

        while(s > 0 && start < n) {
            int max = -1;
            int maxIdx = -1;

            for(int idx = start; idx <= start + s && idx < n; idx++) {
                if(max < a[idx]) {
                    maxIdx = idx;
                    max = a[idx];
                }
            }
            
            for(int idx = maxIdx; idx > start; idx--) {
                swap(idx, idx - 1);
                s--;
            }

            start++;
        }

        for(int num : a) {
            ansMaker.append(num).append(" ");
        }
    }

    static void swap(int idx, int idx2) {
        int tmp = a[idx];
        a[idx] = a[idx2];
        a[idx2] = tmp;
    }
}