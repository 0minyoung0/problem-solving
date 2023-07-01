import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dx = {-1, 0, 0, 1};
		int[] dy = {0, -1, 1, 0};
		
		// 각 방향으로 연결되어 있지 않은 구조물 번호
		int[][] unconnected = {{3,5,6}, {2,4,5}, {2,6,7}, {3,4,7}};
		
		// 테스트 케이스 개수
		int T = sc.nextInt();
		
		// 테스트 케이스 별로 실행
		for (int tc=1; tc<=T; tc++) {
			
			// 지하터널 지도의 세로, 가로 크기
			int N = sc.nextInt();
			int M = sc.nextInt();
			// 맨홀 뚜껑이 위치한 세로, 가로 위치
			int R = sc.nextInt();
			int C = sc.nextInt();
			// 탈출 후 소요된 시간
			int L = sc.nextInt();
			
			// 지하터널 지도 정보
			int[][] map = new int[N][M];
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 거리 정보
			int[][] dis = new int[N][M];
			
			// 맨홀 뚜껑에서부터 BFS
			int ans = 1;
			dis[R][C] = 1;
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {R, C});
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int curX = cur[0];
				int curY = cur[1];
				
				// 소요 시간이 되면 더 이상의 탐색 X
				if (dis[curX][curY] >= L) continue;
				
				int curS = map[curX][curY];
				
				dir: for (int dir=0; dir<4; dir++) {
					// 현재 있는 위치의 구조물로 갈 수 없는 위치
					for (int i=0; i<3; i++) {
						if (curS == unconnected[dir][i]) continue dir;
					}
					
					int nx = curX + dx[dir];
					int ny = curY + dy[dir];
					
					// out of index
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					
					// 구조물이 없는 경우
					if (map[nx][ny] == 0) continue;
					
					// 이미 방문한 경우
					if (dis[nx][ny] > 0) continue;
					
					// 도착하는 위치의 구조물이 현재 있는 위치의 구조물과 이어지지 않은 경우
					for (int i=0; i<3; i++) {
						if (map[nx][ny] == unconnected[3-dir][i]) continue dir;
					}
					
					// 이동 가능하므로 거리 계산 후 큐에 넣기
					ans++;
					dis[nx][ny] = dis[curX][curY] + 1;
					q.offer(new int[] {nx, ny});
				}
			}
			
			// 답 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
}
