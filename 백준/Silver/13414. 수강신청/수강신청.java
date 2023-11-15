import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int l, k;
    static Set<String> waitList;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        applyForClasses();
        System.out.print(ansMaker);
    }
    static void input() {
        k = sc.nextInt();
        l = sc.nextInt();
        waitList = new LinkedHashSet<>();
        ansMaker = new StringBuilder();

        for(int idx = 1; idx <= l; idx++) {
            String studentNumber = sc.next();
            if(waitList.contains(studentNumber))
                waitList.remove(studentNumber);
            waitList.add(studentNumber);
        }
    }

    static void applyForClasses() {
        Iterator<String> it = waitList.iterator();
        for(int idx = 0; idx < k && it.hasNext(); idx++) {
            ansMaker.append(it.next() + "\n");
        }
    }

}