import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int m, n;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        playNumber();
        System.out.println(ansMaker);
    }
    static void input() {
        m = sc.nextInt();
        n = sc.nextInt();
        ansMaker = new StringBuilder();
    }

    static void playNumber() {
        Integer[] numbers = new Integer[n - m + 1];
        for(int idx = m; idx <= n; idx++) {
            numbers[idx - m] = idx;
        }
        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return convertToString(o1).compareTo(convertToString(o2));
            }
        });
        for(int idx = 0; idx < numbers.length; idx++) {
            ansMaker.append(numbers[idx] + " ");
            if((idx + 1) % 10 == 0)
                ansMaker.append("\n");
        }

    }

    static String convertToString(int num) {
        StringBuilder numberMaker = new StringBuilder();
        String number = String.valueOf(num);

        for(int idx = 0; idx < number.length(); idx++) {
            switch (number.charAt(idx)) {
                case '0':
                    numberMaker.append("zero ");
                    break;
                case '1':
                    numberMaker.append("one ");
                    break;
                case '2':
                    numberMaker.append("two ");
                    break;
                case '3':
                    numberMaker.append("three ");
                    break;
                case '4':
                    numberMaker.append("four ");
                    break;
                case '5':
                    numberMaker.append("five ");
                    break;
                case '6':
                    numberMaker.append("six ");
                    break;
                case '7':
                    numberMaker.append("seven ");
                    break;
                case '8':
                    numberMaker.append("eight ");
                    break;
                case '9':
                    numberMaker.append("nine ");
                    break;
            }
        }
        numberMaker.deleteCharAt(numberMaker.length() - 1);
        return numberMaker.toString();
    }

}