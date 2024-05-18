import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String ans;
    static int n;
    static String[] names;

    public static void main(String[] args) {
        input();
        lineUp();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        names = new String[n];

        for(int idx = 0; idx < n; idx++) {
            names[idx] = sc.next();
        }
    }

    static void lineUp() {
        int flag = 0;

        for(int idx = 0; idx < n - 1; idx++) {
            if(names[idx].compareTo(names[idx + 1]) > 0) {
                if(flag != -1) {
                    flag = 1;
                }
                else {
                    ans = "NEITHER";
                    return;
                }
            }
            else {
                if(flag != 1) {
                    flag = -1;
                }
                else {
                    ans = "NEITHER";
                    return;
                }
            }
        }

        ans = flag == 1 ? "DECREASING" : "INCREASING";
    }

}