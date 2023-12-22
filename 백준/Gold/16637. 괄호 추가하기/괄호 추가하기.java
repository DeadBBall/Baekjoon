import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, ans;
	static List<Character> operators;
	static List<Integer> numbers;
	
	public static void main(String[] args) {
		input();
		findMaxNumber(0, numbers.get(0));
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		operators = new ArrayList<>();
		numbers = new ArrayList<>();
		ans = Integer.MIN_VALUE;
		
		String formula = SC.next();
		
		for(int formulaIdx = 0; formulaIdx < n; formulaIdx++) {
			
			if(formulaIdx % 2 == 1)
				operators.add(formula.charAt(formulaIdx));
			else
				numbers.add(formula.charAt(formulaIdx) - '0');
		}
		
	}

	static void findMaxNumber(int nowIdx, int sum) {
		if(nowIdx == numbers.size() - 1) {
			ans = Math.max(ans, sum);
			return;
		}
		
		int result = calculate(operators.get(nowIdx), sum, numbers.get(nowIdx + 1));
		findMaxNumber(nowIdx + 1, result);
		
		if(nowIdx < operators.size() - 1) {
			int brackerResult = calculate(operators.get(nowIdx + 1), numbers.get(nowIdx + 1), numbers.get(nowIdx + 2));
			
			result = calculate(operators.get(nowIdx), sum, brackerResult);
			
			findMaxNumber(nowIdx + 2, result);
		}
		
	}
	
	static int calculate(char operator, int left, int right) {
		int result = 0;
		
		if(operator == '+')
			result = left + right;
		else if(operator == '-')
			result = left - right;
		else
			result = left * right;
		
		return result;
	}
	
}