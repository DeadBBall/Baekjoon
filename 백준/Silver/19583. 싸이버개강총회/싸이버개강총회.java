import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int s, e, q, ans;
    static Set<String> nicknames;

    public static void main(String[] args) {
        input();
        checkAttendance();
        System.out.println(ans);
    }

    static void input() {
        s = convertToInt(sc.next());
        e = convertToInt(sc.next());
        q = convertToInt(sc.next());

        nicknames = new HashSet<>();
    }

    static int convertToInt(String time) {
        String[] times = time.split(":");

        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    static void checkAttendance() {
        while(sc.hasNext()) {
            int time = convertToInt(sc.next());
            String nickname = sc.next();

            if(time <= s) nicknames.add(nickname);
            else if(time >= e && time <= q && nicknames.contains(nickname)) {
                nicknames.remove(nickname);
                ans++;
            }
        }
    }
}