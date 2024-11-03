import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static Integer[] costs;
    static PriorityQueue<Device> devices;

    public static void main(String[] args) {
        input();
        charge();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        costs = new Integer[n];

        for(int idx = 0; idx < n; idx++) {
            costs[idx] = sc.nextInt();
        }

        Arrays.sort(costs, Collections.reverseOrder());

        devices = new PriorityQueue<>(new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                return o1.end - o2.end;
            }
        });
    }

    static void charge() {
        int time = 0;

        for(Integer cost : costs) {
            if(devices.size() >= m) {
                Device now = devices.remove();
                time = now.end;
            }

            devices.add(new Device(time, time + cost));
        }

        while(!devices.isEmpty()) {
            Device now = devices.remove();
            time = now.end;
        }

        ans = time;
    }
}

class Device {
    int start;
    int end;

    public Device(int start, int end) {
        this.start = start;
        this.end = end;
    }
}