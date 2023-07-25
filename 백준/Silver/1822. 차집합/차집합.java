import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    static int aCnt;
    static int bCnt;
    static Set<Integer> aSet;

    static void input() {
        aCnt = sc.nextInt();
        bCnt = sc.nextInt();
        aSet = new TreeSet<>();
        for(int idx = 0; idx < aCnt; idx++) {
            aSet.add(sc.nextInt());
        }
        for(int idx = 0; idx < bCnt; idx++) {
            int bNum = sc.nextInt();
            if(aSet.contains(bNum)) {
                aSet.remove(bNum);
            }
        }
    }

    static void print() {
        Iterator<Integer> it = aSet.iterator();
        while(it.hasNext()) {
            int now = it.next();
            sb.append(now).append(" ");
        }
        System.out.println(aSet.size());
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        print();
    }
}