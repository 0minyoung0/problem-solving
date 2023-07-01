import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 동전의 종류의 수
		int n = Integer.parseInt(st.nextToken());
		// 동전의 가치의 합
		int k = Integer.parseInt(st.nextToken());
		
		// 동전의 가치
		int[] value = new int[n];
		for (int i=0; i<n; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		
		// DP를 위한 배열
		int[] ans = new int[k+1];
		ans[0] = 1;
		for (int i=0; i<n; i++) {
			for (int j=value[i]; j<=k; j++) {
				ans[j] += ans[j-value[i]];
			}
		}
		
		// 답 출력
		System.out.println(ans[k]);
	}
}
