import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static StringBuilder ansMaker;
    static TreeSet<Problem> sortedSet;
    static Map<Integer, Integer> problems;

    public static void main(String[] args) throws IOException {
        input();
        recommend();
        System.out.print(ansMaker);
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        sortedSet = new TreeSet<>();
        problems = new HashMap<>();

        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            sortedSet.add(new Problem(p, l));
            problems.put(p, l);
        }

        ansMaker = new StringBuilder();
    }

    static void recommend() throws IOException {
        m = Integer.parseInt(br.readLine());

        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            if(type.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                sortedSet.add(new Problem(p, l));
                problems.put(p, l);
            } else if(type.equals("recommend")) {
                int drct = Integer.parseInt(st.nextToken());

                if(drct == 1) {
                    ansMaker.append(sortedSet.last().idx).append("\n");
                } else {
                    ansMaker.append(sortedSet.first().idx).append("\n");
                }
            } else {
                int p = Integer.parseInt(st.nextToken());
                int l = problems.get(p);
                
                sortedSet.remove(new Problem(p, l));
                problems.remove(p);
            }
        }
    }
}

class Problem implements Comparable<Problem> {
    int idx;
    int level;

    public Problem(int idx, int level) {
        this.idx = idx;
        this.level = level;
    }

    @Override
    public int compareTo(Problem o){
        if(level == o.level){
            return Integer.compare(idx, o.idx);
        } else{
            return Integer.compare(level, o.level);
        }
    }
}