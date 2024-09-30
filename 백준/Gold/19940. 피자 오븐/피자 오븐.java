import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            useOven();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
    }

    static void useOven() {
        int addh = 0;
        int addt = 0;
        int mint = 0;
        int addo = 0;
        int mino = 0;

        addh = n / 60;
        n %= 60;

        if(n <= 35) {
            if(n % 10 > 5) {
                addt = n / 10 + 1;
                mino = 10 - n % 10;
            } else {
                addt = n / 10;
                addo = n % 10;
            }
        } else {
            addh++;

            if(n % 10 >= 5) {
                mint = 6 - (n / 10 + 1);
                mino = 10 - n % 10;
            } else {
                mint = 6 - n / 10;
                addo = n % 10;
            }
        }

        ansMaker.append(addh).append(" ").append(addt).append(" ").append(mint).append(" ")
                .append(addo).append(" ").append(mino).append("\n");
    }

}