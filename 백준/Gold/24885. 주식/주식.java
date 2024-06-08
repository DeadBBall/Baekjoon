import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, k;
    static long ans;
    static int[] prices;

    public static void main(String[] args){
        input();
        makeMoney(1, m, 0, 0, 0);
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        prices = new int[n + 1];

        for(int day = 1; day <= n; day++) {
            prices[day] = sc.nextInt();
        }
    }

    static void makeMoney(int today, long money, long debt, long stock, long price) {
        if(today == n) {
            money += prices[today] * stock;
            ans = Math.max(money, ans);
            return;
        }

        if(stock > 0) {
            if(prices[today] > price) {
                //판매
                money += prices[today] * stock;
                stock = 0;
                price = 0;

                //대출 상환
                makeMoney(today + 1, money, debt, stock, price);

                //재대출
                if((money - debt) * (k + 1) >= prices[today]) {
                    money -= debt;
                    debt = money * k;
                    money += debt;
                    price = prices[today];
                    stock = money / price;
                    money %= price;

                    makeMoney(today + 1, money, debt, stock, price);
                }
            }
        } else {
            makeMoney(today + 1, money, debt, stock, price);

            //대출
            if((money - debt) * (k + 1) >= prices[today]) {
                money -= debt;
                debt = money * k;
                money += debt;
                price = prices[today];
                stock = money / price;
                money %= price;

                makeMoney(today + 1, money, debt, stock, price);
            }
        }

    }

}