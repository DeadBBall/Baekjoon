import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long a, b;
    static long[] counts;

    public static void main(String[] args) {
        input();
        System.out.println(countOne(b) - countOne(a - 1));
    }

    static void input() {
        a = sc.nextLong();
        b = sc.nextLong();

        counts = new long[55];

        counts[0] = 1;

        for (int size = 1; size < 55; size++) {
            counts[size] = (counts[size - 1] << 1) + (1L << size);
        }
    }

    static long countOne(long num) {
        long count = num & 1;

        int size = (int) (Math.log(num) / Math.log(2));

        for (int i = size; i > 0; i--) {
            if ((num & (1L << i)) != 0L) {
                count += counts[i - 1] + (num - (1L << i) + 1);
                num -= (1L << i);
            }
        }
        return count;
    }
}