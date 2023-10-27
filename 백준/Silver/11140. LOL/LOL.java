import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String word;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0) {
            input();
            ansMaker.append(searchlol() + "\n");
        }
        System.out.print(ansMaker);
    }
    static void input() {
        word = sc.next();
    }

    static int searchlol() {
        if(word.contains("lol")) return 0;
        if(word.contains("lo") || word.contains("ol") || word.matches("(.*)l(?:[a-z]l|l)(.*)")) return 1;
        if(word.contains("l") || word.contains("o")) return 2;
        return 3;
    }

}