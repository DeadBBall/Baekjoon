import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, ans;
	static List<Integer>[] friends;
	static List<Integer> chairmanCandidates;
	
	public static void main(String[] args) {
		input();
		chooseChairman();
		System.out.println(ans + " " + chairmanCandidates.size());
		for(int candidate : chairmanCandidates) {
			System.out.print(candidate + " ");
		}
	}
	
	static void input() {
		n = SC.nextInt();
		friends = new ArrayList[n + 1];
		chairmanCandidates = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		
		for(int friendIdx = 1; friendIdx <= n; friendIdx++) {
			friends[friendIdx] = new ArrayList<>();
		}
		
		while(true) {
			int a = SC.nextInt();
			int b = SC.nextInt();
			
			if(a == -1) break;
			
			friends[a].add(b);
			friends[b].add(a);
		}
		
	}
	
	static void chooseChairman() {
		for(int memberIdx = 1; memberIdx <= n; memberIdx++) {
			int score = countScore(memberIdx);
			
			if(score < ans) {
				ans = score;
				chairmanCandidates.clear();
				chairmanCandidates.add(memberIdx);
			}
			else if(score == ans)
				chairmanCandidates.add(memberIdx);
		}
	}
	
	static int countScore(int member) {
		int score = 0;
		
		boolean[] visit = new boolean[n + 1];
		visit[member] = true;
		
		Queue<Member> memberQueue = new LinkedList<>();
		memberQueue.add(new Member(member, 0));
		
		while(!memberQueue.isEmpty()) {
			Member now = memberQueue.remove();
			score = now.depth;
			
			for(int friend : friends[now.index]) {
				
				if(visit[friend]) continue;

				visit[friend] = true;
				
				memberQueue.add(new Member(friend, now.depth + 1));
			}
			
		}
		
		
		for(int memberIdx = 1; memberIdx <= n; memberIdx++) {
			if(!visit[memberIdx]) return Integer.MAX_VALUE;
		}
		
		return score == 0 ? Integer.MAX_VALUE : score;
	}

}

class Member {
	int index;
	int depth;
	
	public Member(int index, int depth) {
		this.index = index;
		this.depth = depth;
	}
	
}