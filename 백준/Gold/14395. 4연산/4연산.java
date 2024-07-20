import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long s, t;

    public static void main(String[] args) {
        input();
        calculate();
    }

    static void input() {
        s = sc.nextLong();
        t = sc.nextLong();
    }

    static void calculate() {
        if(s == t) {
            System.out.println(0);
            return;
        }

        Queue<Calculation> calculations = new LinkedList<>();
        calculations.add(new Calculation(s));

        Set<Long> visit = new HashSet<>();
        visit.add(s);

        while(!calculations.isEmpty()) {
            Calculation now = calculations.remove();

            if(now.value == t) {
                for (Character sign : now.signs) {
                    System.out.print(sign);
                }
                return;
            }

            if(!visit.contains(now.value * now.value) && now.value * now.value <= t) {
                Calculation next = new Calculation(now.value * now.value);
                next.signs = new ArrayList<>(now.signs);
                next.signs.add('*');
                calculations.add(next);
                visit.add(now.value * now.value);
            }

           if(!visit.contains(now.value + now.value) && now.value + now.value <= t) {
                Calculation next = new Calculation(now.value + now.value);
                next.signs = new ArrayList<>(now.signs);
                next.signs.add('+');
                calculations.add(next);
                visit.add(now.value + now.value);
            }

           if(!visit.contains(0L)) {
               Calculation next = new Calculation(0);
               next.signs = new ArrayList<>(now.signs);
               next.signs.add('-');
               calculations.add(next);
               visit.add(0L);
           }

            if(now.value != 0 && !visit.contains(1L)) {
                Calculation next = new Calculation(1);
                next.signs = new ArrayList<>(now.signs);
                next.signs.add('/');
                calculations.add(next);
                visit.add(1L);
            }
        }

        System.out.println(-1);
    }

}

class Calculation {
    long value;
    List<Character> signs;

    public Calculation(long value) {
        this.value = value;
        this.signs = new ArrayList<>();
    }

    public void addSign(char sign) {
        signs.add(sign);
    }
}