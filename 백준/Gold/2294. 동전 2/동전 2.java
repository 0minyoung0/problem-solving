import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int INF = 100000000;
		
		// 동전의 종류
		int n = Integer.parseInt(st.nextToken());
		// 만드려는 가치의 합
		int k = Integer.parseInt(st.nextToken());
		
		// 동전의 가치
		int[] v = new int[n+1];
		for (int i=1; i<=n; i++) {
			v[i] = Integer.parseInt(br.readLine());
		}
		
		// i번 동전까지 사용해서 j에 해당하는 가치의 합을 만들 수 있는 최소 코인 수
		int[][] ans = new int[n+1][k+1];
		for (int i=1; i<=k; i++) {
			ans[0][i] = INF;
		}
		
		// DP
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=k; j++) {
				if (v[i] > j) ans[i][j] = ans[i-1][j];
				else ans[i][j] = Math.min(ans[i-1][j], ans[i][j-v[i]] + 1);
			}
		}
		
		// 불가능한 경우
		if (ans[n][k] >= INF) ans[n][k] = -1;
		
		// 답 출력
		System.out.println(ans[n][k]);
	}
}