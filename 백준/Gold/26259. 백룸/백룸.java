import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 방의 크기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 방에 적혀있는 수
		int[][] num = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 가로벽인지 세로벽인지 체크할 변수
		boolean rowWall = false;
		
		// 해당 좌표로 갈때 막혀있는지 확인할 boolean 배열
		boolean[][] isBlocked = new boolean[N][M];
		
		// 벽 정보
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		// 벽이 한쪽 끝에 있는 경우
		if (Math.max(x1, x2) == 0 || Math.max(y1, y2) == 0
			|| Math.min(x1, x2) == N || Math.min(y1, y2) == M) ;
		// 가로벽인 경우
		else if (x1 == x2) {
			// 영원히 도달하지 못하는 경우
			if (Math.abs(y1-y2) == M) {
				System.out.println("Entity");
				return;
			}
			
			rowWall = true;
			for (int i=Math.min(y1, y2); i<Math.max(y1, y2); i++) {
				isBlocked[x1][i] = true;
			}
		}
		// 세로벽인 경우
		else {
			// 영원히 도달하지 못하는 경우
			if (Math.abs(x1-x2) == N) {
				System.out.println("Entity");
				return;
			}
			
			for (int i=Math.min(x1, x2); i<Math.max(x1, x2); i++) {
				isBlocked[i][y1] = true;
			}
		}
		
		// 해당 좌표까지 도달할 수 있는 합의 최댓값
		int[][] ans = new int[N][M];
		for (int i=0; i<N; i++) {
			Arrays.fill(ans[i], -100000000);
		}
		ans[0][0] = num[0][0];
		
		// 가로벽인 경우
		if (rowWall) {
			for (int i=0; i<N; i++){
				for (int j=0; j<M; j++) {
					
					// i,j로 못가는 경우
					if ((i == 0 || ans[i-1][j] == -100000000 || isBlocked[i][j])
					&& (j == 0 || ans[i][j-1] == -100000000)) continue;
					
					// i,j 직전까지 합의 최댓값
					int temp = -100000000;
					
					// 위에서 아래로 가면서 i,j로 갈 수 있는 경우
					if (i != 0 && ans[i-1][j] != -100000000 && !isBlocked[i][j]) {
						temp = ans[i-1][j];
					}
						
					// 왼쪽에서 오른쪽으로 가면서 i,j로 갈 수 있는 경우
					if (j != 0 && ans[i][j-1] != -100000000) {
						if (temp < ans[i][j-1]) temp = ans[i][j-1];
					}
					
					// i,j로 갈때 얻을 수 있는 합의 최댓값
					ans[i][j] = temp + num[i][j];
				}
			}
		}
		// 세로벽인 경우
		else {
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					
					// i,j로 못가는 경우
					if ((i == 0 || ans[i-1][j] == -100000000)
					&& (j == 0 || ans[i][j-1] == -100000000 || isBlocked[i][j])) continue;
					
					// i,j 직전까지 합의 최댓값
					int temp = -100000000;
					
					// 위에서 아래로 가면서 i,j로 갈 수 있는 경우
					if (i != 0 && ans[i-1][j] != -100000000) {
						temp = ans[i-1][j];
					}
					
					// 왼쪽에서 오른쪽으로 가면서 i,j로 갈 수 있는 경우
					if (j != 0 && ans[i][j-1] != -100000000 && !isBlocked[i][j]) {
						if (temp < ans[i][j-1]) temp = ans[i][j-1];
					}
					
					// i,j로 갈때 얻을 수 있는 합의 최댓값
					ans[i][j] = temp + num[i][j];
				}
			}
		}
		
		// 답 출력
		System.out.println(ans[N-1][M-1]);
	}
}