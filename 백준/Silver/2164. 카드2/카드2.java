
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		//N을  입력받음
		int N = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//1부터 N까지의 수를 하나씩 추가함
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		//결과값
		int result =0;
		
		//N=1의 경우 실행하지 않기 때문에 그대로 출력
		if(queue.size()==1) {
			result = 1;
		//N=1이 아닌 경우
		}else {
			//큐의 원소 개수가 1이 아니라면 1이 될때까지 진행
			while(queue.size()!=1) {
				//제일 먼저 들어간 수를 제거
				queue.poll();
				//그 다음 수를 num에 지정
				int num =queue.peek();
				//그 다음 수를 제거
				queue.poll();
				//num을 끝에 다시 대입
				queue.add(num);
		}
			//남은 한가지를 뽑아서 확인
			result = queue.peek();
		}
		
		System.out.println(result);
	}
}