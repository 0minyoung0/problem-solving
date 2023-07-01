import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		// 모눈종이의 크기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 치즈
		int remain = 0;
		boolean[][] cheeze = new boolean[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				if (st.nextToken().equals("1")) {
					cheeze[i][j] = true;
					remain++;
				}
			}
		}
		
		// 치즈가 모두 녹을때까지 걸리는 시간을 저장할 배열
		int ans = 0;
		
		// 치즈가 모두 녹아 없어질때까지 시뮬레이션
		while (true) {
			
			// 종료조건
			if (remain == 0) {
				System.out.println(ans);
				return;
			}
			
			// ans 1 증가
			ans++;
			
			// 외부 공기와 맞닿은 횟수를 체크할 배열
			int[][] cnt = new int[N][M];
			
			// (0,0)에서부터 BFS하며 치즈와 닿으면 cnt배열에 체크
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {0, 0});
			boolean[][] vis = new boolean[N][M];
			vis[0][0] = true;
			
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				for (int dir=0; dir<4; dir++) {
					int nx = cur[0] + dx[dir];
					int ny = cur[1] + dy[dir];
					
					// out of index
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					
					// 방문한 외부 공기 칸
					if (vis[nx][ny]) continue;
					
					// 치즈가 있는 칸
					if (cheeze[nx][ny]) {
						cnt[nx][ny]++;
						continue;
					}
					
					// 외부 공기 칸
					q.offer(new int[] {nx, ny});
					vis[nx][ny] = true;
				}
			}
			
			// cnt가 2이상인 칸의 치즈를 제거
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (cnt[i][j] >= 2) {
						cheeze[i][j] = false;
						remain--;
					}
				}
			}
		}
	}
}
