import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static int n;
    static String[] students;

    public static void main(String[] args) {
        int t = 1;

        while(true) {
            input();

            if(n == 0) break;

            ansMaker.append(t++).append(" ");
            findStudent();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        students = new String[n];

        sc.nextLine();

        for(int idx = 0; idx < n; idx++) {
            students[idx] = sc.nextLine();
        }
    }

    static void findStudent() {
        Set<Integer> bag = new HashSet<>();

        for(int idx = 0; idx < n * 2 - 1; idx++) {
            int sIdx = sc.nextInt();
            sc.next();

            if(bag.contains(sIdx)) {
                bag.remove(sIdx);
            } else {
                bag.add(sIdx);
            }
        }

        bag.forEach(num -> ansMaker.append(students[num - 1]).append("\n"));
    }

}