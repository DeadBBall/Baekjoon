import java.util.Scanner;

public class Main {
	
	static int switchNum;
	static int[] switches;
	static int studentNum;
	static int[][] students;
	
	static void input() { // input메소드
		Scanner sc = new Scanner(System.in);
		switchNum = sc.nextInt();
		switches = new int[switchNum + 1];
		for(int i = 1; i <= switchNum; i++) {
			switches[i] = sc.nextInt();
		}
		studentNum = sc.nextInt();
		students = new int[studentNum][2];
		for(int i = 0; i < studentNum; i++) {
			students[i][0] = sc.nextInt();
			students[i][1] = sc.nextInt();
		}
	}
	
	static void changeSwithes(int switchIdx) {
		if(switches[switchIdx] == 0) {
			switches[switchIdx] = 1;
		} else {
			switches[switchIdx] = 0;
		}
	}
	
	static void onAndOffSwitches() {
		for(int i = 0; i < studentNum; i++) {
			if(students[i][0] == 1) {
				for(int j = 1; j <= switchNum; j++) {
					if(j % students[i][1] == 0) {
						changeSwithes(j);
					}
				}
			}
			else {
				changeSwithes(students[i][1]);
				for(int j = 1; j <= switchNum / 2; j++) {
					int start = students[i][1] - j;
					int end = students[i][1] + j;
					if(start >= 1 && end <= switchNum && switches[start] == switches[end]) {
						changeSwithes(start);
						changeSwithes(end);
					}
					else {
						break;
					}
				}
			}
		}
	}
	
	static void printAns() {
		for(int i = 1; i <= switchNum; i++) {
			if(i % 20 == 0) {
				System.out.println(switches[i]);
			}
			else {
				System.out.print(switches[i] + " ");				
			}
		}
	}
	
	static void solve() {
		input();
		onAndOffSwitches();
		printAns();
	}
	
	public static void main(String[] args) {
		solve();
	}
}