import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 델타배열
		int[] dx = {-1,-1,-1,0,0,1,1,1};
		int[] dy = {-1,0,1,-1,1,-1,0,1};
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			// 너비와 높이
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			// 종료조건
			if (w == 0) break;
			
			// 지도 정보
			boolean[][] isLand = new boolean[h][w];
			for (int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<w; j++) {
					if (st.nextToken().equals("1")){
						isLand[i][j] = true;
					}
				}
			}
			
			// 섬의 개수를 저장할 변수
			int ans = 0;
			
			// BFS에 사용할 큐
			Queue<int[]> q = new ArrayDeque<>();
			
			// 방문한 땅을 체크할 boolean 배열
			boolean[][] vis = new boolean[h][w];
			
			// BFS 돌면서 섬의 개수 세기
			for (int i=0; i<h; i++) {
				for (int j=0; j<w; j++) {
					
					// 땅이 아니거나 방문한 땅이면 continue
					if (!isLand[i][j] || vis[i][j]) continue;
					
					// 방문하지 않은 땅이면 ans에 +1하고 BFS 돌리기
					ans++;
					q.offer(new int[] {i, j});
					vis[i][j] = true;
					
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						for (int dir=0; dir<8; dir++) {
							int nx = cur[0] + dx[dir];
							int ny = cur[1] + dy[dir];
							
							// out of index
							if (nx<0 || nx>=h || ny<0 || ny>=w) continue;
							
							// 땅이 아니거나 방문한 땅인 경우
							if (!isLand[nx][ny] || vis[nx][ny]) continue;
							
							// 큐에 넣고 vis 체크
							q.offer(new int[] {nx, ny});
							vis[nx][ny] = true;
						}
					}
				}
			}
			
			// 섬의 개수 스트링 빌더에 저장
			sb.append(ans).append("\n");
		}
		
		// 답 출력
		System.out.println(sb);
	}
}
