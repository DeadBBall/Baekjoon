import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<String, String> map = new HashMap<>(Map.ofEntries(
            Map.entry("Algorithm", "204"),
            Map.entry("DataAnalysis", "207"),
            Map.entry("ArtificialIntelligence", "302"),
            Map.entry("CyberSecurity", "B101"),
            Map.entry("Network", "303"),
            Map.entry("Startup", "501"),
            Map.entry("TestStrategy", "105")
    ));
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();

        while(n-- > 0) {
            input();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        ansMaker.append(map.get(sc.next())).append("\n");
    }
}