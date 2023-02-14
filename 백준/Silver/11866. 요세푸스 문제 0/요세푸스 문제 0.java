import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		//N을  입력받음
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		//int형 queue 선언
		Queue<Integer> queue = new LinkedList<Integer>();
		//결과출력용
		Queue<Integer> result = new LinkedList<Integer>();
		//1부터 N까지의 수를 하나씩 추가함
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		
		//N=1의 경우 실행하지 않기 때문에 그대로 출력
		if(queue.size()==1) {
			result = queue;
		//N=1이 아닌 경우
		}else {
			//큐의 원소 개수가 1이 아니라면 1이 될때까지 진행
			while(!queue.isEmpty()) {
				//제일 먼저 들어간 수를 제거하고 뒤에 추가
				for(int n = 1; n < K; n++) {
				queue.offer(queue.poll());
				}result.offer(queue.poll());
			}
			
		}
		System.out.print("<");
		for(int	i=1; i<N; i++) {
			System.out.print(result.poll()+", ");	
		}
		System.out.print(result.poll());
		System.out.print(">");
	}
}