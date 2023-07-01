import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 0부터 N까지의 정수 K개를 더해서 합이 N이 되는 경우의 수 구하기
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 0부터 N까지의 정수 j개를 더해서 합이 i가 되는 경우의 수 배열 ans[i][j]
		long[][] ans = new long[N+1][K+1];
		Arrays.fill(ans[0], 1);
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=K; j++) {
				for (int k=0; k<=i; k++) {
					ans[i][j] += ans[k][j-1];
				}
				ans[i][j] %= 1000000000;
			}
		}
		
		// 답 출력
		System.out.println(ans[N][K]);
	}
}