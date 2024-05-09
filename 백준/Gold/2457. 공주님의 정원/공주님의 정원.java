import java.util.*;

public class Main {
    static final Date START = new Date(3, 1);
    static final Date END = new Date(12, 1);
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static Flower[] flowers;

    public static void main(String[] args) {
        input();
        System.out.println(chooseFlowers() ? ans : 0);
    }

    static void input() {
        n = sc.nextInt();
        flowers = new Flower[n];

        for(int idx = 0; idx < n; idx++) {
            int startMonth = sc.nextInt();
            int startDay = sc.nextInt();
            int endMonth = sc.nextInt();
            int endDay = sc.nextInt();

            Date start = new Date(startMonth, startDay);
            Date end = new Date(endMonth, endDay);

            flowers[idx] = new Flower(start, end);
        }

        Arrays.sort(flowers, new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                if(o1.start.compareTo(o2.start) == 0) {
                    return o2.end.compareTo(o1.end);
                }

                return o1.start.compareTo(o2.start);
            }
        });

        ans = 0;
    }

    static boolean chooseFlowers() {
        Date start = START;
        Date end = new Date(0, 0);

        int flowerIdx = 0;

        while(start.compareTo(END) < 0) {
            boolean newFlower = false;

            for(int idx = flowerIdx; idx < n; idx++) {
                Flower now = flowers[idx];

                if(now.start.compareTo(start) > 0) break;

                if(now.end.compareTo(end) > 0) {
                    end = now.end;
                    flowerIdx = idx + 1;
                    newFlower = true;
                }
            }

            if(newFlower) {
                start = end;
                ans++;
            }
            else break;
        }

        return end.compareTo(END) >= 0;
    }

}

class Flower {
    Date start;
    Date end;

    public Flower(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
}

class Date implements Comparable<Date>{
    int month;
    int day;

    public Date(int month, int day) {
        this.month = month;
        this.day = day;
    }

    @Override
    public int compareTo(Date o) {
        if(o.month == this.month) return this.day - o.day;

        return this.month - o.month;
    }
}