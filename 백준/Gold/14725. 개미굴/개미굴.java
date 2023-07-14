import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static Node node;

    static void input() {
        n = sc.nextInt();
    }

    static void searchAntNest() {
        node = new Node();
        for(int i = 0; i < n; i++) {
            Node now = node;
            int k = sc.nextInt();
            for(int j = 0; j < k; j++) {
                String str = sc.next();
                if(!now.next.containsKey(str)) {
                    now.next.put(str, new Node());
                }
                now = now.next.get(str);
            }
        }
    }

    static void printAns(Node now, int depth) {
        for(String key : now.next.keySet()) {
            for(int i = 0; i < depth; i++) {
                System.out.print("--");
            }
            System.out.println(key);
            printAns(now.next.get(key), depth + 1);
        }
    }

    public static void main(String[] args) {
        input();
        searchAntNest();
        printAns(node, 0);
    }

    static class Node {
        Map<String, Node> next;

        public Node() {
            next = new TreeMap<>();
        }
    }
}