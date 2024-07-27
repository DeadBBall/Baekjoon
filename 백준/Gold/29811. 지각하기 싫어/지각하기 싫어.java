import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker;
    static TreeSet<Node>[] nodeSet;
    static int[] nodes;
    static int n, m;

    public static void main(String[] args) {
        input();
        go();
        System.out.print(ansMaker);
    }

    static void input() {
        nodeSet = new TreeSet[2];

        for(int idx = 0; idx < 2; idx++) {
            nodeSet[idx] = new TreeSet<>();
        }

        n = sc.nextInt();
        m = sc.nextInt();

        nodes = new int[n + m + 1];

        for(int nodeIdx = 1; nodeIdx <= n; nodeIdx++) {
            int value = sc.nextInt();

            nodeSet[0].add(new Node(nodeIdx, value));
            nodes[nodeIdx] = value;
        }

        for(int nodeIdx = n + 1; nodeIdx <= m + n; nodeIdx++) {
            int value = sc.nextInt();

            nodeSet[1].add(new Node(nodeIdx, value));
            nodes[nodeIdx] = value;
        }

        ansMaker = new StringBuilder();
    }

    static void go() {
        int k = sc.nextInt();

        while(k-- > 0) {
            String type = sc.next();

            if(type.equals("U")) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                if(x > n) {
                    nodeSet[1].remove(new Node(x, nodes[x]));
                    nodeSet[1].add(new Node(x, y));
                    nodes[x] = y;
                } else {
                    nodeSet[0].remove(new Node(x, nodes[x]));
                    nodeSet[0].add(new Node(x, y));
                    nodes[x] = y;
                }
            } else {
                ansMaker.append(nodeSet[0].first().idx).append(" ").append(nodeSet[1].first().idx).append("\n");
            }
        }
    }
}

class Node implements Comparable<Node>{
    int idx;
    int value;

    public Node(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        if(this.value == o.value) {
            return this.idx - o.idx;
        }

        return this.value - o.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;
        return idx == node.idx;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idx);
    }
}