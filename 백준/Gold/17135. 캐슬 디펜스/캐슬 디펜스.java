import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D;
	static boolean[][] enemy;
	static int[] position = new int[3];
	static int possibleMax = 0, ans = 0;
	static int[] dx = {0,-1,0};
	static int[] dy = {-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 격자판 행의 수
		N = Integer.parseInt(st.nextToken());
		// 격자판 열의 수
		M = Integer.parseInt(st.nextToken());
		// 궁수의 공격 거리 제한
		D = Integer.parseInt(st.nextToken());
		
		// 초기 격자판의 상태
		enemy = new boolean[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				if (st.nextToken().equals("1")) {
					enemy[i][j] = true;
					possibleMax++;
				}
			}
		}
		
		// 재귀로 궁수를 배치할 열을 선택해서 답 구하기
		decidePosition(0, -1);
		
		// 답 출력
		System.out.println(ans);
	}
	
	private static void decidePosition(int k, int pre) {
		// 궁수 위치를 다 골랐으면
		if (k == 3) {

			// 적 제거 시뮬레이션
			simulation();
			return;
		}
		
		// 궁수 위치 고르기
		for (int i=pre+1; i<M; i++) {
			
			// 모든 적을 잡는 경우를 찾았다면
			if (ans == possibleMax) return;
			
			// 궁수 위치 고르기
			position[k] = i;
			decidePosition(k+1, i);
		}
	}
	
	private static void simulation() {
		// 초기맵 복사
		boolean[][] map = new boolean[N][];
		for (int i=0; i<N; i++) {
			map[i] = Arrays.copyOf(enemy[i], M);
		}

		// 남아있는 적의 수
		int remain = possibleMax;
		
		// 제거한 적의 수
		int score = 0;
		
		// remain이 0이 될때까지 반복
		while (remain > 0) {
			
			// 각 궁수의 위치에서 BFS해서 제거할 적의 위치 찾기
			int[][] enemyPos = new int[3][];
			for (int i=0; i<3; i++) {
				enemyPos[i] = BFS(position[i], map);
			}
			
			// 적 제거 (remain 감소, score 증가)
			for (int i=0; i<3; i++) {
				
				// 제거할 수 있는 적이 없는 경우
				if (enemyPos[i][0] == -1) continue;

				// 적이 있는 경우에만 제거하고 remain 감소, score 증가
				if (map[enemyPos[i][0]][enemyPos[i][1]]) {
					map[enemyPos[i][0]][enemyPos[i][1]] = false;
					remain--;
					score++;
				}
			}
			
			// 적 이동 (remain 감소)
			for (int col=0; col<M; col++) {

				// 마지막 행에 적이 있는 경우 remain 감소
				if (map[N-1][col]) {
					remain--;
				}
				
				// 각 행의 적을 한칸씩 내리기
				for (int row=N-2; row>=0; row--) {
					map[row+1][col] = map[row][col];
				}
			}
			
			// 첫 행 초기화
			Arrays.fill(map[0], false);
		}
		
		// 답 갱신 가능하면 갱신
		if (ans < score) {
			ans = score;
		}
	}
	
	private static int[] BFS(int pos, boolean[][] map) {
		// 바로 앞에 적이 있는 경우
		if (map[N-1][pos]) return new int[] {N-1, pos};
		
		// BFS를 위한 초기화
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {N-1, pos});
		boolean[][] vis = new boolean[N][M];
		vis[N-1][pos] = true;

		// BFS
		for (int dis=2; dis<=D; dis++) {
			
			// 큐의 크기만큼 탐색 돌리기
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				
				for (int dir=0; dir<3; dir++) {
					int nx = cur[0] + dx[dir];
					int ny = cur[1] + dy[dir];
					
					// out of index
					if (nx < 0 || ny < 0 || ny >= M) continue;
					
					// 적이 있는 칸인 경우 해당 좌표 리턴
					if (map[nx][ny]) {
						return new int[] {nx, ny};
					}
					
					// 이미 방문 체크된 경우
					if (vis[nx][ny]) continue;
					
					// 적이 없는 칸인 경우
					q.offer(new int[] {nx, ny});
					vis[nx][ny] = true;
				}
			}
		}
		
		// 제거할 수 있는 적이 없는 경우
		return new int[] {-1, -1};
	}
}
