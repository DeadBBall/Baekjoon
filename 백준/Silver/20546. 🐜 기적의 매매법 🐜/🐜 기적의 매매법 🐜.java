import java.util.*;

public class Main {
    static final int SIZE = 14;
    static Scanner sc = new Scanner(System.in);
    static int startMoney;
    static int[] costs;

    public static void main(String[] args) {
        input();
        makeMoney();
    }

    static void input() {
        startMoney = sc.nextInt();

        costs = new int[SIZE];

        for(int idx = 0; idx < SIZE; idx++) {
            costs[idx] = sc.nextInt();
        }
    }

    static void makeMoney() {
        Account junHyun = new Account(startMoney, 0);
        Account seongMin = new Account(startMoney, 0);

        boolean up = false;
        int len = 0;

        for(int idx = 0; idx < SIZE; idx++) {
            if(costs[idx] <= junHyun.money) {
                junHyun.count += junHyun.money / costs[idx];
                junHyun.money = junHyun.money % costs[idx];
            }

            if(idx != 0) {
                if (up) {
                    if(costs[idx] > costs[idx - 1]) {
                        len++;
                    } else if(costs[idx] < costs[idx - 1]){
                        len = 1;
                        up = false;
                    } else {
                        len = 0;
                    }
                } else {
                    if(costs[idx] < costs[idx - 1]) {
                        len++;
                    } else if(costs[idx] > costs[idx - 1]) {
                        len = 1;
                        up = true;
                    } else {
                        len = 0;
                    }
                }

                if(len == 3) {
                    if(up) {
                        seongMin.money += costs[idx] * seongMin.count;
                        seongMin.count = 0;
                    } else {
                        seongMin.count += seongMin.money / costs[idx];
                        seongMin.money %= costs[idx];
                    }

                    len--;
                }
            }
        }

        junHyun.money += junHyun.count * costs[SIZE - 1];
        seongMin.money += seongMin.count * costs[SIZE - 1];

        if(junHyun.money > seongMin.money) {
            System.out.println("BNP");
        } else if(junHyun.money < seongMin.money) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}

class Account {
    int money;
    int count;

    public Account(int money, int count) {
        this.money = money;
        this.count = count;
    }
}