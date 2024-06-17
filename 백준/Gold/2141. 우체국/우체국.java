import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static List<Town> towns;
    static long totalCnt;

    public static void main(String[] args){
        input();
        System.out.println(setUpPostOffice());
    }

    static void input() {
        n = sc.nextInt();
        towns = new ArrayList<>();

        while(n-- > 0) {
            long x = sc.nextLong();
            long a = sc.nextLong();

            towns.add(new Town(x, a));
            totalCnt += a;
        }

        totalCnt = (totalCnt + 1) >> 1;

        Collections.sort(towns, new Comparator<Town>() {
            @Override
            public int compare(Town o1, Town o2) {
                return Long.compare(o1.x, o2.x);
            }
        });
    }

    static long setUpPostOffice() {
        long nowCnt = 0;

        for(Town now : towns) {
            nowCnt += now.a;

            if(nowCnt >= totalCnt) return now.x;
        }

        return 0;
    }
}

class Town {
    long x;
    long a;

    Town(long x, long a) {
        this.x = x;
        this.a = a;
    }
}