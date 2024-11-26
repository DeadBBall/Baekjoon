import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, l;
    static Map<Integer, TrafficLight> trafficLights;

    public static void main(String[] args) {
        input();
        move();
    }

    static void input() {
        n = sc.nextInt();
        l = sc.nextInt();
        trafficLights = new HashMap<>();

        while(n-- > 0) {
            trafficLights.put(sc.nextInt(), new TrafficLight(sc.nextInt(), sc.nextInt()));
        }
    }

    static void move() {
        int time = 0;
        int pos = 0;

        while(pos < l) {
            time++;
            pos++;

            if(trafficLights.containsKey(pos)) {
                TrafficLight now = trafficLights.get(pos);

                if(time % (now.r + now.g) <= now.r) {
                    time += now.r - time % (now.r + now.g);
                }
            }
        }

        System.out.println(time);
    }
}

class TrafficLight {
    int r;
    int g;

    public TrafficLight(int r, int g) {
        this.r = r;
        this.g = g;
    }
}