import java.util.*;

public class Main {
    static final String UNDO = "undo";
    static Scanner sc = new Scanner(System.in);
    static int n;
    static Text[] texts;

    public static void main(String[] args){
        input();
        useProgram();
        System.out.println(texts[n].content);
    }

    static void input() {
        n = sc.nextInt();
        texts = new Text[n + 1];
        texts[0] = new Text("", 0);
    }

    static void useProgram() {
        for(int orderIdx = 1; orderIdx <= n; orderIdx++) {
            String order = sc.next();

            if(order.equals(UNDO)) {
                int t = sc.nextInt();
                int time = sc.nextInt();

                int prevIdx = orderIdx - 1;

                while(prevIdx >= 0) {
                    if(prevIdx == 0) {
                        texts[orderIdx] = new Text("", time);
                    }
                    else if(time - t > texts[prevIdx].time) {
                        texts[orderIdx] = new Text(texts[prevIdx].content, time);
                        break;
                    }

                    prevIdx--;
                }

            } else {
                String inputStr = sc.next();
                int time = sc.nextInt();

                texts[orderIdx] = new Text(texts[orderIdx - 1].content + inputStr, time);
            }
        }
    }

}

class Text {
    String content;
    int time;

    Text(String content, int time) {
        this.content = content;
        this.time = time;
    }
}