import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, l, ans;
    static List<Puddle> puddles;

    public static void main(String[] args) {
        input();
        countPlank();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        l = sc.nextInt();
        puddles = new ArrayList<>();

        for(int puddleIdx = 0; puddleIdx < n; puddleIdx++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            puddles.add(new Puddle(start, end));
        }

        Collections.sort(puddles, new Comparator<Puddle>() {
            @Override
            public int compare(Puddle a, Puddle b) {
                return a.start - b.start;
            }
        });
    }

    static void countPlank() {
        Puddle prev = puddles.get(0);
        int plankCount = (prev.end - prev.start + l - 1) / l;
        ans += plankCount;

        int prevPlank = prev.start + plankCount * l;

        for(int puddleIdx = 1; puddleIdx < n; puddleIdx++) {
            Puddle now = puddles.get(puddleIdx);

            if(prevPlank < now.start) {
                plankCount = (now.end - now.start + l - 1) / l;
                prevPlank = now.start + plankCount * l;
            }
            else {
                plankCount = (now.end - prevPlank + l - 1) / l;
                prevPlank += plankCount * l;
            }

            ans += plankCount;
        }
    }
}

class Puddle {
    int start;
    int end;

    public Puddle(int start, int end) {
        this.start = start;
        this.end = end;
    }
}