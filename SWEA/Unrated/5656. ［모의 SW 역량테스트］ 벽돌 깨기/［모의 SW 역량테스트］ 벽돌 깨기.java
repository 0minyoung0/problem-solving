import java.util.*;

public class Solution {
	
	static int N, W, H, ans;
	
	// 탐색을 위한 델타배열 (위, 오른쪽, 아래, 왼쪽)
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수
		int T = sc.nextInt();
		
		// 테스트 케이스 별로 실행
		for (int tc=1; tc<=T; tc++) {
			
			// 구슬을 쏘는 횟수
			N = sc.nextInt();
			// 배열의 너비와 높이
			W = sc.nextInt();
			H = sc.nextInt();
			
			// 벽돌 개수
			int score = 0;
			
			// 벽돌 정보
			int[][] brick = new int[H][W];
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					brick[i][j] = sc.nextInt();
					if (brick[i][j] != 0) score++;
				}
			}
			
			// 최대한 많은 벽돌을 제거했을 때 남은 벽돌의 개수를 저장할 변수
			ans = score - N;
			
			// ans의 초기값이 0이하라면 출력 후 continue
			if (ans <= 0) {
				System.out.println("#" + tc + " 0");
				continue;
			}
			
			// 백트래킹으로 벽돌깨기!
			backTracking(1, brick, score);
			
			// 답 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	private static void backTracking(int k, int[][] map, int score) {
		// 이미 모든 벽돌을 부술 수 있는 경우를 찾았다면 리턴
		if (ans == 0) return;
		
		// k번째 구슬을 j열에 쏘기
		for (int j=0; j<W; j++) {
			
			// 깰 벽돌 찾기
			int i = 0;
			while (i < H && map[i][j] == 0) {
				i++;
			}
			
			// 깰 벽돌이 없으면 continue
			if (i == H) continue;
			
			// 맵 복사
			int[][] newMap = new int[H][W];
			for (int x=0; x<H; x++) {
				newMap[x] = Arrays.copyOf(map[x], W);
			}
			
			// 이번 시뮬레이션에서의 score
			int newScore = score;
			
			// 깰 벽돌을 큐에 넣고 돌리면서 연쇄로 깨기
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {i, j, newMap[i][j]});
			newMap[i][j] = 0;
			newScore--;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				for (int dir=0; dir<4; dir++) {
					int nx = cur[0];
					int ny = cur[1];
					
					for (int l=2; l<=cur[2]; l++) {
						nx += dx[dir];
						ny += dy[dir];
						
						// out of index
						if (nx < 0 || nx >= H || ny < 0 || ny >= W) break;
						
						// 벽돌이 없는 경우
						if (newMap[nx][ny] == 0) continue;
						
						// 벽돌 깨기
						q.offer(new int[] {nx, ny, newMap[nx][ny]});
						newMap[nx][ny] = 0;
						newScore--;
					}
				}
			}
			
			// score 갱신가능하면 갱신
			if (ans > newScore) {
				ans = newScore;
			}
			
			// N번째 구슬이었으면 return
			if (k == N) continue;
			
			// 투포인터로 벽돌 밑으로 떨어뜨리기
			for (int y=0; y<W; y++) {
				
				// 벽돌을 집을 포인터
				int grab = H-1;
				// 벽돌을 내려놓을 포인터
				int put = H-1;
				
				while (grab >= 0) {
					// 집을 벽돌이 있으면
					if (newMap[grab][y] != 0) {
						
						// 두 포인터가 다르다면 벽돌 옮기기
						if (grab != put) {
							newMap[put][y] = newMap[grab][y];
							newMap[grab][y] = 0;
						}
						
						// put 포인터 위로 옮기기
						put--;
					}
					
					// grab 포인터 위로 옮기기
					grab--;
				}
			}
			
			// 아직 쏠 구슬이 남았으면 재귀 호출
			backTracking(k+1, newMap, newScore);
		}
	}
}
