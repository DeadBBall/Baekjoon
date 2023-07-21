import java.util.*;

public class Main {

    static Map<String, Long> woodMap;
    static Scanner sc = new Scanner(System.in);
    static int woodCount;

    static void input() {
        woodMap = new TreeMap<>();
        while(sc.hasNext()) {
            String nowWood = sc.nextLine();
            if(woodMap.containsKey(nowWood)) {
                long count = woodMap.get(nowWood);
                woodMap.put(nowWood, count + 1);
            }
            else {
                woodMap.put(nowWood, 1L);
            }
            woodCount++;
        }
    }

    static void analyzeWood() {
        for(String key : woodMap.keySet()) {
            System.out.printf("%s %.4f\n", key, (Math.round(woodMap.get(key) * 1000000 / (double)woodCount)) / 10000.0);
        }
    }

    public static void main(String[] args) {
        input();
        analyzeWood();
    }
}