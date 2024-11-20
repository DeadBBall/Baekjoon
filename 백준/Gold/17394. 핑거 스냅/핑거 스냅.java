import java.util.*;

public class Main {
    static final int MAX_NUMBER = 100000;
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static Set<Integer> primeNumbers;
    static int n, a, b;

    public static void main(String[] args) {
        findPrimeNumber();

        int t = sc.nextInt();

        while(t-- > 0) {
            input();

            if(containsPrime()) {
                fingerSnap();
            } else {
                ansMaker.append(-1).append("\n");
            }
        }

        System.out.print(ansMaker);
    }

    static void findPrimeNumber() {
        primeNumbers = new HashSet<>();

        boolean[] isComposite = new boolean[MAX_NUMBER + 1];

        isComposite[1] = true;

        for (int i = 2; i <= Math.sqrt(MAX_NUMBER); i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= MAX_NUMBER; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        for(int i = 2; i <= MAX_NUMBER; i++) {
            if(!isComposite[i]) {
                primeNumbers.add(i);
            }
        }
    }

    static void input() {
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
    }

    static boolean containsPrime() {
        for(int num = a; num <= b; num++) {
            if(primeNumbers.contains(num)) return true;
        }

        return false;
    }

    static void fingerSnap() {
        Queue<Integer> populationQueue = new LinkedList<>();
        populationQueue.add(n);

        boolean[] visit = new boolean[1_000_001];
        visit[n] = true;

        int fingerSnapCount = 0;

        while(!populationQueue.isEmpty()) {
            int size = populationQueue.size();

            for(int i = 0; i < size; i++) {
                int now = populationQueue.remove();

                if(primeNumbers.contains(now) && now >= a && now <= b) {
                    ansMaker.append(fingerSnapCount).append("\n");
                    return;
                }

                if(!visit[now / 3]) {
                    visit[now / 3] = true;
                    populationQueue.add(now / 3);
                }

                if(!visit[now / 2]) {
                    visit[now / 2] = true;
                    populationQueue.add(now / 2);
                }

                if(now > 0 && !visit[now - 1]) {
                    visit[now - 1] = true;
                    populationQueue.add(now - 1);
                }

                if(now < 1_000_000 && !visit[now + 1]) {
                    visit[now + 1] = true;
                    populationQueue.add(now + 1);
                }
            }

            fingerSnapCount++;
        }

        ansMaker.append(-1).append("\n");
    }
}