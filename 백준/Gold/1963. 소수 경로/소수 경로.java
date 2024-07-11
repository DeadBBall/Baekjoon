import java.util.*;

public class Main {
    static final int MAX_NUMBER = 10000;
    static Scanner sc = new Scanner(System.in);
    static int origin, target;
    static boolean[] visit, isPrime;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        findPrimeNumber();

        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            findTarget();
        }

        System.out.print(ansMaker);
    }

    static void findPrimeNumber() {
        isPrime = new boolean[MAX_NUMBER];

        Arrays.fill(isPrime, true);

        for(int num = 2; num <= Math.sqrt(MAX_NUMBER); num++) {
            if(!isPrime[num]) continue;

            for(int mul = num * num; mul < MAX_NUMBER; mul += num) {
                isPrime[mul] = false;
            }
        }
    }

    static void input() {
        origin = sc.nextInt();
        target = sc.nextInt();
        visit = new boolean[MAX_NUMBER];
    }

    static void findTarget() {
        PriorityQueue<Password> passwords = new PriorityQueue<>(new Comparator<Password>() {
            @Override
            public int compare(Password o1, Password o2) {
                return o1.dist - o2.dist;
            }
        });

        passwords.add(new Password(origin, 0));

        visit[origin] = true;

        while(!passwords.isEmpty()) {
            Password now = passwords.remove();

            if(now.num == target) {
                ansMaker.append(now.dist).append("\n");
                return;
            }

            for(int idx = 0; idx < 4; idx++) {
                for(int num = 0; num <= 9; num++) {
                    char[] nowNum = String.valueOf(now.num).toCharArray();

                    if((idx == 0 && num == 0) || (num == nowNum[idx] - '0')) continue;

                    nowNum[idx] = (char)(num + '0');

                    int next = Integer.parseInt(String.valueOf(nowNum));

                    if(visit[next] || !isPrime[next]) continue;
                    
                    visit[next] = true;

                    passwords.add(new Password(next, now.dist + 1));
                }
            }
        }

        ansMaker.append("Impossible").append("\n");
    }

}

class Password {
    int num;
    int dist;

    public Password(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }
}