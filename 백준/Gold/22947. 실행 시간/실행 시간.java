import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, k;
    static int[] times;
    static List<Integer>[] edges;
    static int ans;
    static int[] entryCounts;
    static int endWork;

    public static void main(String[] args) {
        input();
        checkAllCases(2, 0);
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        times = new int[n + 1];
        edges = new ArrayList[n + 1];
        entryCounts = new int[n + 1];
        ans = Integer.MAX_VALUE;

        for(int workIdx = 1; workIdx <= n; workIdx++) {
            times[workIdx] = sc.nextInt();
            edges[workIdx] = new ArrayList();
        }

        for(int edgeIdx = 0; edgeIdx < m; edgeIdx++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            edges[s].add(e);
        }
        for(int start = 1; start <= n; start++) {
        	if(edges[start].size() == 0) {
        		endWork = start;
        		break;
        	}
        }
        countEntry();
    }
    
    static void countEntry() {
    	for(int start = 1; start <= n; start++) {
    		for(int idx = 0; idx < edges[start].size(); idx++) {
    			entryCounts[edges[start].get(idx)]++;
    		}
    	}
    }

    static void checkAllCases(int nowIdx, int count) {
        if(count == k) {
            int result = calculateCompletionTime();
            ans = Math.min(result, ans);
            return;
        }

        if(nowIdx == n + 1) return;

        if(endWork != nowIdx) {
            int orginalTime = times[nowIdx];
            times[nowIdx] = 0;
            checkAllCases(nowIdx + 1, count + 1);
            times[nowIdx] = orginalTime;
        }
        checkAllCases(nowIdx + 1, count);
    }

    static int calculateCompletionTime() {
    	PriorityQueue<Work> workPQ = new PriorityQueue<>(new Comparator<Work>() {
			@Override
			public int compare(Work o1, Work o2) {
				return (o1.startTime + o1.workTime) - (o2.startTime + o2.workTime);
			}
		});
    	int[] copiedEntryCounts = new int[n + 1];
    	for(int workIdx = 1; workIdx <= n; workIdx++) {
    		copiedEntryCounts[workIdx] = entryCounts[workIdx];
    	}
    	
        for(int workIdx = 1; workIdx <= n; workIdx++) {
        	if(copiedEntryCounts[workIdx] == 0)
        		workPQ.add(new Work(0, times[workIdx], workIdx));
        }
        
        int nowTime = 0;
        
        while(!workPQ.isEmpty()) {
        	Work now = workPQ.remove();
        	nowTime = now.startTime + now.workTime;
        	int start = now.idx;
//        	System.out.println(start + " " + nowTime);
        	for(int edgeIdx = 0; edgeIdx < edges[start].size(); edgeIdx++) {
        		int end = edges[start].get(edgeIdx);
        		copiedEntryCounts[end]--;
        		if(copiedEntryCounts[end] == 0)
        			workPQ.add(new Work(nowTime, times[end], end));
        	}
        }
        return nowTime;
    }
    
    static class Work {
    	int startTime;
    	int workTime;
    	int idx;
    	
    	public Work(int startTime, int workTime, int idx) {
    		this.startTime = startTime;
    		this.workTime = workTime;
    		this.idx = idx;
    	}
    }
}