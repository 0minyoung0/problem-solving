import java.io.*;
import java.util.*;

public class Main {
	static int N, temp, ans;
	static int[][] W;
	static boolean[] vis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 도시의 수
		N = Integer.parseInt(br.readLine());
		
		// 도시 i에서 도시 j로 가기 위한 비용 W[i][j]
		W = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 도시 방문 표시
		vis = new boolean[N];
		vis[0] = true;
		
		// 순회하는데에 필요한 최소 비용
		ans = 1000000 * N;
		
		// 백트래킹으로 도시 방문 순서 정해서 최소 비용 갱신
		BT(1, 0);
		
		// 답 출력
		System.out.println(ans);
	}
	
	private static void BT(int k, int pre) {
		
		// 최소 비용 갱신하고 리턴
		if (k == N) {
			if (W[pre][0] == 0) return;
			temp += W[pre][0];
			if (ans > temp) ans = temp;
			temp -= W[pre][0];
			return;
		}
		
		for (int i=1; i<N; i++) {
			if (vis[i] || W[pre][i] == 0) continue;
			vis[i] = true;
			temp += W[pre][i];
			if (ans > temp) BT(k+1, i);
			temp -= W[pre][i];
			vis[i] = false;
		}
	}
}
