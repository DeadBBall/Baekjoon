import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static String variableName;
	static StringBuilder ansMaker;
	static boolean isError;
	
	public static void main(String[] args) {
		input();
		System.out.println(changeVariableName() ? ansMaker : "Error!");
	}

	static void input() {
		variableName = SC.next();
		ansMaker = new StringBuilder();
	}
	
	static boolean changeVariableName() {
		for(int variableNameIdx = 0; variableNameIdx < variableName.length(); variableNameIdx++) {
			char now = variableName.charAt(variableNameIdx);
			
			if(variableNameIdx == 0 && !(now >= 'a' && now <= 'z'))
				return false;
			
			if(now == '_')
				return changeToJava(variableNameIdx);
			else if('A' <= now && 'Z' >= now)
				return changeToCPP(variableNameIdx);
			
			ansMaker.append(now);
		}
		return true;
	}
	
	static boolean changeToCPP(int idx) {
		for(int variableNameIdx = idx; variableNameIdx < variableName.length(); variableNameIdx++) {
			char now = variableName.charAt(variableNameIdx);
			
			if('A' <= now && 'Z' >= now)
				ansMaker.append('_').append((char)(now - 'A' + 'a'));
			else if('a' <= now && 'z' >= now)
				ansMaker.append(now);
			else
				return false;
		}
		return true;
	}
	
	static boolean changeToJava(int idx) {
		for(int variableNameIdx = idx; variableNameIdx < variableName.length(); variableNameIdx++) {
			char now = variableName.charAt(variableNameIdx);
			
			if(now == '_') {
				if(variableNameIdx + 1 == variableName.length()) return false;
				
				variableNameIdx++;
				char next = variableName.charAt(variableNameIdx);
				
				if(!('a' <= next && next <= 'z')) return false;
				
				ansMaker.append((char)(next - 'a' + 'A'));
			}
			else if('a' <= now && 'z' >= now)
				ansMaker.append(now);
			else
				return false;
		}
		return true;
	}
}