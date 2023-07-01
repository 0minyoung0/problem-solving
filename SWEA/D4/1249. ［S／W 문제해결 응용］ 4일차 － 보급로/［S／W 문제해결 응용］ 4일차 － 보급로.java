import java.util.*;
 
public class Solution {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        final int INF = 1000000000;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // 다익스트라를 위한 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        	public int compare(int[] o1, int[] o2) {
        		if (o1[0] != o2[0]) return o1[0] - o2[0];
        		if (o1[1] != o2[1]) return o1[1] - o2[1];
        		return o1[2] - o2[2];
        	}
        });
         
        // 테스트 케이스의 수
        int T = sc.nextInt();
         
        // 각 테스트 케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	
        	// 지도의 크기
        	int N = sc.nextInt();
        	
        	// 지도 정보
        	int[][] map = new int[N][N];
        	for (int i=0; i<N; i++) {
        		String input = sc.next();
        		for (int j=0; j<N; j++) {
        			map[i][j] = input.charAt(j) - '0';
        		}
        	}
        	
        	// 최단 거리 정보
        	int[][] ans = new int[N][N];
        	for (int i=0; i<N; i++) {
        		Arrays.fill(ans[i], INF);
        	}
        	ans[0][0] = 0;
        	
        	// 다익스트라
        	pq.offer(new int[] {0, 0, 0});
        	while (!pq.isEmpty()) {
        		int[] cur = pq.poll();
        		int curCost = cur[0];
        		int curX = cur[1];
        		int curY = cur[2];
        		
        		// 최소 비용 정보가 아니면 continue
        		if (curCost != ans[curX][curY]) continue;
        		
        		// 델타 탐색으로 다음 좌표 구하기
        		for (int dir=0; dir<4; dir++) {
        			int nx = curX + dx[dir];
        			int ny = curY + dy[dir];
        			
        			// out of index
        			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        			
        			// 갱신 불가능한 정보면 continue
        			if (ans[nx][ny] <= ans[curX][curY] + map[nx][ny]) continue;
        			
        			// 갱신하기
        			ans[nx][ny] = ans[curX][curY] + map[nx][ny];
        			
        			// 힙에 넣기
        			pq.offer(new int[] {ans[nx][ny], nx, ny});
        		}
        	}
        	
        	// 답 출력
        	System.out.println("#" + t + " " + ans[N-1][N-1]);
        }
    }
}   