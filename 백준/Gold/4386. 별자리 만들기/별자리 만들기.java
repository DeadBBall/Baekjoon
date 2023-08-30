import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static float[][] stars;
    static Line[] lines;
    static int[] parents;
    static float ans;

    public static void main(String[] args) {
        input();
        mst();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        stars = new float[n][2];
        lines = new Line[n * (n - 1) / 2];
        parents = new int[n];

        for(int starIdx = 0; starIdx < n; starIdx++) {
            stars[starIdx][0] = sc.nextFloat();
            stars[starIdx][1] = sc.nextFloat();
            parents[starIdx] = starIdx;
        }

        int lineIdx = 0;

        for(int start = 0; start < n - 1; start++) {
            for(int end = start + 1; end < n; end++) {
                lines[lineIdx++] = new Line(start, end);
            }
        }

        Arrays.sort(lines, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return Float.compare(o1.dist, o2.dist);
            }
        });

    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;

        if(x < y) parents[y] = x;

        else parents[x] = y;
    }

    static int find(int x) {
        if(parents[x] == x) return x;

        return parents[x] = find(parents[x]);
    }

    static void mst() {
        int lineCnt = 0;
        for(int i = 0; i < lines.length; i++) {
            if(lineCnt == n - 1) break;

            Line nowLine = lines[i];
            int x = find(nowLine.start);
            int y = find(nowLine.end);

            if(x != y) {
                union(x, y);
                ans += nowLine.dist;
                lineCnt++;
            }
        }
    }

    static class Line {
        int start;
        int end;
        float dist;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
            this.dist = calculateDist();
        }

        public float calculateDist() {
            float xStart = stars[start][0];
            float yStart = stars[start][1];
            float xEnd = stars[end][0];
            float yEnd = stars[end][1];

            return (float)Math.sqrt(Math.pow(xStart - xEnd, 2) + Math.pow(yStart - yEnd, 2));
        }
    }

}