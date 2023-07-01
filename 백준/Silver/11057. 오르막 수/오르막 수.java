import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 길이가 N인 오르막 수의 개수를 10007로 나눈 나머지 구하기
		int N = Integer.parseInt(br.readLine());
		
		// 길이가 i이고 j로 끝나는 오르막 수의 개수 ans[i][j]
		int[][] cnt = new int[N+1][10];
		for (int j=0; j<10; j++) {
			cnt[1][j] = 1;
		}
		for (int i=2; i<=N; i++) {
			for (int j=0; j<10; j++) {
				for (int k=0; k<=j; k++) {
					cnt[i][j] += cnt[i-1][k];
				}
				cnt[i][j] %= 10007;
			}
		}
		
		// 답 출력
		int ans = 0;
		for (int j=0; j<10; j++) {
			ans += cnt[N][j];
		}
		ans %= 10007;
		System.out.println(ans);
	}
}
