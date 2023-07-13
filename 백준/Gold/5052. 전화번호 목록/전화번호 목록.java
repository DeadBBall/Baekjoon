import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static String[] arr;
    static boolean ans;

    static void input() {
        n = sc.nextInt();
        arr = new String[n];
        ans = true;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
    }

    static void searchNumber() {
        Node start = new Node();
        for(int i = 0; i < n; i++) {
            Node now = start;
            for(int j = 0; j < arr[i].length(); j++) {
                int num = arr[i].charAt(j) - '0';
                if(!now.next.containsKey(num)) {
                    now.next.put(num, new Node());
                }
                now = now.next.get(num);
                if(now.end) {
                    ans = false;
                }
                if(j == arr[i].length() - 1) {
                    now.end = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int t;
        t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            input();
            searchNumber();
            System.out.println(ans ? "YES" : "NO");
        }
    }

    static class Node {
        Map<Integer, Node> next;
        boolean end;

        public Node() {
            end = false;
            next = new HashMap<>();
        }
    }
}