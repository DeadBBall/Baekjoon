import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static String[] voices;
    static Map<String, String> animals;

    public static void main(String[] args) {
        int t = Integer.parseInt(sc.nextLine());

        while(t-- > 0) {
            input();
            findFox();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        voices = sc.nextLine().split(" ");

        animals = new HashMap<>();

        while(true) {
            String[] inputStr = sc.nextLine().split(" ");

            if(inputStr[0].equals("what")) break;

            animals.put(inputStr[2], inputStr[0]);
        }
    }

    static void findFox() {
        for(String voice : voices) {
            if(!animals.containsKey(voice)) {
                ansMaker.append(voice).append(" ");
            }
        }
        ansMaker.append("\n");
    }

}