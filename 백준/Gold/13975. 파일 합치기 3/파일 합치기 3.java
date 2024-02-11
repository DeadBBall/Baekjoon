import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static int k;
    static PriorityQueue<Long> files;

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0) {
            input();
            combineFiles();
        }
        System.out.print(ansMaker);
    }

    static void input() {
        k = sc.nextInt();
        files = new PriorityQueue<>();

        for(int fileIdx = 0; fileIdx < k; fileIdx++) {
            files.add(sc.nextLong());
        }

    }

    static void combineFiles() {
        long sum = 0;

        while(k -- > 1) {
            long newFile = files.remove() + files.remove();
            sum += newFile;
            files.add(newFile);
        }

        ansMaker.append(sum).append("\n");
    }

}