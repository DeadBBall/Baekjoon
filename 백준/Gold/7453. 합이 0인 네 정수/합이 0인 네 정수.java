import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
//    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static long ans;
    static int[] aPlusB;
    static int[] cPlusD;

    public static void main(String[] args) throws IOException {
        input();
        countZero();
        System.out.println(ans);
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        aPlusB = new int[n * n];
        cPlusD = new int[n * n];

        int[] aArr = new int[n];
        int[] bArr = new int[n];
        int[] cArr = new int[n];
        int[] dArr = new int[n];

        for(int numIdx = 0; numIdx < n; numIdx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            aArr[numIdx] = Integer.parseInt(st.nextToken());
            bArr[numIdx] = Integer.parseInt(st.nextToken());
            cArr[numIdx] = Integer.parseInt(st.nextToken());
            dArr[numIdx] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;

        for(int left = 0; left < n; left++) {
            for(int right = 0; right < n; right++) {
                aPlusB[idx] = aArr[left] + bArr[right];
                cPlusD[idx++] = cArr[left] + dArr[right];
            }
        }

        Arrays.sort(aPlusB);
        Arrays.sort(cPlusD);
    }

    static void countZero() {
        int aPlusBIdx = 0;
        int cPlusDIdx = n * n - 1;

        while(aPlusBIdx < n * n && cPlusDIdx >= 0) {
            int sum = aPlusB[aPlusBIdx] + cPlusD[cPlusDIdx];

            if(sum == 0) {
                long aCount = 1;
                long cCount = 1;

                while(aPlusBIdx + 1 < n * n && aPlusB[aPlusBIdx] == aPlusB[aPlusBIdx + 1]) {
                    aCount++;
                    aPlusBIdx++;
                }

                while(cPlusDIdx > 0 && cPlusD[cPlusDIdx] == cPlusD[cPlusDIdx - 1]) {
                    cCount++;
                    cPlusDIdx--;
                }

                ans += aCount * cCount;
                aPlusBIdx++;
            }
            else if(sum > 0) {
                cPlusDIdx--;
            }
            else {
                aPlusBIdx++;
            }
        }
    }

}
