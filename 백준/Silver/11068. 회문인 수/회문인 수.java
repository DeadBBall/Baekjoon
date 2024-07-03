import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int num;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            ansMaker.append(checkPalindrome() ? 1 : 0).append("\n");
        }

        System.out.print(ansMaker);
    }

    static void input() {
        num = sc.nextInt();
    }

    static boolean checkPalindrome() {
        for(int b = 2; b <= 64; b++) {
            List<Integer> convertedNum = new ArrayList<>();

            int origin = num;

            while(origin > 0) {
                convertedNum.add(0, origin % b);

                origin /= b;
            }
            
            boolean flag = true;

            for(int idx = 0; idx < convertedNum.size() / 2; idx++) {
                if(convertedNum.get(idx) != convertedNum.get(convertedNum.size() - 1 - idx)) {
                    flag = false;
                    break;
                }
            }

            if(flag) return true;
        }

        return false;
    }

}