import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String ans;

    public static void main(String[] args) {
        input();
        System.out.println(ans);
    }

    static void input() {
        int color = sc.nextInt();

        if(color >= 620) {
            ans = "Red";
        } else if(color >= 590) {
            ans = "Orange";
        } else if(color >= 570) {
            ans = "Yellow";
        } else if(color >= 495) {
            ans = "Green";
        } else if(color >= 450) {
            ans = "Blue";
        } else if(color >= 425) {
            ans = "Indigo";
        } else {
            ans = "Violet";
        }
    }
}