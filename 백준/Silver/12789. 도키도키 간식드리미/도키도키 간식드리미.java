import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static Queue<Integer> nowLine;
    static Stack<Integer> spareLine;

    public static void main(String[] args) {
        input();
        System.out.println(giveSnacks() ? "Nice" : "Sad");
    }

    static void input() {
        n = sc.nextInt();
        nowLine = new LinkedList<>();
        spareLine = new Stack<>();

        for(int studentIdx = 0; studentIdx < n; studentIdx++) {
            nowLine.add(sc.nextInt());
        }
    }

    static boolean giveSnacks() {
        int now = 1;

        while(now < n + 1) {
            if(!nowLine.isEmpty() && nowLine.peek() == now) {
                nowLine.remove();
                now++;
            }
            else {
                if(!spareLine.isEmpty() && spareLine.peek() == now) {
                    spareLine.pop();
                    now++;
                }
                else if(nowLine.isEmpty()) {
                    return false;
                }
                else {
                    spareLine.add(nowLine.remove());
                }
            }
        }
        return true;
    }

}