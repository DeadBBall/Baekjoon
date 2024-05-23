import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static PriorityQueue<Double> scores;
    static StringBuilder ansMaker;

    public static void main(String[] args) throws IOException {
        input();
        chooseStudents();
        System.out.print(ansMaker);
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        scores = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1);
            }
        });

        ansMaker = new StringBuilder();
    }

    static void chooseStudents() throws IOException {
        for(int idx = 0; idx < 7; idx++) {
            scores.add(Double.parseDouble(br.readLine()));
        }

        for(int idx = 7; idx < n; idx++) {
            double now = Double.parseDouble(br.readLine());

            if(scores.peek() > now) {
                scores.remove();
                scores.add(now);
            }
        }

        while(!scores.isEmpty()) {
            ansMaker.insert(0, String.format("%.3f", scores.remove()) + "\n");
        }
    }

}