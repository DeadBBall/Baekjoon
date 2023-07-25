import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n;
    static Set<String> set;

    static void input() {
        set = new HashSet<>();
        n = sc.nextInt();
        set.add("ChongChong");
    }

    static void countPeople() {
        for(int idx = 0; idx < n; idx++) {
            String a = sc.next();
            String b = sc.next();
            if(set.contains(a)) {
                set.add(b);
            }
            else if(set.contains(b)) {
                set.add(a);
            }
        }
    }

    public static void main(String[] args) {
        input();
        countPeople();
        System.out.println(set.size());
    }
}