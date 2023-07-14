import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static boolean ans;

    static void input() {
        n = sc.nextInt();
        ans = true;
    }

    static void searchNumber() {
        Node start = new Node();
        for(int i = 0; i < n; i++) {
            Node now = start;
            String str = sc.next();
            if(!ans) {
                continue;
            }
            for(int j = 0; j < str.length(); j++) {
                int num = str.charAt(j) - '0';
                if(!now.next.containsKey(num)) {
                    now.next.put(num, new Node());
                }
                now = now.next.get(num);
                if(now.end) {
                    ans = false;
                }
                if(j == str.length() - 1) {
                    now.end = true;
                    if(now.next.size() > 0) {
                        ans = false;
                    }
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