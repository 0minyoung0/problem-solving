import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 델타배열
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		// 테스트 케이스 개수
		int T = sc.nextInt();
		
		// 테스트 케이스 별로 실행
		for (int tc=1; tc<=T; tc++) {
			
			// 지도의 한 변의 길이
			int N = sc.nextInt();
			// 최대 공사 가능 깊이
			int K = sc.nextInt();
			
			// 지도 정보, 가장 높은 봉우리의 높이
			int[][] map = new int[N][N];
			int max_height = 1;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					if (max_height < map[i][j]) max_height = map[i][j];
				}
			}
			
			// 가장 높은 봉우리의 좌표를 리스트에 저장
			List<int[]> list = new ArrayList<>();
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (map[i][j] == max_height) list.add(new int[] {i, j, 1});
				}
			}
			
			// 가장 긴 등산로의 길이를 저장할 변수
			int ans = 1;
			
			// x,y 좌표의 지형을 z만큼 깎는 경우에 대해 시뮬레이션
			for (int x=0; x<N; x++) {
				for (int y=0; y<N; y++) {
					for (int z=Math.min(K, map[x][y]); z>0; z--) {
						
						// 지형 깎기
						map[x][y] -= z;
						
						// 이번 시뮬레이션에서 가장 긴 등산로의 길이를 저장할 변수
						int temp = 1;
						
						// 시뮬레이션
						Queue<int[]> q = new ArrayDeque<>();
						for (int[] startData : list) {
							q.offer(startData);
						}
						
						while (!q.isEmpty()) {
							int[] cur = q.poll();
							if (temp < cur[2]) temp = cur[2];
							
							for (int dir=0; dir<4; dir++) {
								int nx = cur[0] + dx[dir];
								int ny = cur[1] + dy[dir];
								
								// out of index
								if (nx<0 || nx>=N || ny<0 || ny>=N) continue;
								
								// 연결할 수 없는 경우
								if (map[nx][ny] >= map[cur[0]][cur[1]]) continue;
								
								// 큐에 현재 등산로 길이와 함께 저장
								q.offer(new int[] {nx, ny, cur[2]+1});
							}
						}
						
						// 이번에 구한 등산로의 길이가 ans보다 크다면 갱신
						if (ans < temp) ans = temp;
						
						// 지형 복구
						map[x][y] += z;
					}
				}
			}
			
			// 답 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
}