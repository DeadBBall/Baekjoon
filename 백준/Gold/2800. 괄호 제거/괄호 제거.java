import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String equation;
    static int[][] pars;
    static int parCnt;
    static Set<String> answers;

    public static void main(String[] args){
        input();
        removeParentheses(0, 0, equation.toCharArray());
        printAns();
    }

    static void input() {
        equation = sc.next();

        for(int idx = 0; idx < equation.length(); idx++) {
            if(equation.charAt(idx) == '(') parCnt++;
        }

        pars = new int[parCnt][2];

        int parIdx = 0;

        Stack<Integer> parStack = new Stack<>();

        for(int idx = 0; idx < equation.length(); idx++) {
            if(equation.charAt(idx) == '(') {
                parStack.add(idx);
            } else if(equation.charAt(idx) == ')') {
                pars[parIdx][0] = parStack.pop();
                pars[parIdx++][1] = idx;
            }
        }

        Arrays.sort(pars, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        answers = new HashSet<>();
    }

    static void removeParentheses(int parIdx, int removedParCnt, char[] changedEquation) {
        if(parIdx == parCnt) {
            StringBuilder newEquation = new StringBuilder();

            for(char c : changedEquation) {
                if(c == 0) continue;

                newEquation.append(c);
            }

            if(!newEquation.toString().equals(equation)) {
                answers.add(newEquation.toString());
            }

            return;
        }

        removeParentheses(parIdx + 1, removedParCnt, changedEquation);

        changedEquation[pars[parIdx][0]] = 0;
        changedEquation[pars[parIdx][1]] = 0;

        removeParentheses(parIdx + 1, removedParCnt + 1, changedEquation);

        changedEquation[pars[parIdx][0]] = '(';
        changedEquation[pars[parIdx][1]] = ')';
    }

    static void printAns() {
        StringBuilder ansMaker = new StringBuilder();

        answers.stream().sorted().forEach(ans -> ansMaker.append(ans).append("\n"));

        System.out.print(ansMaker);
    }
}