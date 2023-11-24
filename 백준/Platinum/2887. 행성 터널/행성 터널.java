import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
//    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static long ans;
    static Planet[] planets;
    static Map<Integer, Integer>[] edges;
    static PriorityQueue<Edge> edgePQ;

    public static void main(String[] args) throws IOException {
        input();
        buildTunnel();
        System.out.println(ans);
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        planets = new Planet[n];
        edges = new HashMap[n];

        for(int planetIdx = 0; planetIdx < n; planetIdx++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z =Integer.parseInt(st.nextToken());
            planets[planetIdx] = new Planet(planetIdx, x, y, z);

            edges[planetIdx] = new HashMap<>();
        }
    }

    static void buildTunnel() {
        boolean[] visit = new boolean[n];

        edgePQ = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist - o2.dist;
            }
        });

        connectXEdge();
        connectYEdge();
        connectZEdge();

        edgePQ.add(new Edge(0, 0));

        while(!edgePQ.isEmpty()) {
            Edge now = edgePQ.remove();
            if(visit[now.end]) continue;
            visit[now.end] = true;
//            System.out.println("dist: " + now.dist + " end: " + now.end);
            ans += now.dist;

            for(int end : edges[now.end].keySet()) {
                if(visit[end]) continue;
                int dist = edges[now.end].get(end);
                edgePQ.add(new Edge(end, dist));
            }
        }
    }

    static void connectXEdge() {
        Arrays.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.x - o2.x;
            }
        });

        for(int planetIdx = 0; planetIdx < n - 1; planetIdx++) {
            Planet start = planets[planetIdx];
            Planet end = planets[planetIdx + 1];
//            System.out.println("planetIdx: " + planetIdx + " start: " + start.idx + " end: " + end.idx);
            edges[start.idx].put(end.idx, Math.abs(end.x - start.x));
            edges[end.idx].put(start.idx, Math.abs(end.x - start.x));
        }
    }

    static void connectYEdge() {
        Arrays.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.y - o2.y;
            }
        });

        for(int planetIdx = 0; planetIdx < n - 1; planetIdx++) {
            Planet start = planets[planetIdx];
            Planet end = planets[planetIdx + 1];
            if(edges[start.idx].containsKey(end.idx) && edges[start.idx].get(end.idx) <= Math.abs(end.y - start.y))
               ;
            else
                edges[start.idx].put(end.idx, Math.abs(end.y - start.y));
            if(edges[end.idx].containsKey(start.idx) && edges[end.idx].get(start.idx) <= Math.abs(end.y - start.y))
                ;
            else
                edges[end.idx].put(start.idx, Math.abs(end.y - start.y));
//            System.out.println("planetIdx: " + planetIdx + " start: " + start.idx + " end: " + end.idx);
        }
    }

    static void connectZEdge() {
        Arrays.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.z - o2.z;
            }
        });

        for(int planetIdx = 0; planetIdx < n - 1; planetIdx++) {
            Planet start = planets[planetIdx];
            Planet end = planets[planetIdx + 1];
            if(edges[start.idx].containsKey(end.idx) && edges[start.idx].get(end.idx) <= Math.abs(end.z - start.z))
                ;
            else
                edges[start.idx].put(end.idx, Math.abs(end.z - start.z));
            if(edges[end.idx].containsKey(start.idx) && edges[end.idx].get(start.idx) <= Math.abs(end.z - start.z))
                ;
            else
                edges[end.idx].put(start.idx, Math.abs(end.z - start.z));
//            System.out.println("planetIdx: " + planetIdx + " start: " + start.idx + " end: " + end.idx);
        }
    }

    static class Planet {
        int idx;
        int x;
        int y;
        int z;

        public Planet(int idx, int x, int y, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge {
        int end;
        int dist;

        public Edge(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }
}