import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static List<Integer> prices;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        while(sc.hasNextInt()) {
            input();
            findUptrend();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        prices = new ArrayList<>();

        prices.add(100001);
    }

    static void findUptrend() {
        while(n-- > 0) {
            int price = sc.nextInt();

            if(price > prices.get(prices.size() - 1)) {
                prices.add(price);
            } else if(price < prices.get(prices.size() - 1)){
                int left = 0;
                int right = prices.size();

                while(left < right) {
                    int mid = (left + right) >> 1;

                    if(prices.get(mid) < price) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                prices.set(right, price);
            }
        }

        ansMaker.append(prices.size()).append("\n");
    }
}