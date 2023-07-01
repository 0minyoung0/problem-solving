import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 민규가 구매하려고 하는 카드의 개수
		int N = Integer.parseInt(br.readLine());
		
		// 카드가 i개 포함된 카드팩의 가격 P[i]
		int[] P = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		// 1번부터 i번째 카드팩까지만 살수 있을 때 j장의 카드를 사는 최대 비용 ans[i][j]
		int[][] ans = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			for (int j=1; j<i; j++) {
				ans[i][j] = ans[i-1][j];
			}
			for (int j=i; j<=N; j++) {
				ans[i][j] = Math.max(ans[i-1][j], ans[i][j-i] + P[i]);
			}
		}
		
		// 답 출력
		System.out.println(ans[N][N]);
		
	}
}
