import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 델타 배열
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		// 세로의 크기와 가로의 크기
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// 각 지점의 높이
		int[][] h = new int[M][N];
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				h[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 각 지점으로 도달할 수 있는 경우의 수
		int[][] ans = new int[M][N];
		ans[0][0] = 1;
		
		// 각 지점의 높이, x좌표, y좌표를 저장할 우선순위 큐
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) return o2[0] - o1[0];
				if (o1[1] != o2[1]) return o1[1] - o2[1];
				return o1[2] - o2[2];
			}
		});
		pq.offer(new int[] {h[0][0], 0, 0});
		
		// 방문 여부를 체크할 boolean 배열
		boolean[][] vis = new boolean[M][N];
		
		// 높은 지점부터 힙에서 뽑으면서 더 낮은 인접한 영역에 경우의 수 더해주고 힙에 넣기
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (vis[cur[1]][cur[2]]) continue;
			vis[cur[1]][cur[2]] = true;
			
			if (cur[1] == M - 1 && cur[2] == N - 1) break;
			for (int dir=0; dir<4; dir++) {
				int nx = cur[1] + dx[dir];
				int ny = cur[2] + dy[dir];
				if (nx<0 || nx>=M || ny<0 || ny>=N) continue;
				if (cur[0] <= h[nx][ny]) continue;
				ans[nx][ny] += ans[cur[1]][cur[2]];
				pq.offer(new int[] {h[nx][ny], nx, ny});
			}
		}
		
		// 답 출력
		System.out.println(ans[M-1][N-1]);
	}
}
