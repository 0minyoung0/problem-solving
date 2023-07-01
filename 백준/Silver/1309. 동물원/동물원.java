import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 우리의 크기
		int N = Integer.parseInt(br.readLine());
		
		// i번째 행에 사자를 안 넣는 경우, 왼쪽에 넣는 경우, 오른쪽에 넣는 경우
		int[][] ans = new int[N+1][3];
		ans[0][0] = 1;
		for (int i=1; i<=N; i++) {
			ans[i][0] = (ans[i-1][0] + ans[i-1][1] + ans[i-1][2]) % 9901;
			ans[i][1] = (ans[i-1][0] + ans[i-1][2]) % 9901;
			ans[i][2] = (ans[i-1][0] + ans[i-1][1]) % 9901;
		}
		
		// 답 출력
		System.out.println((ans[N][0] + ans[N][1] + ans[N][2]) % 9901);
	}
}