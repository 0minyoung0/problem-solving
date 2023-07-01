import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 포도주 잔의 개수
		int n = Integer.parseInt(br.readLine());
		
		// 포도주의 양
		int[] g = new int[n];
		for (int i=0; i<n; i++) {
			g[i] = Integer.parseInt(br.readLine());
		}
		
		// n이 1이나 2일때는 출력 후 리턴
		if (n == 1) {
			System.out.println(g[0]);
			return;
		}
		if (n == 2) {
			System.out.println(g[0] + g[1]);
			return;
		}
		
		// 해당 잔을 안먹은 경우, 1번째로 먹은 경우, 2번째로 먹은 경우의 최대 포도주 양을 저장
		int[][] ans = new int[n][3];
		ans[0][0] = 0;
		ans[0][1] = g[0];
		ans[1][0] = ans[0][1];
		ans[1][1] = g[1];
		ans[1][2] = ans[0][1] + g[1];
		
		for (int i=2; i<n; i++) {
			ans[i][0] = Math.max(ans[i-1][0], Math.max(ans[i-1][1], ans[i-1][2]));
			ans[i][1] = ans[i-1][0] + g[i];
			ans[i][2] = ans[i-1][1] + g[i];
		}
		
		// 답 출력
		System.out.println(Math.max(ans[n-1][0], Math.max(ans[n-1][1], ans[n-1][2])));
		
	}
}
