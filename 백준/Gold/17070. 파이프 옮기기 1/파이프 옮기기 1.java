import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 집의 크기
		int n = Integer.parseInt(br.readLine());
		
		// 벽 데이터
		boolean[][] wall = new boolean[n+1][n+1];
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=n; j++) {
				if (st.nextToken().equals("1")) wall[i][j] = true;
			}
		}
		
		// 경우의 수
		int[][][] ans = new int[n+1][n+1][3];
		ans[1][2][2] = 1;
		for (int i=1; i<=n; i++) {
			for (int j=2; j<=n; j++) {
				if ((i == 1 && j == 2) || wall[i][j]) continue;
				// 대각선
				if (!wall[i-1][j-1] && !wall[i-1][j] && !wall[i][j-1]) {
					ans[i][j][0] = ans[i-1][j-1][0] + ans[i-1][j-1][1] + ans[i-1][j-1][2];
				}
				// 세로
				if (!wall[i-1][j]) {
					ans[i][j][1] = ans[i-1][j][0] + ans[i-1][j][1];
				}
				// 가로
				if (!wall[i][j-1]) {
					ans[i][j][2] = ans[i][j-1][0] + ans[i][j-1][2];
				}
			}
		}
		System.out.println(ans[n][n][0] + ans[n][n][1] + ans[n][n][2]);
		
	}
}
