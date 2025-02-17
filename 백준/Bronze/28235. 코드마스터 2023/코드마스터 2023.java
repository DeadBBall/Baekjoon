import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String ans;

    public static void main(String[] args) {
        input();
        System.out.println(ans);
    }

    static void input() {
        switch (sc.next()) {
            case "SONGDO": ans = "HIGHSCHOOL";
            break;
            case "CODE": ans = "MASTER";
            break;
            case "2023": ans = "0611";
            break;
            default: ans = "CONTEST";
            break;
        }
    }
}