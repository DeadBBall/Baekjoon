import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 올라가는 A
		int a = sc.nextInt();
		// 떨어지는 B
		int b = sc.nextInt();
		// 높이
		int v = sc.nextInt();

		//걸리는 날
		int count = 0;

		if((v-b)%(a-b)==0) {
			count = (v-b)/(a-b);
		}else {
			count = ((v-b)/(a-b))+1;
		}
		
		System.out.println(count);
		sc.close();
	}
}
