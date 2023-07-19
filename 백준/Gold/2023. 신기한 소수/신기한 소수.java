import java.sql.Array;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static Set<Integer> primeNumbers;

    static List<Integer> ansList;
    static void input() {
        n = sc.nextInt();
        ansList = new ArrayList<>();
        primeNumbers = new HashSet<>();
        primeNumbers.add(2);
    }

    static int checkPrimeNumber(int number) {
        int mod = (int)Math.pow(10, n - 1);
        int count = 1;
        while(mod != 0) {
            int now = number / mod;
            if (now == 1) {
                return 1;
            }
            if (!primeNumbers.contains(now)) {
                for (int index = 2; index <= Math.sqrt(now); index++) {
                    if (now % index == 0) {
                        return count;
                    }
                }
                primeNumbers.add(now);
            }
            mod /= 10;
            count++;
        }
        return count;
    }

    static int getLengthOfNumber(int number) {
        int length = 0;
        while(number > 0) {
            number /= 10;
            length++;
        }
        return length;
    }

    static void searchAmazingPrimeNumber() {
        int start = (int)Math.pow(10, n - 1);
        int end = (int)Math.pow(10, n) - 1;
        for(int index = start; index <= end; index++) {
            int count = checkPrimeNumber(index);
            if(count == n + 1) {
                ansList.add(index);
            }
            else {
                index /= (int)Math.pow(10, n - count);
                index++;
                index *= (int)Math.pow(10, n - count);
                index--;
            }
        }
    }

    public static void main(String[] args) {
        input();
        searchAmazingPrimeNumber();
        for(int ans : ansList) {
            System.out.println(ans);
        }
    }
}
