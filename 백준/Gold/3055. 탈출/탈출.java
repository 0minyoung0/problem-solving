import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 지도의 크기 R행 C열
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		// 지도 정보
		char[][] map = new char[R][];
		for (int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// BFS를 위한 덱 (index 0 : x좌표, index 1 : y좌표, index 2 : (물 : -1, 고슴도치 : 걸린 시간))
		Deque<int[]> dq = new ArrayDeque<>();
		
		// 고슴도치가 방문한 좌표를 체크할 boolean 배열
		boolean[][] vis = new boolean[R][C];
		
		// 물과 고슴도치를 큐에 넣기
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (map[i][j] == '*') {
					dq.offerFirst(new int[] {i, j, -1});
				}else if (map[i][j] == 'S') {
					dq.offer(new int[] {i, j, 0});
					vis[i][j] = true;
					map[i][j] = '.';
				}
			}
		}
		
		// 델타 배열
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		// BFS로 시뮬레이션
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			
			for (int dir=0; dir<4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				// out of index
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				
				// 물인 경우
				if (cur[2] == -1) {
					
					// 돌, 물, 비버의 굴이 있는 경우
					if (map[nx][ny] != '.') continue;
					
					// 비어있는 곳인 경우
					dq.offer(new int[] {nx, ny, -1});
					map[nx][ny] = '*';
				}
				
				// 고슴도치인 경우
				else { // cur[2] >= 0
					
					// 비버의 굴이 있는 경우
					if (map[nx][ny] == 'D') {
						System.out.println(cur[2] + 1);
						return;
					}
					
					// 방문한 경우
					if (vis[nx][ny]) continue;
					
					// 돌, 물이 있는 경우
					if (map[nx][ny] != '.') continue;
					
					// 비어있는 곳인 경우
					dq.offer(new int[] {nx, ny, cur[2]+1});
					vis[nx][ny] = true;
				}
			}
		}
		
		// 불가능한 경우
		System.out.println("KAKTUS");
	}
}
