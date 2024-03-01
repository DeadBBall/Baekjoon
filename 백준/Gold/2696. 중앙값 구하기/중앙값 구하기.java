import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static PriorityQueue<Integer> highPQ = new PriorityQueue<>();
    static PriorityQueue<Integer> lowPQ = new PriorityQueue<>(Collections.reverseOrder());
    static int m;

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            getMedian();
            ansMaker.append("\n");
        }

        System.out.print(ansMaker);
    }

    static void input() {
        m = sc.nextInt();
        highPQ.clear();
        lowPQ.clear();
    }

    static void getMedian() {
        ansMaker.append((m + 1) >> 1).append("\n");

        for(int numIdx = 1; numIdx <= m; numIdx++) {
            int num = sc.nextInt();

            if(numIdx == 1) {
                lowPQ.add(num);
                ansMaker.append(lowPQ.peek()).append(" ");
            }

            else if(numIdx == 2) {
                if(lowPQ.peek() > num) {
                    highPQ.add(lowPQ.remove());
                    lowPQ.add(num);
                }
                else {
                    highPQ.add(num);
                }
            }

            else {
                if(numIdx % 20 == 1) {
                    ansMaker.append("\n");
                }

                if(numIdx % 2 == 1) {
                    if(highPQ.peek() < num) {
                        lowPQ.add(highPQ.remove());
                        highPQ.add(num);
                    }
                    else {
                        lowPQ.add(num);
                    }

                    ansMaker.append(lowPQ.peek()).append(" ");
                }

                else {
                    if(lowPQ.peek() > num) {
                        highPQ.add(lowPQ.remove());
                        lowPQ.add(num);
                    }
                    else {
                        highPQ.add(num);
                    }
                }
            }
        }
    }
}