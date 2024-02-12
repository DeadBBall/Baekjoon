import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static List<Integer> boxes;
    static int[] cranes;

    public static void main(String[] args) {
        input();
        moveBoxes();
        System.out.println(ans == 0 ? -1 : ans);
    }

    static void input() {
        n = sc.nextInt();
        cranes = new int[n];

        for(int craneIdx = 0; craneIdx < n; craneIdx++) {
            cranes[craneIdx] = sc.nextInt();
        }

        Arrays.sort(cranes);

        m = sc.nextInt();
        boxes = new ArrayList<>(m);

        while(m-- > 0) {
            boxes.add(sc.nextInt());
        }
        Collections.sort(boxes);
    }

    static void moveBoxes() {
        if(boxes.get(boxes.size() - 1) > cranes[n - 1]) return;

        while(!boxes.isEmpty()) {
            ans++;
            int craneIdx = n - 1;
            int boxIdx = boxes.size() - 1;

            while(craneIdx >= 0) {
                while(boxIdx >= 0) {
                    if(boxes.get(boxIdx) <= cranes[craneIdx]) {
                        boxes.remove(boxIdx--);
                        break;
                    }
                    boxIdx--;
                }
                craneIdx--;
            }
        }
    }
}