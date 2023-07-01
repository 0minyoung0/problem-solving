import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 별로 실행
		while (T-- > 0) {
			
			// 스티커는 2n개
			int n = Integer.parseInt(br.readLine());
			
			// 스티커의 점수
			int[][] sticker = new int[2][n+1];
			for (int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=1; j<=n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// x번째 줄에서 0번행 스티커 사용, 1번행 스티커 사용, 스티커 사용x일때 점수 최대값
			int[][] ans = new int[n+1][3];
			for (int i=1; i<=n; i++) {
				ans[i][0] = sticker[0][i] + Math.max(ans[i-1][1], ans[i-1][2]);
				ans[i][1] = sticker[1][i] + Math.max(ans[i-1][0], ans[i-1][2]);
				ans[i][2] = Math.max(ans[i-1][0], ans[i-1][1]);
			}
			
			// 답 출력
			System.out.println(Math.max(ans[n][0], Math.max(ans[n][1], ans[n][2])));
		}
		
	}
}
