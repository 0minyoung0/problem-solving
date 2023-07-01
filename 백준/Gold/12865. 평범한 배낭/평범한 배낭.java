import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 물품의 수
		int N = Integer.parseInt(st.nextToken());
		// 준서가 버틸 수 있는 무게
		int K = Integer.parseInt(st.nextToken());
		
		// 각 물건의 무게와 해당 물건의 가치
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		// DP 배낭문제
		int[][] ans = new int[N+1][K+1];
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=K; j++) {
				if (j < W[i]) ans[i][j] = ans[i-1][j];
				else ans[i][j] = Math.max(ans[i-1][j-W[i]] + V[i], ans[i-1][j]);
			}
		}
		
		// 답 출력
		System.out.println(ans[N][K]);
	}
}
