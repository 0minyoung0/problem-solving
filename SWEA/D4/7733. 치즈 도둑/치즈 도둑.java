import java.util.*;

public class Solution {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// BFS를 위한 델타 배열
    	int[] dx = {-1,1,0,0};
    	int[] dy = {0,0,-1,1};
    	
    	// 테스트 케이스의 수
    	int T = sc.nextInt();
    	
    	// 각 테스트 케이스 별로 실행
    	for (int t=1; t<=T; t++) {
    		
    		// 치즈의 한 변의 길이
    		int N = sc.nextInt();
    		
    		// 치즈의 맛있는 정도
    		int[][] cheeze = new int[N][N];
    		for (int i=0; i<N; i++) {
    			for (int j=0; j<N; j++) {
    				cheeze[i][j] = sc.nextInt();
    			}
    		}
    		
    		// 치즈 덩어리의 최대값
    		int ans = 1;
    		
    		// 치즈 먹기 시뮬레이션
    		for (int day=1; day<=100; day++) {
    			
    			// day와 같은 숫자의 치즈 없애기
    			for (int i=0; i<N; i++) {
    				for (int j=0; j<N; j++) {
    					if (cheeze[i][j] == day) cheeze[i][j] = 0;
    				}
    			}
    			
    			// 해당 day의 치즈 덩어리 개수
    			int temp = 0;
    			
    			// 치즈 덩어리 세기
    			boolean[][] check = new boolean[N][N];
    			for (int i=0; i<N; i++) {
    				for (int j=0; j<N; j++) {
    					// 체크 되어있거나 치즈가 없으면 continue
    					if (check[i][j] || cheeze[i][j] == 0) continue;
    					
    					// 체크 안된 치즈라면 BFS 초기조건 만들기
    					temp++;
    					Queue<int[]> q = new ArrayDeque<>();
    					q.offer(new int[] {i, j});
    					check[i][j] = true;
    					
    					// BFS
    					while (!q.isEmpty()) {
    						int[] cur = q.poll();
    						for (int dir=0; dir<4; dir++) {
    							int nx = cur[0] + dx[dir];
    							int ny = cur[1] + dy[dir];
    							
    							// out of index
    							if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
    							
    							// 체크 되어있거나 치즈가 없는 경우
    							if (check[nx][ny] || cheeze[nx][ny] == 0) continue;
    							
    							// 치즈 큐에 넣고 체크하기
    							q.offer(new int[] {nx, ny});
    							check[nx][ny] = true;
    						}
    					}
    				}
    			}
    			
    			// 치즈 덩어리 개수가 0이면 치즈 먹기 시뮬레이션 그만하기
    			if (temp == 0) break;
    			
    			// 치즈 덩어리 개수가 ans 보다 크다면 갱신하기
    			if (ans < temp) ans = temp;
    		}
    		
    		// 답 출력
    		System.out.println("#" + t + " " + ans);
    	}
    }
}	
