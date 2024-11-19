import java.util.*;

public class Main {
    static final int SIZE = 9;
    static Scanner sc = new Scanner(System.in);
    static Picture[] pictures;
    static int n, ans, hapCnt;
    static Map<Integer, Map<Integer, Set<Integer>>> ghMap;

    public static void main(String[] args) {
        input();
        playGame();
        System.out.println(ans);
    }


    static void input() {
        pictures = new Picture[SIZE + 1];

        for(int idx = 1; idx <= SIZE; idx++) {
            pictures[idx] = new Picture(sc.next(), sc.next(), sc.next());
        }

        ghMap = new HashMap<>();

        for(int i = 1; i < SIZE - 1; i++) {
            for(int j = i + 1; j < SIZE; j++) {
                for(int k = j + 1; k <= SIZE; k++) {
                    if(isHap(pictures[i], pictures[j], pictures[k])) {
                        if(!ghMap.containsKey(i)) {
                            ghMap.put(i, new HashMap<>());
                        }

                        Map<Integer, Set<Integer>> nowMap = ghMap.get(i);

                        if(!nowMap.containsKey(j)) {
                            nowMap.put(j, new HashSet<>());
                        }

                        nowMap.get(j).add(k);

                        hapCnt++;
                    }
                }
            }
        }

        n = sc.nextInt();
    }

    static boolean isHap(Picture a, Picture b, Picture c) {
        Set<String> color = new HashSet<>();
        Set<String> shape = new HashSet<>();
        Set<String> background = new HashSet<>();

        color.add(a.color);
        shape.add(a.shape);
        background.add(a.background);

        color.add(b.color);
        shape.add(b.shape);
        background.add(b.background);

        color.add(c.color);
        shape.add(c.shape);
        background.add(c.background);

        if(color.size() == 2) return false;
        if(shape.size() == 2) return false;
        if(background.size() == 2) return false;

        return true;
    }

    static void playGame() {
        boolean gyeol = false;

        while(n-- > 0) {
            String command = sc.next();

            if(command.equals("H")) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();

                int[] arr = new int[]{a, b, c};

                Arrays.sort(arr);

                if(ghMap.containsKey(arr[0])) {
                    Map<Integer, Set<Integer>> nowMap = ghMap.get(arr[0]);

                    if(nowMap.containsKey(arr[1])) {
                        if(nowMap.get(arr[1]).contains(arr[2])) {
                            nowMap.get(arr[1]).remove(arr[2]);
                            ans++;
                            hapCnt--;
                        } else {
                            ans--;
                        }
                    } else {
                        ans--;
                    }
                } else {
                    ans--;
                }
            } else {
                if(hapCnt == 0 && !gyeol) {
                    ans += 3;
                    gyeol = true;
                } else {
                    ans--;
                }
            }
        }
    }
}

class Picture {
    String shape;
    String color;
    String background;

    public Picture(String shape, String color, String background) {
        this.shape = shape;
        this.color = color;
        this.background = background;
    }
}