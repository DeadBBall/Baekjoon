import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static Set<Character> shortcut;
    static StringBuilder ansMaker;
    static String[][] words;

    public static void main(String[] args) {
        input();
        designateShortcut();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        shortcut = new HashSet<>();
        ansMaker = new StringBuilder();
        sc.nextLine();

        words = new String[n][];

        for(int idx = 0; idx < n; idx++) {
            words[idx] = sc.nextLine().split(" ");
        }
    }

    static void designateShortcut() {
        for(int i = 0; i < n; i++) {
            boolean isPossible = false;

            for (int j = 0; j < words[i].length; j++) {
                String now = words[i][j];

                if (!shortcut.contains(Character.toUpperCase(now.charAt(0)))) {
                    isPossible = true;

                    shortcut.add(Character.toUpperCase(now.charAt(0)));

                    StringBuilder sb = new StringBuilder(now);

                    sb.insert(1, ']');
                    sb.insert(0, '[');

                    words[i][j] = sb.toString();

                    break;
                }
            }

            if (!isPossible) {
                for (int j = 0; j < words[i].length; j++) {
                    String now = words[i][j];

                    for (int k = 0; k < now.length(); k++) {

                        if (!shortcut.contains(Character.toUpperCase(now.charAt(k)))) {
                            shortcut.add(Character.toUpperCase(now.charAt(k)));

                            StringBuilder sb = new StringBuilder(now);

                            sb.insert(k + 1, ']');
                            sb.insert(k, '[');

                            words[i][j] = sb.toString();

                            isPossible = true;

                            break;
                        }
                    }

                    if(isPossible) break;
                }
            }

            Arrays.stream(words[i]).forEach(word -> ansMaker.append(word).append(" "));

            ansMaker.append("\n");
        }
    }
}