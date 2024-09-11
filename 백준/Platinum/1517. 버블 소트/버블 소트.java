import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] numbers, sortedNumbers;
    static long ans;

    public static void main(String[] args) {
        input();
        mergeSort(0, n - 1);
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        numbers = new int[n];
        sortedNumbers = new int[n];

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextInt();
        }
    }

    static void mergeSort(int low, int high) {
        if(low < high) {
            int mid = (low + high) >> 1;

            mergeSort(low, mid);
            mergeSort(mid + 1,  high);
            merge(low, mid, high);
        }
    }

    static void merge(int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int idx = low;

        while(left <= mid && right <= high) {
            if(numbers[left] <= numbers[right]) {
                sortedNumbers[idx++] = numbers[left++];
            } else {
                sortedNumbers[idx++] = numbers[right++];
                ans += (mid + 1 - left);
            }
        }

        while(left <= mid) {
            sortedNumbers[idx++] = numbers[left++];
        }

        while(right <= high) {
            sortedNumbers[idx++] = numbers[right++];
        }

        for(int i = low; i <= high; i++) {
            numbers[i] = sortedNumbers[i];
        }
    }
}