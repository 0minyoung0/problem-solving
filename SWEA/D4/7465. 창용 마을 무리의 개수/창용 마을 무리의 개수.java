import java.util.*;

public class Solution {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// 테스트 케이스의 수
    	int T = sc.nextInt();
    	
    	// 각 테스트 케이스 별로 실행
    	for (int t=1; t<=T; t++) {

    		// 창용 마을에 사는 사람 수
    		int N = sc.nextInt();
    		// 서로를 알고 있는 사람의 관계 수
    		int M = sc.nextInt();
    		
    		// 서로를 알고 있는 사람의 관계를 인접 리스트에 담기
    		List<Integer>[] list = new List[N+1];
    		for (int i=1; i<=N; i++) {
    			list[i] = new ArrayList<>();
    		}
    		while (M-- > 0) {
    			int p1 = sc.nextInt();
    			int p2 = sc.nextInt();
    			list[p1].add(p2);
    			list[p2].add(p1);
    		}
    		
    		// 무리의 수를 저장할 변수
    		int ans = 0;
    		
    		// 확인한 사람을 체크할 boolean 배열
    		boolean[] check = new boolean[N+1];
    		
    		// BFS에 사용할 Queue
    		Queue<Integer> q = new ArrayDeque<>();
    		
    		// 순차적으로 BFS를 돌면서 무리의 수 세기
    		for (int i=1; i<=N; i++) {
    			
    			// 확인한 사람이면 continue
    			if (check[i]) continue;
    			
    			// 확인하지 않은 사람이면 체크하고 BFS
    			ans++;
    			check[i] = true;
    			q.offer(i);
    			while (!q.isEmpty()) {
    				int cur = q.poll();
    				
    				// 아는 사람 확인
    				for (int nx : list[cur]) {
    					
    					// 확인한 사람이면 continue
    					if (check[nx]) continue;
    					
    					// 확인하지 않은 사람이면 체크하고 큐에 넣기
    					check[nx] = true;
    					q.offer(nx);
    				}
    			}
    		}
    		
    		// 답 출력
    		System.out.println("#" + t + " " + ans);
    	}
    }
}	
