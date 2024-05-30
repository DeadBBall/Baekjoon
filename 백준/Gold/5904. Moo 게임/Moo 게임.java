import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;

    public static void main(String[] args) {
        input();
        playMooGame(n,0, 0);
    }

    static void input() {
        n = sc.nextInt();
    }

    static void playMooGame(int input, int k, int prev) {
        int totalLen = prev * 2 + k + 3;

        if(input <= 3) {
            System.out.println(input == 1 ? "m" : "o");
            return;
        }

        if(input <= totalLen) {
            if(input <= prev + k + 3) {
                System.out.println(input == prev + 1 ? "m" : "o");
            }
            else {
                playMooGame(input - (prev + k + 3), 0, 0);
            }
        }
        else {
            playMooGame(input, k + 1, totalLen);
        }
    }

}