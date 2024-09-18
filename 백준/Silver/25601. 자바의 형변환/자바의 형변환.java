import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static Map<String, Integer> classMap;
    static Set<String>[] tree;

    public static void main(String[] args) {
        input();
        System.out.println(checkConversion());
    }

    static void input() {
        n = sc.nextInt();
        tree = new HashSet[n];

        for(int idx = 0; idx < n; idx++) {
            tree[idx] = new HashSet<String>();
        }

        classMap = new HashMap<>();

        int treeIdx = 0;

        for(int idx = 0; idx < n - 1; idx++) {
            String a = sc.next();
            String b = sc.next();

            if(!classMap.containsKey(b)) {
                classMap.put(b, treeIdx++);
            }

            tree[classMap.get(b)].add(a);

            if(!classMap.containsKey(a)) {
                classMap.put(a, treeIdx++);
            }
        }
    }

    static int checkConversion() {
        String a = sc.next();
        String b = sc.next();

        Queue<String> classQueue = new LinkedList<>();
        classQueue.add(a);

        while(!classQueue.isEmpty()) {
            String now = classQueue.remove();

            int idx = classMap.get(now);

            Set<String> nowSet = tree[idx];

            if(nowSet.contains(b)) return 1;

            classQueue.addAll(nowSet);
        }

        classQueue.add(b);

        while(!classQueue.isEmpty()) {
            String now = classQueue.remove();

            int idx = classMap.get(now);

            Set<String> nowSet = tree[idx];

            if(nowSet.contains(a)) return 1;

            classQueue.addAll(nowSet);
        }

        return 0;
    }
}