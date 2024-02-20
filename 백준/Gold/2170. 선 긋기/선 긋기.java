import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
//    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, ans;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        input();
        measureLength();
        System.out.println(ans);
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        edges = new Edge[n];

        for(int edgeIdx = 0; edgeIdx < n; edgeIdx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges[edgeIdx] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge a, Edge b) {
                if(a.start == b.start)
                    return b.end - a.end;
                return a.start - b.start;
            }
        });
    }

    static void measureLength() {
        Edge prev = edges[0];
        ans += prev.end - prev.start;

        for(Edge now : edges) {
            if(prev.end >= now.end) ;
            else if(prev.end < now.end && prev.end > now.start) {
                ans += now.end - prev.end;
                prev.end = now.end;
            }
            else {
                ans += now.end - now.start;
                prev = now;
            }
        }
    }
}

class Edge {
    int start;
    int end;

    public Edge(int start, int end) {
        this.start = start;
        this.end = end;
    }
}