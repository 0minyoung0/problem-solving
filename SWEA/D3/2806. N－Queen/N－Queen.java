import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int n, ans;
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        
    	// 테스트 케이스 개수
    	int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
        	// 퀸의 개수
        	n = sc.nextInt();
        	// ans 초기화
        	ans = 0;
        	// 놓을 수 없는 위치 체크할 배열
        	boolean[][] impossible = new boolean[n][n];
        	// 백트래킹으로 퀸 놓기
        	bt(0, impossible);
        	
        	// 답 출력
        	System.out.println("#" + t + " " + ans);
        }
    }
	static int[] dx = {1,1,1};
	static int[] dy = {-1,0,1};
	private static void bt(int k, boolean[][] impossible) {
		// 종료조건
		if (k == n) {
			ans++;
			return;
		}
		
		// 퀸 놓기
		for (int i=0; i<n; i++) {
			// 퀸을 못 놓는 위치면 continue
			if (impossible[k][i]) continue;
			
			// impossible 배열 복사
			boolean[][] imp_copy = new boolean[n][n];
			for (int j=0; j<n; j++) {
				imp_copy[j] = Arrays.copyOf(impossible[j], n);
			}
			
			// 주변 8방향으로 impossible 체크하기
			for (int dir=0; dir<3; dir++) {
				int nx = k + dx[dir];
				int ny = i + dy[dir];
				while (0<=nx && nx<n && 0<=ny && ny<n) {
					imp_copy[nx][ny] = true;
					nx += dx[dir];
					ny += dy[dir];
				}
			}
			
			// 다음 재귀 호출
			bt(k+1, imp_copy);
		}
	}
}