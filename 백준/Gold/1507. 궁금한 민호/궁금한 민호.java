import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[][] dists;

    public static void main(String[] args) {
        input();
        System.out.println(findRoads());
    }

    static void input() {
        n = sc.nextInt();
        dists = new int[n][n];

        for(int left = 0; left < n; left++) {
            for(int right = 0; right < n; right++) {
                int dist = sc.nextInt();

                dists[left][right] = dist;
            }
        }
    }

    static int findRoads() {
        int sum = 0;

        int[][] copiedDists = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int dist = dists[i][j];

                for(int k = 0; k < n; k++) {
                    copiedDists[i][j] = dist;

                    if(j == k || i == k) continue;

                    if(dist > dists[i][k] + dists[k][j]) return -1;

                    if(dist == dists[i][k] + dists[k][j]) {
                        copiedDists[i][j] = 0;
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sum += copiedDists[i][j];
            }
        }

        return sum / 2;
    }
}