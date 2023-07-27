import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int hour;
    static int minute;
    static int second;
    static int time;

    static void input() {
        hour = sc.nextInt();
        minute = sc.nextInt();
        second = sc.nextInt();
        time = sc.nextInt();
    }

    static void cook() {
        int allTime = (hour * 60 + minute) * 60 + second + time;
        second = allTime % 60;
        minute = (allTime / 60) % 60;
        hour = (allTime / 3600) % 24;
    }

    public static void main(String[] args) {
        input();
        cook();
        System.out.println(hour + " " + minute + " " + second);
    }
}