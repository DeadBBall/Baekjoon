import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] solution;
    static long ans;
    static int[] ansArr;

    static void input() {
        n = sc.nextInt();
        solution = new int[n];
        ansArr = new int[3];
        ans = 3000000001L;
        for(int i = 0; i < n; i++) {
            solution[i] = sc.nextInt();
        }
        Arrays.sort(solution);
    }

    static void searchSolution() {
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                long sum = solution[i] + solution[j];
                int start = j + 1;
                int end = n - 1;
                while(start <= end) {
                    int mid = (start + end) / 2;
                    long newSum = sum + solution[mid];
                    if(newSum > 0) {
                        if(Math.abs(newSum) < ans) {
                            ans = Math.abs(newSum);
                            ansArr[0] = solution[i];
                            ansArr[1] = solution[j];
                            ansArr[2] = solution[mid];
                        }
                        end = mid - 1;
                    }
                    else {
                        if(Math.abs(newSum) < ans) {
                            ans = Math.abs(newSum);
                            ansArr[0] = solution[i];
                            ansArr[1] = solution[j];
                            ansArr[2] = solution[mid];
                        }
                        start = mid + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        searchSolution();
        System.out.println(ansArr[0] + " " + ansArr[1] + " " + ansArr[2]);
      }
}