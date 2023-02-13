import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//입력받을 수의 개수
		int n = sc.nextInt();
		
		//입력받는 수를 요소로 갖는 배열
		int[] arr = new int[n];
		
		//수를 입력받아 배열의 요소로 대입
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//삽입 정렬
		for(int i=1; i<n; i++) {
			for(int j=1; j<=i ;j++) {
				if(arr[i-j+1]<arr[i-j]) {
					int num = arr[i-j+1];
					arr[i-j+1] = arr[i-j];
					arr[i-j] = num;
				}else {
					break;
				}
			}
		}
		
		
		//배열 전체 출력
		for(int k = 0;  k<n; k++) {
			System.out.println(arr[k]);
		}
		
		sc.close();
	}
}